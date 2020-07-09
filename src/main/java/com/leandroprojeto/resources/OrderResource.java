package com.leandroprojeto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandroprojeto.entites.Order;
import com.leandroprojeto.services.OrderService;

@RestController
@RequestMapping(value ="/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	//requisição do tipo get {diz que vai aceitar a requisição com um valor id}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
	Order obj = service.findById(id);
	return ResponseEntity.ok().body(obj);
	}
}
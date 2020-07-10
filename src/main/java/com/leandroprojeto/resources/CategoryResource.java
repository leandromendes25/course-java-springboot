package com.leandroprojeto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandroprojeto.entites.Category;
import com.leandroprojeto.services.CategoryService;

@RestController
@RequestMapping(value ="/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	//requisição do tipo get {diz que vai aceitar a requisição com um valor id}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
	Category obj = service.findById(id);
	return ResponseEntity.ok().body(obj);
	}
}
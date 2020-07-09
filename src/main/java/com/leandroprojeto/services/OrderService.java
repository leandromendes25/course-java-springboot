package com.leandroprojeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandroprojeto.entites.Order;
import com.leandroprojeto.repositories.OrderRepository;
//Registra a classe como um componente Spring e permitindo ser injetado junto do Autowired
//@Component
//Para deixar mais semanticamente mais especifico vamos utilizar O service, que também é um componente
@Service
public class OrderService {

@Autowired
private OrderRepository repository;

public List<Order>findAll(){
	return repository.findAll();
}
public Order findById(Long id) {
	Optional<Order> obj = repository.findById(id);
	return obj.get();
}
}

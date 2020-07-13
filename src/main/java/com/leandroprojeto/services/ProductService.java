package com.leandroprojeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandroprojeto.entites.Product;
import com.leandroprojeto.repositories.ProductRepository;
//Registra a classe como um componente Spring e permitindo ser injetado junto do Autowired
//@Component
//Para deixar mais semanticamente mais especifico vamos utilizar O service, que também é um componente
@Service
public class ProductService {

@Autowired
private ProductRepository repository;

public List<Product>findAll(){
	return repository.findAll();
}
public Product findById(Long id) {
	Optional<Product> obj = repository.findById(id);
	return obj.get();
}
}

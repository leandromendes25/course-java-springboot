package com.leandroprojeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandroprojeto.entites.Category;
import com.leandroprojeto.repositories.CategoryRepository;
//Registra a classe como um componente Spring e permitindo ser injetado junto do Autowired
//@Component
//Para deixar mais semanticamente mais especifico vamos utilizar O service, que também é um componente
@Service
public class CategoryService {

@Autowired
private CategoryRepository repository;

public List<Category>findAll(){
	return repository.findAll();
}
public Category findById(Long id) {
	Optional<Category> obj = repository.findById(id);
	return obj.get();
}
}

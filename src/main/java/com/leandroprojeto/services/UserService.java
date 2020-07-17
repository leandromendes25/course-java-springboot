package com.leandroprojeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandroprojeto.entites.User;
import com.leandroprojeto.repositories.UserRepository;
//Registra a classe como um componente Spring e permitindo ser injetado junto do Autowired
//@Component
//Para deixar mais semanticamente mais especifico vamos utilizar O service, que também é um componente
@Service
public class UserService {

@Autowired
private UserRepository repository;

public List<User>findAll(){
	return repository.findAll();
}
public User findById(Long id) {
	Optional<User> obj = repository.findById(id);
	return obj.get();
}
public User insert(User obj) {
	return repository.save(obj);
}

}

package com.leandroprojeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.leandroprojeto.entites.User;
import com.leandroprojeto.repositories.UserRepository;
import com.leandroprojeto.services.exceptions.DataBaseException;
import com.leandroprojeto.services.exceptions.ResourceNotFoundException;

//Registra a classe como um componente Spring e permitindo ser injetado junto do Autowired
//@Component
//Para deixar mais semanticamente mais especifico vamos utilizar O service, que também é um componente
@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		//vai tentar get se não tiver usuario vai lançar a excessão
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		
		try {
			repository.deleteById(id);
			//RuntimeException,podemos usá-lo para capturar o erro, como o empty
		}catch(EmptyResultDataAccessException e) {//captruamos a excessão
			throw new ResourceNotFoundException(id);// e a tratamos
		}catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public User update(Long id, User obj) {
		// GetOne não vai no banco, ele so vai deixar obj monitorado pelo JPA(entity)
		// para trabalha nele.
		// pegar os valoes do entity e atualizar com o obj
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}

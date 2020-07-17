package com.leandroprojeto.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.leandroprojeto.entites.User;
import com.leandroprojeto.services.UserService;

@RestController
@RequestMapping(value ="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	//requisição do tipo get {diz que vai aceitar a requisição com um valor id}
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
	User obj = service.findById(id);
	return ResponseEntity.ok().body(obj);
	}
	//ReponseEntity vai retornar o valor inserido
	
	@PostMapping//para inserir dados, Transformar de json para o objto user.
	public ResponseEntity<User> insert(@RequestBody User obj){
		 obj = service.insert(obj);//no Path vai conter o barra users + o caminho id que for inserir. BuilAndExpand esperar o id que formos inserir
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				 .path("/{id}").buildAndExpand(obj.getId()).toUri();
		 return ResponseEntity.created(uri).body(obj);
		 //caminho.body. valor inserido
	}
}
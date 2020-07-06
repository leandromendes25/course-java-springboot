package com.leandroprojeto.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandroprojeto.entites.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(10L, "Jose luis", "luidrocha@gmail.com", "21-99254-2563", "Brasil2020");
		return ResponseEntity.ok().body(u);
	}
}
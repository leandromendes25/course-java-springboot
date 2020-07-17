package com.leandroprojeto.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	//Passa o id que tentou passar e não encontrou
	public  ResourceNotFoundException(Object Id) {
		super("Resource not found. ID " + Id);
	}
	
}

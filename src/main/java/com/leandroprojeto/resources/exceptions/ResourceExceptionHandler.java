package com.leandroprojeto.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.leandroprojeto.services.exceptions.DataBaseException;
import com.leandroprojeto.services.exceptions.ResourceNotFoundException;

@ControllerAdvice //intercepta exceções acontecerem, executa possivel tratamento
public class ResourceExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class) //interceptar a excessão e fazer com que caia aqui
	//o metodo resourceNotFound qualquer excessão do ResourceNotFoundException e vai fazer o tratamento abaixo
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";//mensagem padrão
		//erro 404
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error,e.getMessage() ,request.getRequestURI());
	return ResponseEntity.status(status).body(err); //retorna resposa cod personalizado
	}
	@ExceptionHandler(DataBaseException.class) //interceptar a excessão e fazer com que caia aqui
		public ResponseEntity<StandardError> DataBase(DataBaseException e, HttpServletRequest request){
		String error = "Database not found";//mensagem padrão
		//erro 404
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error,e.getMessage() ,request.getRequestURI());
	return ResponseEntity.status(status).body(err); //retorna resposa cod personalizado
	}
}



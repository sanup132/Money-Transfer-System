package com.AdvancedMapping.Mapping.Exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	
	@SuppressWarnings("unchecked")
	@ExceptionHandler(NoUserFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundEception(
			NoUserFoundException exception
			){
		NoUserErrorDetails error= new NoUserErrorDetails(
			LocalDate.now(), exception.getMessage(), "Value Thinking in Progress"
				);
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
		
	}
	
	@SuppressWarnings("unchecked")
	@ExceptionHandler(InsufficientBalance.class)
	public ResponseEntity<?> handleInsufficientBalance(
			InsufficientBalance exception
			){
		NoUserErrorDetails error= new NoUserErrorDetails(
			LocalDate.now(), exception.getMessage(), "Value Thinking in Progress"
				);
		return new ResponseEntity(error, HttpStatus.FAILED_DEPENDENCY);
		
	}

	
	
}

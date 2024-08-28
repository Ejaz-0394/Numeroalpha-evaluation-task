package com.numeroalpha.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class PersonRestExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonRestExceptionHandler.class);

	@ExceptionHandler
	public ResponseEntity<String> handlerException(PersonNotFoundException exc){
		
		logger.error("PersonNotFoundException occurred: {}", exc.getMessage());
		
		return new ResponseEntity<>(exc.getMessage(), HttpStatus.NOT_FOUND);
	}
}

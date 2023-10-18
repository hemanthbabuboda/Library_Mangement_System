package com.project.issuebook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Component
public class GlobalException {
	
	@ExceptionHandler(value=BookissueLimitExceed.class)
	public ResponseEntity<String> bookExistExc(){
		return new ResponseEntity<String>("Limit exceed, Three Books already Issued",HttpStatus.NOT_ACCEPTABLE) ;
	}

	@ExceptionHandler(value=BookAlreadyIssued.class)
	public ResponseEntity<String> bookExistsExc(){
		return new ResponseEntity<String>("Book with given id already Issued to user",HttpStatus.NOT_ACCEPTABLE) ;
	}
}

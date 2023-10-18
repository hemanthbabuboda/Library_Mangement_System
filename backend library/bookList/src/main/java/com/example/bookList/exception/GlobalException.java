package com.example.bookList.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Component
public class GlobalException {
	
	@ExceptionHandler(value=BookAlreadyExistException.class)
	public ResponseEntity<String> bookExistExc(){
		return new ResponseEntity<String>("Book with given id already exists",HttpStatus.NOT_ACCEPTABLE) ;
	}

}

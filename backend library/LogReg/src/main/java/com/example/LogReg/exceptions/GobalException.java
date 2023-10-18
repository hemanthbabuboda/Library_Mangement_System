package com.example.LogReg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
public class GobalException {

	@ExceptionHandler(value=EmailIdAlreadyExistException.class)
	public ResponseEntity<String> logRegExc(){
		return new ResponseEntity<String>("EmailId is already exists",HttpStatus.NOT_ACCEPTABLE) ;
	}
	
	@ExceptionHandler(value=UserIdAlreadyExistException.class)
	public ResponseEntity<String> userIdExc(){
		return new ResponseEntity<String>("UserId is already exists",HttpStatus.NOT_ACCEPTABLE) ;
	}
	
	
	@ExceptionHandler(value=PasswordMissmatchException.class)
	public ResponseEntity<String> usernullExc(){
		return new ResponseEntity<String>("Password Mismatch",HttpStatus.NOT_FOUND) ;
	}
	
	
	
}

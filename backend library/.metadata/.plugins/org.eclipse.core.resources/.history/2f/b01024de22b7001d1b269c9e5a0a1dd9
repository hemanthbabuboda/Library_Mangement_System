package com.project.wishlist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
@Component
public class GlobalException {
	
	@ExceptionHandler(value=BookAlreadyExistsInFavException.class)
	public ResponseEntity<String> bookExistInFavExc(){
		return new ResponseEntity<String>("Book with given id already exists in Fav",HttpStatus.NOT_ACCEPTABLE) ;
	}

}

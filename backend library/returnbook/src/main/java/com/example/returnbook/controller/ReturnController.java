package com.example.returnbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.returnbook.model.IssueBook;
import com.example.returnbook.service.ReturnService;


@RestController
@RequestMapping("/returnbook")
@CrossOrigin("http://localhost:4200/")
public class ReturnController {

	@Autowired
	ReturnService returnService;
	
	@DeleteMapping("/return/{email}/{bookId}")
	public ResponseEntity<Boolean> delete(@PathVariable String email,@PathVariable int bookId){
		boolean isValid = returnService.deleteBook(email,bookId);
		return new ResponseEntity<Boolean>(isValid,HttpStatus.OK);

	}
	

	
}

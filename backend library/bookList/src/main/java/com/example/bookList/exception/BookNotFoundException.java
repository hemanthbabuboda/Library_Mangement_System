package com.example.bookList.exception;

public class BookNotFoundException extends RuntimeException{
	
	public BookNotFoundException(String s) {
		super(s);
	}

}

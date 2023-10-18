package com.example.returnbook.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.returnbook.model.Book;


@FeignClient(value = "BookList/books")
public interface BookServiceproxy {

	@GetMapping("{bookId}")
	public Book getBookById(@PathVariable int bookId);
	
	@PutMapping("/return")
	public ResponseEntity<Book> returnBook(@RequestBody Book book);
}

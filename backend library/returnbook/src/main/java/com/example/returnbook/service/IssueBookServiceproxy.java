package com.example.returnbook.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.example.returnbook.model.IssueBook;


@FeignClient(value = "http://localhost:9093/issuebook")
public interface IssueBookServiceproxy {

	@GetMapping("/{email}/{bookId}")
	public ResponseEntity<IssueBook> getEmailBookId(@PathVariable String email,@PathVariable int bookId);
	
	@DeleteMapping("/deleteBook/{email}/{bookId}")
	public ResponseEntity<String> delete(@PathVariable("email") String email,@PathVariable("bookId") int bookId);
}

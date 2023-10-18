package com.example.returnbook.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.returnbook.model.Book;
import com.example.returnbook.model.IssueBook;



@Service
public class ReturnService {

	@Autowired
	RestTemplate rest;
//	@Autowired
//	IssueBookServiceproxy issueProxy;
//	@Autowired
//	BookServiceproxy bookProxy;
//	
//	public String deleteBook(IssueBook issue) {
//		ResponseEntity<IssueBook> obj=issueProxy.getEmailBookId(issue.getEmail(), issue.getBookId());
//		System.out.println(obj);
//		Book getbook=bookProxy.getBookById(issue.getBookId());
//		System.out.println(getbook);
//		if(obj !=null) {
//			issueProxy.delete(issue.getEmail(), issue.getBookId());
//			bookProxy.returnBook(getbook);
//			return "delete successfully";
//		}
//		return "Not deleted";
//	}
	
	
	
	public boolean deleteBook(String email,int bookId) {
		ResponseEntity<IssueBook> obj=rest.getForEntity("http://localhost:9093/issuebook/"+email+"/"+bookId,IssueBook.class);
		System.out.println(obj);
		Book getbook=rest.getForObject("http://localhost:8083/books/"+bookId,Book.class);
		if(obj != null) {
			rest.delete("http://localhost:9093/issuebook/deleteBook/"+email+"/"+bookId);
			rest.put("http://localhost:8083/books/return",getbook);
			return true;
		}
		return false;
	}
}

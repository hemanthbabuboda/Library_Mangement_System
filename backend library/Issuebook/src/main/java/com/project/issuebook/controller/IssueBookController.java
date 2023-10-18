package com.project.issuebook.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.issuebook.exceptions.BookissueLimitExceed;
import com.project.issuebook.model.IssueBook;
import com.project.issuebook.model.Users;
import com.project.issuebook.service.IssueBookService;

@RestController
@RequestMapping("/issuebook")
@CrossOrigin("http://localhost:4200/")
public class IssueBookController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private IssueBookService service;
	
	
	@PostMapping("/issue")
	public ResponseEntity<?> issued(@RequestBody IssueBook issue) throws BookissueLimitExceed{
		IssueBook obj=service.issueBook(issue);
		return new ResponseEntity<IssueBook>(obj,HttpStatus.CREATED);
	}
	
	@GetMapping("/getList/{email}")
	public ResponseEntity<?> getList(@PathVariable String email){
		List<IssueBook> list=service.getIssuedList(email);
		return new ResponseEntity<List<IssueBook>>(list,HttpStatus.OK);
	}
	
	
	@GetMapping("/{email}/{bookId}")
	public ResponseEntity<IssueBook> getEmailByBookId(@PathVariable String email,@PathVariable int bookId){
		System.out.println(email);
		System.out.println(bookId);
		IssueBook getbook= service.getByEmailandBookId(email,bookId);
		return new ResponseEntity<IssueBook>(getbook,HttpStatus.OK);
	}
	

	@GetMapping("/issuedate/{issueDate}")
	public ResponseEntity<?> getUsersByIssueDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate issueDate){
		Set<Users> userlist=service.getUsersByIssueDate(issueDate);
		return new ResponseEntity<Set<Users>>(userlist,HttpStatus.OK);
	}

	
	@DeleteMapping("/deleteBook/{email}/{bookId}")
	public ResponseEntity<String> delete(@PathVariable("email") String email,@PathVariable("bookId") int bookId){
		String mssg=service.returnbook(email, bookId);
		return new ResponseEntity<String>(mssg,HttpStatus.OK);
	}
		
	
}

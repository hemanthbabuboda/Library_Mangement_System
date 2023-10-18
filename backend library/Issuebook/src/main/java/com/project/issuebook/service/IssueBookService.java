package com.project.issuebook.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.issuebook.exceptions.BookAlreadyIssued;
import com.project.issuebook.exceptions.BookissueLimitExceed;
import com.project.issuebook.model.Book;
import com.project.issuebook.model.IssueBook;
import com.project.issuebook.model.Users;
import com.project.issuebook.repository.IssueBookRepository;

@Service
public class IssueBookService {
	
	@Autowired 
	private IssueBookRepository issueRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	public IssueBook issueBook(IssueBook issue) throws BookissueLimitExceed,BookAlreadyIssued {
		Optional<IssueBook> issueObj=issueRepo.findUserByEmailAndBookId(issue.getEmail(),issue.getBookId());
		if(issueObj.isPresent()) {
			 throw new BookAlreadyIssued();
		}
			Book getbook=restTemplate.getForObject("http://localhost:8083/books/"+issue.getBookId(),Book.class);
//			Book upadtebook=restTemplate.getForObject("http://localhost:8083/books/updateQuantity",Book.class);
		
			//System.out.println(issue.getBookId());
		
			Users getuser=restTemplate.getForObject("http://localhost:8081/users/"+issue.getEmail(), Users.class);
			
			if(getbook.getQuantity()>0) {
				if(getIssuedList(issue.getEmail()).size()<3) {
			//	System.out.println(getbook.getQuantity());
					issue.setBookId(getbook.getBookId());
					issue.setBookName(getbook.getBookName());
					issue.setBookPic(getbook.getBookPic());
					issue.setEmail(getuser.getEmail());
					LocalDate currentDate = LocalDate.now();
					issue.setIssueDate(currentDate);
					issue.setDueDate(issue.getIssueDate().plusDays(7));
						issue=issueRepo.save(issue);
					restTemplate.put("http://localhost:8083/books/borrow",getbook);
						
						
//							return issue;
						}
						else {
							throw new BookissueLimitExceed();
						}
			}
			return issue;
	}

	
	public List<IssueBook> getIssuedList(String email){
		//System.out.println("true");
		List<IssueBook> issuedList=issueRepo.findByEmail(email);
	//	System.out.println(issuedList);
		if(issuedList.isEmpty()) {
			return issuedList ;
		}
		return issuedList;
	}

public IssueBook getByEmailandBookId(String email,int bookId) {
	Optional<IssueBook> issueObj=issueRepo.findUserByEmailAndBookId(email,bookId);
	System.out.println(issueObj);
	if(issueObj.isPresent()) {
		return issueObj.get();
	}
	return null;
}
public String returnbook(String email,int bookId) {
	issueRepo.deleteByEmailAndBookId(email,bookId);
	return "delete";
}
//	
//	public String deleteBook(IssueBook issue) {
//		Optional<IssueBook> obj=issueRepo.findUserByEmailAndBookId(issue.getEmail(),issue.getBookId());
//		Book getbook=restTemplate.getForObject("http://localhost:8083/books/"+issue.getBookId(),Book.class);
//		if(obj.isPresent()) {
//		issueRepo.deleteByEmailAndBookId(issue.getEmail(),issue.getBookId());
//		restTemplate.put("http://localhost:8083/books/return",getbook);
//		return "delete successfully";
//		}
//		return "Not deleted";
//	}

public Set<Users> getUsersByIssueDate(LocalDate issueDate){
	List<IssueBook> list=issueRepo.findUserByIssueDate(issueDate);
	if(list.isEmpty()) {
		return null;
	}
	List<Users> userList=new ArrayList<>();
	
	for(IssueBook l:list) {
		Users getuser=restTemplate.getForObject("http://localhost:8081/users/"+l.getEmail(), Users.class);
		userList.add(getuser);
	}
    Set<Users> hset=new HashSet<>();
    
    for (Users x : userList) {
    	hset.add(x);
    }
	return hset;
}


}

package com.project.issuebook.model;

import java.time.LocalDate;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity

public class IssueBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private int bookId;
	private String bookName;
	
	@Lob
	private String bookPic;
	private LocalDate issueDate;
	private LocalDate dueDate;
	public IssueBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IssueBook(int id, String email, int bookId, String bookName, String bookPic, LocalDate issueDate,
			LocalDate dueDate) {
		super();
		this.id = id;
		this.email = email;
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPic = bookPic;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookPic() {
		return bookPic;
	}
	public void setBookPic(String bookPic) {
		this.bookPic = bookPic;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
}
	
	
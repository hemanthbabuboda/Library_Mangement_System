package com.project.issuebook.model;

import java.awt.print.Book;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Transient;

//@Entity
public class Users {
	
	//@Id
	private String email;
	private String name;
	private int userId;
	private String password;
	
	@Transient
	private String cpassword;
//	@Transient
//	private Book bookId;
//	
//	public Book getBookId() {
//		return bookId;
//	}
//
//
//
//
//	public void setBookId(Book bookId) {
//		this.bookId = bookId;
//	}
//
//


	private long contact;
	
	
	
	
	public Users( int userId,String email, String name, String password, long contact) {
		super();
		this.email = email;
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.contact = contact;
	}




	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Users(int userId, String name, String email, String password, String cpassword, long contact) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.cpassword = cpassword;
		this.contact = contact;
	}




	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", cpassword=" + cpassword + ", contact=" + contact + "]";
	}




	public int getUserId() {
		return userId;
	}




	public void setUserId(int userId) {
		this.userId = userId;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getCpassword() {
		return cpassword;
	}




	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}




	public long getContact() {
		return contact;
	}




	public void setContact(long contact) {
		this.contact = contact;
	}


	
	

}

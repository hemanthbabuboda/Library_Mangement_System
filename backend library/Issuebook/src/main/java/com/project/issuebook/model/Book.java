package com.project.issuebook.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;



//@Entity
public class Book {

	//@Id
	private int bookId;
	private String  bookName;
	private String  author;
	private String  category;
	private int quantity;
	
	//@Lob
	private String  bookPic;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBookPic() {
		return bookPic;
	}

	public void setBookPic(String bookPic) {
		this.bookPic = bookPic;
	}

	public Book(int bookId, String bookName, String author, String category, int quantity, String bookPic) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.category = category;
		this.quantity = quantity;
		this.bookPic = bookPic;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
}

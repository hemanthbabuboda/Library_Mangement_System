package com.project.wishlist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class Favourites {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int favId;
	private String email;
	private int bookId;
	private String bookName;
	private String author;
	private String category;
	
	
	@Lob
	private String bookPic;
	
	public Favourites() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Favourites(int favId, String email, int bookId, String bookName, String author, String category,
			String bookPic) {
		super();
		this.favId = favId;
		this.email = email;
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.category = category;
		this.bookPic = bookPic;
	}
	@Override
	public String toString() {
		return "Favourites [favId=" + favId + ", email=" + email + ", bookId=" + bookId + ", bookName=" + bookName
				+ ", author=" + author + ", category=" + category + ", bookpic=" + bookPic + "]";
	}
	public int getFavId() {
		return favId;
	}
	public void setFavId(int favId) {
		this.favId = favId;
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
	public String getBookPic() {
		return bookPic;
	}
	public void setBookPic(String bookPic) {
		this.bookPic = bookPic;
	}
	
	
}

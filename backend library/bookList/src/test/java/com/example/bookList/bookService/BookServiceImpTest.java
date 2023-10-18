package com.example.bookList.bookService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.bookList.bookDao.BookDao;
import com.example.bookList.exception.BookAlreadyExistException;
import com.example.bookList.model.Book;

@ExtendWith(MockitoExtension.class)
class BookServiceImpTest {
	@Mock
	BookDao repo;
	@InjectMocks
    BookServiceImp service;
	List<Book> BookList=new ArrayList<>();
	@BeforeEach
	void setUp() throws Exception {
		List<Book> BookList=new ArrayList<>();
		
	        BookList.add(new Book(101,"THE WAR","NAINA","ACTION",20, "bookPic"));
			BookList.add(new Book(102,"JAVA ","HEMANTH","TECHNICAL",10,"bookPic1"));
			BookList.add(new Book(103,"GREEN REVOLUTION","VENKY","SCIENCE",30,"bookPic2"));
		}
//	private int bookId;
//	private String  bookName;
//	private String  author;
//	private String  category;
//	private int quantity;

	@Test
	void testAddBook() throws BookAlreadyExistException {
		 
		Book book=new Book(104,"THE LAUGH","SUDHAMURTHY","COMEDY",15,"bookPic3");
		when(repo.save(book)).thenReturn(book); 
		assertEquals(book, service.addBook(book));
		
		
	}

	@Test
	void testGetBooks() {
		when(repo.findAll()).thenReturn(BookList);
		assertEquals(BookList, service.getBooks());
		
	}

	@Test
	void testGetBookById() {
		Book book=new Book(101,"THE WAR","NAINA","ACTION",20,"bookPic");
		when(repo.findById(book.getBookId())).thenReturn(Optional.of(book));
		assertEquals(book, service.getBookById(101));
		
		
	}

	@Test
	void testUpdateBook() {
		Book newbook=new Book(101,"THE WAR","NAINA","ACTION",35,"bookPic");
		repo.findById(newbook.getBookId());
		when(repo.save(newbook)).thenReturn(newbook);
		assertEquals(newbook, service.updateBook(newbook));
		
		
	}

	@Test
	void testDeleteBook() {
		Book book=new Book(101,"THE WAR","NAINA","ACTION",20,"bookPic");
		repo.deleteById(book.getBookId());
		assertEquals(false, service.deleteBook(101));
		
	}

}

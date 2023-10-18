package com.example.bookList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookList.bookService.BookServiceImp;
import com.example.bookList.exception.BookAlreadyExistException;
import com.example.bookList.model.Book;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("books")
public class BookController {

	@Autowired
	BookServiceImp bookService;
	
	@PostMapping
	public ResponseEntity<Book> saveBook(@RequestBody Book book) throws BookAlreadyExistException
	{
	    Book savedBook=bookService.addBook(book);
		return new ResponseEntity<Book>(savedBook, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getBooks()
	{
	    List<Book> getBooks=bookService.getBooks();
		return new ResponseEntity<List<Book>>(getBooks, HttpStatus.OK);
	}
	
	@GetMapping("{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable int bookId)
	{
	    Book foundBook=bookService.getBookById(bookId);
		return new ResponseEntity<Book>(foundBook, HttpStatus.OK);
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<?> getByCategory(@PathVariable String category){
		List<Book> booklist=bookService.getBookByCategory(category);
		return new ResponseEntity<List<Book>>(booklist,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Book> updateBook(@RequestBody Book book)
	{
	    Book update=bookService.updateBook(book);
	    return new ResponseEntity<Book>(update, HttpStatus.OK);
	}
	
	@PutMapping("/borrow")
	public ResponseEntity<Book> borrow(@RequestBody Book book){
		return new ResponseEntity<Book>(bookService.borrowBook(book), HttpStatus.OK);
	}
	
	@PutMapping("/return")
	public ResponseEntity<Book> returnBook(@RequestBody Book book){
		return new ResponseEntity<Book>(bookService.returnBook(book), HttpStatus.OK);
	}
	
	@DeleteMapping("{bookId}")
	public ResponseEntity<Boolean> deleteBookById(@PathVariable int bookId)
	{
	    boolean isValid=bookService.deleteBook(bookId);;
	    return new ResponseEntity<Boolean>(isValid, HttpStatus.OK);
	}
		
}


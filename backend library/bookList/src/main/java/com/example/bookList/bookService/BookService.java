package com.example.bookList.bookService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bookList.exception.BookAlreadyExistException;
import com.example.bookList.model.Book;

@Service
public interface BookService {
	
	public Book addBook(Book book) throws BookAlreadyExistException;
	public List<Book> getBooks();
	public Book getBookById(int bookId);
	public Book updateBook(Book book);
	public boolean deleteBook(int bookId);

	public List<Book> getBookByCategory(String category);
	
}

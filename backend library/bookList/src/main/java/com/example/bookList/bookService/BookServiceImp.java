package com.example.bookList.bookService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bookList.bookDao.BookDao;
import com.example.bookList.exception.BookAlreadyExistException;
import com.example.bookList.exception.BookNotFoundException;
import com.example.bookList.model.Book;

@Service
public class BookServiceImp implements BookService{

	@Autowired
	BookDao bookDao;
	
	@Override
	public Book addBook(Book book) throws BookAlreadyExistException {
	
		if(getBookById(book.getBookId()) != null)
			throw new BookAlreadyExistException();
		
		return bookDao.save(book);
	}

	@Override
	public List<Book> getBooks() {
		
		return bookDao.findAll();
	}

	@Override
	public Book getBookById(int bookId) {
		Optional<Book> optBook=bookDao.findById(bookId);
		if(optBook.isPresent()) {
			return optBook.get();
		}
		
		return null;
	}

	@Override
	public Book updateBook(Book book) {
	
			return bookDao.save(book);
	}
	
	public Book borrowBook(Book book) {
		Book in=getBookById(book.getBookId());
		in.setBookId(book.getBookId());
		in.setBookName(book.getBookName());
		in.setAuthor(book.getAuthor());
		in.setCategory(book.getCategory());
		in.setQuantity(book.getQuantity()-1);
		in.setBookPic(book.getBookPic());
		return bookDao.save(in);
	}
	
	public Book returnBook(Book book) {
		Book in=getBookById(book.getBookId());
		in.setBookId(book.getBookId());
		in.setBookName(book.getBookName());
		in.setAuthor(book.getAuthor());
		in.setCategory(book.getCategory());
		in.setQuantity(book.getQuantity()+1);
		in.setBookPic(book.getBookPic());
		return bookDao.save(in);
	}

	@Override
	public boolean deleteBook(int bookId) {
		Book book=getBookById(bookId);
		boolean  isValid=(getBookById(bookId) != null)?true:false; 
		if(isValid) {
			bookDao.delete(book);
		
		}
	
		return isValid;
	}
	
	@Override
	public List<Book> getBookByCategory(String category) {
		List<Book> list=bookDao.findBookByCategory(category);
		if(list.isEmpty())
			return null;
		return list;
	}

		
}

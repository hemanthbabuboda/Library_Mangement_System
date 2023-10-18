package com.example.bookList.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.bookList.bookService.BookServiceImp;
import com.example.bookList.model.Book;




@ExtendWith(SpringExtension.class)
@WebMvcTest(value=BookController.class)
class BookControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	BookServiceImp service;
	@Test
	void testSaveBook() throws Exception {
		Book book=new Book(1001,"THE WAR","NAINA","ACTION",20,"bookPic");
		when(service.addBook(book)).thenReturn(book);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.post("/books/addBook")
		               .contentType("application/json")
		               .content("{\"bookId\":\"1001\",\"bookName\":\"THE WAR\",\"author\":\"NAINA\",\"category\":\"ACTION\",\"quantity\":\"25\",\"bookPic\":\"bookPic1\"}");
	    mockMvc.perform(requestBuilder)
		         .andExpect(status().isOk())
		         .andReturn();
		
	}

	@Test
	void testGetBooks() throws Exception {
		Book book=new Book(1001,"THE WAR","NAINA","ACTION",20,"bookPic");
		Book book1=new Book(1002,"JAVA ","HEMANTH","TECHNICAL",10,"bookPic1");
		List<Book> BookList=new ArrayList<>();
        BookList.add(book);
		BookList.add(book1);
		when(service.getBooks()).thenReturn(BookList);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/books/getAll");
		mockMvc.perform(requestBuilder)
		       .andExpect(status().isOk())
		       .andReturn();
		
	}

	@Test
	void testGetBookById() throws Exception {
		Book book=new Book(1001,"THE WAR","NAINA","ACTION",20,"bookPic");
		when(service.getBookById(book.getBookId())).thenReturn(book);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/books/{bookId}",1001)
		.contentType("application/json")
		.content("{\"bookId\":\"1001\",\"bookName\":\"THE WAR\",\"author\":\"NAINA\",\"category\":\"ACTION\",\"quantity\":\"25\"}");
		mockMvc.perform(requestBuilder)
		.andExpect(status().isOk())
		.andReturn();
		
		
	}

	@Test
	void testUpdateBook() throws Exception {

		 Book book=new Book(1001,"THE WAR","NAINA","ACTION",20,"bookPic");
		when(service.getBookById(book.getBookId())).thenReturn(book);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.put("/books/update")
				.contentType("application/json")
				.content("{\"bookId\":\"1001\",\"bookName\":\"THE RAR\",\"author\":\"NAINA\",\"category\":\"ACTION\",\"quantity\":\"25\"}");
		mockMvc.perform(requestBuilder)
		       .andExpect(status().isOk())
		       .andReturn();
			}

	@Test
	void testDeleteBookById() throws Exception {
		 Book book=new Book(1001,"THE WAR","NAINA","ACTION",20,"bookPic");
			
			when(service.deleteBook(1001)).thenReturn(true);
				
			RequestBuilder requestBuilder=MockMvcRequestBuilders.delete("/books/{bookId}",1001);
	     
		     mockMvc.perform(requestBuilder)
				.andExpect(status().isOk());
				
		
	}

}

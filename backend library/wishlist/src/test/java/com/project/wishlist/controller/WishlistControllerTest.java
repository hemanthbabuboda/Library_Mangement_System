package com.project.wishlist.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.project.wishlist.model.Favourites;
import com.project.wishlist.service.WishlistServiceImp;


@ExtendWith(SpringExtension.class)
@WebMvcTest(value= WishlistController.class)
class WishlistControllerTest {
	@MockBean
	WishlistServiceImp service;
	@Autowired
	private MockMvc mockMvc;

	@Test
	void testAddToFav() throws Exception {
		Favourites fav=new Favourites(1,"ravi@gmail.com",101,"Java","Joseph","Technical","bookPic");
		when(service.addToFavourites(fav)).thenReturn(fav);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.post("/wishlist/add")
		               .contentType("application/json")
		               .content("{\"favId\":\"1\",\"email\":\"ravi@gmail.com\",\"bookId\":\"101\",\"bookName\":\"Java\",\"category\":\"Technical\",\"bookpic\":\"bookPic\"}");
	    mockMvc.perform(requestBuilder)
		         .andExpect(status().isOk())
		         .andReturn();
		
		
		
			}
//	private int favId;
//	private String email;
//	private int bookId;
//	private String bookName;
//	private String author;
//	private String category;
//	private String bookpic;

	@Test
	void testGetList() throws Exception {
		Favourites fav=new Favourites(1,"ravi@gmail.com",101,"Java","Joseph","Technical","bookPic");
		
		when(service.getFavourites("ravi@gmail.com")).thenReturn((List<Favourites>) fav);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/wishlist/getList/{emailId}","ravi@gmail.com");
		mockMvc.perform(requestBuilder)
        .andExpect(status().isOk())
        .andReturn();
		
		
		
	}

	@Test
	void testDeleteList() throws Exception {
		Favourites fav=new Favourites(1,"ravi@gmail.com",101,"Java","Joseph","Technical","bookPic");
			
			when(service.deleteFavouriteBook(fav.getEmail(),fav.getBookId())).thenReturn(null);
				
			RequestBuilder requestBuilder=MockMvcRequestBuilders.delete("/wishlist/delete/{emailId}/{bookId}","ravi@gmail.com",1001);
	     
		     mockMvc.perform(requestBuilder)
				.andExpect(status().isOk());
	}

}


package com.project.wishlist.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.wishlist.exception.BookAlreadyExistsInFavException;
import com.project.wishlist.model.Favourites;
import com.project.wishlist.repository.WishListRepository;
@ExtendWith(MockitoExtension.class)
class WishlistServiceImpTest2 {
	@Mock
	WishListRepository repo;
	
	@InjectMocks
	WishlistServiceImp service;
	
	Favourites fav=new Favourites(1,"ravi@gmail.com",101,"THE WAR","NAINA","ACTION","bookPic");
	
	

	@Test
	void testAddToFavourites() {
		when(repo.save(fav)).thenReturn(fav);
		assertEquals(fav, service.addToFavourites(fav));
		
		
	}

	@Test
	void testGetFavourites() {
		
		when(repo.findFavouritesByEmail(fav.getEmail())).thenReturn((List<Favourites>) fav);
		assertEquals(fav,service.getFavourites("ravi@gmail.com"));
		
		
	}

	@Test
	void testDeleteFavouriteBook() {
		Favourites fav=new Favourites(1,"ravi@gmail.com",101,"THE WAR","NAINA","ACTION","bookPic");
		when(repo.deleteByEmailAndBookId(fav.getEmail(),fav.getBookId()));
		assertEquals(true,service.deleteFavouriteBook("ravi@gmail.com",101));
	}
	
	
		
	}



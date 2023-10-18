package com.project.wishlist.service;

import java.util.List;



import com.project.wishlist.exception.BookAlreadyExistsInFavException;
import com.project.wishlist.model.Favourites;


//@Service
public interface WishlistService {
	
	public Favourites addToFavourites(Favourites fav) throws BookAlreadyExistsInFavException;
	
	public List<Favourites> getFavourites(String emailId);
	
	public boolean deleteFavouriteBook(String emailId,int bookId);
	

}

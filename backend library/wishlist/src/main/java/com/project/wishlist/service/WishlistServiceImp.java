package com.project.wishlist.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.wishlist.exception.BookAlreadyExistsInFavException;
import com.project.wishlist.model.Favourites;
import com.project.wishlist.repository.WishListRepository;

@Service
public class WishlistServiceImp implements WishlistService{

	//private static Logger logger=LoggerFactory.getLogger(WishlistService.class);
	@Autowired 
	WishListRepository wishlistRepo;
	
	public Favourites addToFavourites(Favourites fav) throws BookAlreadyExistsInFavException {
		Optional<Favourites> opt=wishlistRepo.findUserByEmailAndBookId(fav.getEmail(),fav.getBookId());
		System.out.println(fav.getBookPic());
		if(opt.isPresent()) {
			throw new BookAlreadyExistsInFavException();
		}
		return wishlistRepo.save(fav);
		
	}
	
	public List<Favourites> getFavourites(String email){
		List<Favourites> fav=wishlistRepo.findFavouritesByEmail(email);
		return fav;
	}
	
//	public Favourites deleteFavouriteBook(String email,int bookId) {
//		
//		Favourites isDeleted=null;
//		try {
//			isDeleted=wishlistRepo.deleteByEmailAndBookId(email,bookId);
//		}
//		catch(Exception e) {
//			logger.error("Error while deleting from favourites");
//		}
//		return isDeleted;
//	}
	
public boolean deleteFavouriteBook(String email,int bookId) {
	Optional<Favourites> opt=wishlistRepo.findUserByEmailAndBookId(email,bookId);

	if(opt.isPresent()) {
	
		wishlistRepo.deleteByEmailAndBookId(email,bookId);
		return true;
		}
	return false;
	}
}
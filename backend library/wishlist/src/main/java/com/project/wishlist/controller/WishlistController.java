package com.project.wishlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.wishlist.exception.BookAlreadyExistsInFavException;
import com.project.wishlist.model.Favourites;
import com.project.wishlist.service.WishlistServiceImp;


@RestController
@RequestMapping("wishlist")
@CrossOrigin("http://localhost:4200/")
public class WishlistController {

	@Autowired
	WishlistServiceImp service;
	
	@PostMapping("/add")
	public ResponseEntity<Favourites> addToFav(@RequestBody Favourites fav) throws BookAlreadyExistsInFavException{
		Favourites favObj=service.addToFavourites(fav);
		return new ResponseEntity<Favourites>(favObj,HttpStatus.OK);
		
	}
	
	@GetMapping("/getList/{emailId}")
	public ResponseEntity<?> getList(@PathVariable String emailId){
		List<Favourites> favList=service.getFavourites(emailId);
		return new ResponseEntity<List<Favourites>>(favList,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{email}/{bookId}")
	public ResponseEntity<Boolean> deleteList(@PathVariable("email") String email, @PathVariable("bookId") int bookId){
		boolean isValid=service.deleteFavouriteBook(email,bookId);
		System.out.println(isValid);
		return new ResponseEntity<Boolean>(isValid,HttpStatus.OK);
	}
}

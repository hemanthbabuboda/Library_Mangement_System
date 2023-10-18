package com.project.wishlist.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.wishlist.model.Favourites;

@Repository
@Transactional
public interface WishListRepository extends JpaRepository<Favourites, Integer> {

	public Optional<Favourites> findUserByEmailAndBookId(String emailId, int bookId);
	public List<Favourites> findFavouritesByEmail(String emailId);
	public void deleteByEmailAndBookId(String email, int bookId);
}

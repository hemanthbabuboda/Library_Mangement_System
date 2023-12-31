package com.example.bookList.bookDao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookList.model.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Integer>{

	public List<Book> findBookByCategory(String  category);

}

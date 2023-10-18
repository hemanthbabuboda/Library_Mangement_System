package com.project.issuebook.repository;

import java.time.LocalDate;
import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.issuebook.model.IssueBook;


import javax.transaction.Transactional;

@Repository
@Transactional
public interface IssueBookRepository extends JpaRepository<IssueBook, Integer> {

	public Optional<IssueBook> findUserByEmailAndBookId(String email, int bookId);
	public List<IssueBook> findByEmail(String email);
	public String deleteByEmailAndBookId(String email, int bookId);
	
	public List<IssueBook> findUserByIssueDate(LocalDate issueDate);

}

package com.example.LogReg.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.LogReg.model.Users;

@Repository
public interface UsersDao extends JpaRepository<Users, String>{

	public Users findByEmailAndPassword(String email,String password);

	public Optional<Users> findByUserId(int userId);
	
	public List<Users> findByRole(String role);
}

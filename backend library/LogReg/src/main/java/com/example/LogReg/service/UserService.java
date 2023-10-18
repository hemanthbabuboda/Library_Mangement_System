package com.example.LogReg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.LogReg.exceptions.EmailIdAlreadyExistException;
import com.example.LogReg.exceptions.UserIdAlreadyExistException;
import com.example.LogReg.exceptions.PasswordMissmatchException;
import com.example.LogReg.model.ChangePassword;
import com.example.LogReg.model.Users;


@Service
public interface UserService  {

	public Users  add(Users user) throws EmailIdAlreadyExistException,UserIdAlreadyExistException;
	
	public Users login(String email,String password) ;
	
	public Users updatePassword(ChangePassword changePassword,int userId) throws PasswordMissmatchException;
	
	public List<Users> getByRole(String role);
	
	public boolean deleteUser(int userId);
}

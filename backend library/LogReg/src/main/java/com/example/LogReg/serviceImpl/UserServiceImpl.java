package com.example.LogReg.serviceImpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LogReg.dao.UsersDao;
import com.example.LogReg.exceptions.EmailIdAlreadyExistException;
import com.example.LogReg.exceptions.PasswordMissmatchException;
import com.example.LogReg.exceptions.UserIdAlreadyExistException;
import com.example.LogReg.model.ChangePassword;
import com.example.LogReg.model.Users;
import com.example.LogReg.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UsersDao usersDao;
	
	@Override
	public Users add(Users user) throws EmailIdAlreadyExistException,UserIdAlreadyExistException{
		
		if(getusersByEmail(user.getEmail()) != null) {
			throw new EmailIdAlreadyExistException();
		}
		else if(getByUserId(user.getUserId()) != null) {
			throw new UserIdAlreadyExistException();
		}
		return usersDao.save(user);
	}
	
	@Override
	public Users login(String email, String password) {
	
		Users user= usersDao.findByEmailAndPassword(email, password);
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				return user;
			}
		}
		
		return null; 
	}
	
	public Users getusersByEmail(String email) {
		Optional<Users> opt=usersDao.findById(email);
		//Optional<Users> id=usersDao.findByUserId(userId);
		if(opt.isPresent()) {
			return opt.get();
		}
//		else if(id.isPresent()) {
//			return id.get();
//		}
		return null;
	}
	
	public Users getByUserId(int userId) {
		Optional<Users> opt=usersDao.findByUserId(userId);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}
	

	@Override
	public Users updatePassword(ChangePassword changePassword, int userId) throws PasswordMissmatchException{
		Users user=getByUserId(userId);
		if(user.getPassword().equals(changePassword.getOldpassword())) {
			user.setPassword(changePassword.getNewpassword());
			
			return usersDao.save(user);
		}
		 throw new PasswordMissmatchException();
	}

	@Override 
	public List<Users> getByRole(String role) {
		
		List<Users> usr= usersDao.findByRole(role);
		if(usr.isEmpty()) {
			return   null; 
		}
		return usr;
	}

//	@Override
//	public void deleteUser(int userId) {
//		Users user=getByUserId(userId);
//		usersDao.delete(user);
//	}
	

	@Override
	public boolean deleteUser(int userId) {
		Users user=getByUserId(userId);
		boolean  isValid=(getByUserId(userId) != null)?true:false; 
		if(isValid) {
			usersDao.delete(user);
		
		}
	
		return isValid;
	}

	
}

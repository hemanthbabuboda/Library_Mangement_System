package com.example.LogReg.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LogReg.exceptions.EmailIdAlreadyExistException;
import com.example.LogReg.exceptions.UserIdAlreadyExistException;

import com.example.LogReg.exceptions.PasswordMissmatchException;
import com.example.LogReg.model.ChangePassword;
import com.example.LogReg.model.UserAuth;
import com.example.LogReg.model.Users;

import com.example.LogReg.serviceImpl.UserServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;

	@PostMapping
	public ResponseEntity<Users> saveuser(@RequestBody Users user) throws EmailIdAlreadyExistException,UserIdAlreadyExistException
	{
	    Users savedUser=userService.add(user);
		return new ResponseEntity<Users>(savedUser, HttpStatus.CREATED); 
	}
	
	@PostMapping("/login")
	public ResponseEntity<Users> saveuser(@RequestBody UserAuth userAuth)
	{
		  System.out.println(userAuth);
	    Users savedUser=userService.login(userAuth.getEmail(),userAuth.getPassword());
	    System.out.println(savedUser);
		return new ResponseEntity<Users>(savedUser, HttpStatus.OK);
	}
	
	@PutMapping("/changepassword/{userId}")
	public ResponseEntity<Users> changepassword(@RequestBody ChangePassword changePassword,  @PathVariable int userId) throws PasswordMissmatchException{
		
		System.out.println(changePassword);
		Users change=userService.updatePassword(changePassword,userId);
		 System.out.println(change);
		return new ResponseEntity<Users>(change, HttpStatus.OK);
	}
	
	@GetMapping("/role/{role}")
	public ResponseEntity<List<Users>> getUsersByRole(@PathVariable("role") String role)
	{
	    List<Users> allUsers=userService.getByRole(role);
	    System.out.println(allUsers);
		return new ResponseEntity<List<Users>>(allUsers, HttpStatus.OK); 
	}

	@GetMapping("{email}")
	public ResponseEntity<Users> getUsersByEmail(@PathVariable  String email)
	{
	    Users user=userService.getusersByEmail(email);
		return new ResponseEntity<Users>(user, HttpStatus.OK); 
	}
	@DeleteMapping("{userId}")
	public ResponseEntity<?> deleteBookById(@PathVariable int userId)
	{
	    boolean isValid=userService.deleteUser(userId);;
	    return new ResponseEntity<Boolean>(isValid, HttpStatus.OK);
	}
}
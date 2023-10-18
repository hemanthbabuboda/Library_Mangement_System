package com.example.LogReg.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.LogReg.dao.UsersDao;
import com.example.LogReg.exceptions.EmailIdAlreadyExistException;
import com.example.LogReg.exceptions.UserIdAlreadyExistException;
import com.example.LogReg.model.UserAuth;
import com.example.LogReg.model.Users;
import com.example.LogReg.service.UserService;
import com.example.LogReg.serviceImpl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;


@ExtendWith(SpringExtension.class)
@WebMvcTest(value=UserController.class)
class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	UserServiceImpl service;
	@MockBean
    UsersDao userRepo;
	@Autowired
	ObjectMapper mapper;
	private Users user;
	private Users login;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		 user = new Users();
		
		 login = new Users();
		user.setContact(6303439903L);
		user.setRole("User");
		user.setEmail("ravi2@gmail.com");
		user.setPassword("Ravi@123");
		user.setName("Ravi");
		login.setEmail("ravi2@gmail.com");
		login.setPassword("Ravi@123");
	}

	@Test
	void testSaveuserUsers() throws Exception
	 {
		Users user=new Users(54,"ravi2@gmail.com","ravi","Ravi@123","User",6789123456L);
		when(service.add(user)).thenReturn(user);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.post("/users")
               .contentType("application/json")
               .content("{\"userId\":54,\"name\":\"ravi\",\"email\":\"ravi2@gmail.com\",\"password\":\"Ravi@123\",\"role\":\"User\",\"contactNumber\":6789123456}");
				mockMvc.perform(requestBuilder)
				.andExpect(status().isCreated())
				.andReturn();
		
	}

	@Test
	void testSaveuserUserAuth() throws JsonProcessingException, Exception {
		Mockito.when(service.login(login.getEmail(), login.getPassword())).thenReturn(login);
//      when(userRepo.findByEmailIdAndPassword(anyString(), anyString())).thenReturn(user);
		mockMvc.perform(MockMvcRequestBuilders.post("/users/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(login)))
				.andExpect(status().isOk());
	}

	@Test
	void testChangepassword() throws Exception {
		Users user=new Users(54,"ravi","ravi2@gmail.com","Ravi@123","User",6789123456L);
		when(service.getByUserId(user.getUserId())).thenReturn(user);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.put("/users/changepassword/{userId}",54)
				.contentType("application/json")
				.content("{\"userId\":54,\"name\":\"ravi\",\"email\":\"ravi2@gmail.com\",\"password\":\"Ravi@12345\",\"role\":\"User\",\"contact\":6789123456}");
				mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	void testGetUsers() throws Exception {
		Users user1=new Users(54,"ravi2@gmail.com","ravi","Ravi@123","User",6789123456L);
		Users user2=new Users(61,"ramesh@gmail.com","ramesh","Ramesh@123","User",9789123456L);
		List<Users> userList=new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		when(service.getByRole("User")).thenReturn(userList);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/users/role/{role}","User");
		mockMvc.perform(requestBuilder)
		.andExpect(status().isOk())
		.andReturn();
	}

	@Test
	void testDeleteBookById() throws Exception {
		when(service.deleteUser(54)).thenReturn(true);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.delete("/users/{userId}",55);
		mockMvc.perform(requestBuilder)
		.andExpect(status().isOk());    
		
	}

}

package com.example.LogReg.serviceImpl;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.LogReg.dao.UsersDao;
import com.example.LogReg.exceptions.EmailIdAlreadyExistException;
import com.example.LogReg.exceptions.PasswordMissmatchException;
import com.example.LogReg.exceptions.UserIdAlreadyExistException;
import com.example.LogReg.model.ChangePassword;
import com.example.LogReg.model.Users;


@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {	
		
		@InjectMocks 
		UserServiceImpl userService;
		
		@Mock
		UsersDao userDao;
		
		List<Users> userList=new ArrayList<>();
		
		@BeforeEach
		void setup() {
			userList.add(new Users(61,"ramesh@gmail.com","ramesh","Ramesh@123","User",9789123456L));
			userList.add(new Users(54,"ravi2@gmail.com","ravi","Ravi@123","User",6789123456L));
			userList.add(new Users(62,"ramu@gmail.com","ramu","Ramu@123","User",7789123456L));		
		}
		
		@Test
		void addTest() throws EmailIdAlreadyExistException, UserIdAlreadyExistException {
			
			Optional<Users> optionaluser = Optional.empty();
			
			when(userDao.findById("ravi2@gmail.com")).thenReturn(optionaluser);
			when(userDao.findByUserId(54)).thenReturn(optionaluser);
			Users user= new Users(54,"ravi2@gmail.com","ravi","Ravi@123","User",6789123456L);

		   when(userDao.save(user)).thenReturn(user);	
			
			assertEquals(user, userService.add(user));
			
			Optional<Users> opt1 = Optional.empty();
			Optional<Users> opt2 = Optional.of(user);
			
			when(userDao.findById("ravi2@gmail.com")).thenReturn(opt1);
			when(userDao.findByUserId(54)).thenReturn(opt2);

			assertThrows(UserIdAlreadyExistException.class, ()-> userService.add(user));

			
		}
		@Test
		void addTes() throws EmailIdAlreadyExistException, UserIdAlreadyExistException {
			Optional<Users> optionaluser = Optional.empty();
			
			when(userDao.findById("ravi2@gmail.com")).thenReturn(optionaluser);
			
			Users user= new Users(54,"ravi2@gmail.com","ravi","Ravi@123","User",6789123456L);

		   when(userDao.save(user)).thenReturn(user);	
			
			assertEquals(user, userService.add(user));
			Optional<Users> opt1 = Optional.of(user);
			
			
			when(userDao.findById("ravi2@gmail.com")).thenReturn(opt1);
			
			
			assertThrows(EmailIdAlreadyExistException.class, () -> userService.add(user));
		}
		
		@Test
		void   loginTest() {
			Users user= new Users(54,"ravi2@gmail.com","ravi","Ravi@123","User",6789123456L);
			Users user2= new Users(54,"Lava@gmail.com","ravi","Ravi@123","User",6789123456L);

			for(Users users:userList) {
				if(user.getEmail()==users.getEmail()) {
					if(user.getPassword()==users.getPassword()) {
						Mockito.when(userDao.findByEmailAndPassword(user.getEmail(),user.getPassword())).thenReturn(users);
						assertEquals(users, userService.login(user.getEmail(),user.getPassword()));
					}
				}
				assertEquals(null, userService.login(user2.getEmail(),user2.getPassword()));
			}
		}
		
		@Test
		void upadePassword() throws PasswordMissmatchException{
			
			Users user= new Users(54,"ravi2@gmail.com","ravi","123","User",6789123456L);
			Users oldUser= new Users(54,"ravi2@gmail.com","ravi","Ravi@123","User",6789123456L);
			Optional<Users> optionaluser = Optional.of(oldUser);
			ChangePassword changePassword=new ChangePassword("Ravi@123","123");
			ChangePassword changePassword2=new ChangePassword("Lava@123","123");
			
			if(oldUser.getPassword().equals(changePassword.getOldpassword())) {
//				user.setPassword(changePassword.getNewpassword());
				
			when(userDao.findByUserId(anyInt())).thenReturn(optionaluser);
			when(userDao.save(any(Users.class))).thenReturn(user);
			
			assertEquals(user, userService.updatePassword(changePassword, oldUser.getUserId()));
			}
			
			
			assertThrows(PasswordMissmatchException.class, () -> userService.updatePassword(changePassword2,oldUser.getUserId()));

		}

			@Test
			void   testGetusersByEmail() {
				
			
				Users user1=new Users(54,"ravi2@gmail.com","ravi","Ravi@123","User",6789123456L);
				when(userDao.findById(user1.getEmail())).thenReturn(Optional.of(user1));
				assertEquals(user1,userService.getusersByEmail("ravi2@gmail.com"));
			}
			
			@Test
			void testGetByRole() {
				when(userDao.findByRole("User")).thenReturn(userList);
				assertEquals(userList, userService.getByRole("User"));
			}
			@Test
			void testGetByUserId() {
				Users user=new Users(54,"ravi2@gmail.com","ravi","Ravi@123","User",6789123456L);
				when(userDao.findByUserId(user.getUserId())).thenReturn(Optional.of(user));
				assertEquals(user,userService.getByUserId(54));
			}
			@Test
			void testDeleteUser() {
				Users user=new Users(54,"ravi2@gmail.com","ravi","Ravi@123","User",6789123456L);
				userDao.deleteById(user.getEmail());
				assertEquals(false, userService.deleteUser(user.getUserId()));
				assertThat(userDao.count()).isEqualTo(0);
			
				
			}
	}


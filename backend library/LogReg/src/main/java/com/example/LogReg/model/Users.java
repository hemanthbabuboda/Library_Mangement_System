package com.example.LogReg.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Transient;

@Entity
public class Users {

	@Id
	private String email;
	private String name;
	private int userId;
	private String password;
	
	private String role="User";
	@Transient
	private String cpassword;
	private long contact;
	
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Users(int userId,String email, String name, String password, String role, long contact) {
		super();
		this.email = email;
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.contact = contact;
	}
	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}




	public void setUserId(int userId) {
		this.userId = userId;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getCpassword() {
		return cpassword;
	}




	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}




	public long getContact() {
		return contact;
	}




	public void setContact(long contact) {
		this.contact = contact;
	}


	@Override
	public String toString() {
		return "Users [email=" + email + ", name=" + name + ", userId=" + userId + ", password=" + password + ", role="
				+ role + ", cpassword=" + cpassword + ", contact=" + contact + "]";
	}


	
	

}

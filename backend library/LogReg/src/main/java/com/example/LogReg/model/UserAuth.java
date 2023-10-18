package com.example.LogReg.model;

import javax.persistence.Id;


public class UserAuth {
	
	@Id
	private String email;
	private String password;
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserAuth() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserAuth(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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
	@Override
	public String toString() {
		return "UserAuth [email=" + email + ", password=" + password + "]";
	}
	
	

}

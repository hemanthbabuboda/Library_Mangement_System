package com.example.LogReg.model;

public class ChangePassword {
	
	private String oldpassword;
	private String newpassword;
	public ChangePassword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChangePassword(String oldpassword, String newpassword) {
		super();
		this.oldpassword = oldpassword;
		this.newpassword = newpassword;
	}
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	@Override
	public String toString() {
		return "ChangePassword [oldpassword=" + oldpassword + ", newpassword=" + newpassword + "]";
	}
	

}

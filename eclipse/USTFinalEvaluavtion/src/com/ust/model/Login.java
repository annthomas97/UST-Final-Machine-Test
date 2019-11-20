package com.ust.model;

public class Login {
	private int uerId;
	private String userName;
	private String password;
	
	//default constructor
	
	public Login() {
		super();
	}
	//parameterized constructor
	
	public Login(int uerId, String userName, String password) {
		super();
		this.uerId = uerId;
		this.userName = userName;
		this.password = password;
	}
	
	//getters and setters
	
	public int getUerId() {
		return uerId;
	}
	public void setUerId(int uerId) {
		this.uerId = uerId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//toString method
	
	@Override
	public String toString() {
		return "Login [uerId=" + uerId + ", userName=" + userName
				+ ", password=" + password + "]";
	}
	

}

package com.app.model;

public class UserRequest {

	
	private int id; 
	
	
	private String userName; 
	
	
	private int isActive; 
	
	
	private String expirationDateString;


	
	private String password;
	
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getIsActive() {
		return isActive;
	}


	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}


	public String getExpirationDateString() {
		return expirationDateString;
	}


	public void setExpirationDateString(String expirationDateString) {
		this.expirationDateString = expirationDateString;
	}
	
	
}

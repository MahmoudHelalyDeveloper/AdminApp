package com.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class Users {

@Id
@Column(name = "id")
	private int id; 
	
@Column(name = "username")
	private String userName;

@Column(name = "password")
private String password;

@Column(name = "isactive")
private int isActive;

@Column(name = "expiration_date")
private Date expirationDate;

@Column(name = "password_end_date")
private Date passwordEndDate;


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

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getIsActive() {
	return isActive;
}

public void setIsActive(int isActive) {
	this.isActive = isActive;
}

public Date getExpirationDate() {
	return expirationDate;
}

public void setExpirationDate(Date expirationDate) {
	this.expirationDate = expirationDate;
}

public Date getPasswordEndDate() {
	return passwordEndDate;
}

public void setPasswordEndDate(Date passwordEndDate) {
	this.passwordEndDate = passwordEndDate;
} 




}

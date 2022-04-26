package com.app.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user")
@NamedQuery(name = "Users.getRolesForUsers",query = "select u from Users u, UsersGroups ug , Groups g, RolesGroups rg,Role r where  u.id=ug.users.id and g.id=ug.groups.id and g.id=rg.groups.id and r.id=  rg.roles.id and userName=:name  ")
//@NamedQuery(name = "Users.getPerDay",query = "select u from Users U where u.")
public class Users {

@Id
@Column(name = "id")

@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id; 
	
@Column(name = "username")
	private String userName;
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

@Column(name = "password")
private String password;

@Column(name = "isactive")
private int isActive;
@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")

@Column(name = "expiration_date")
private Date expirationDate;
@Temporal(TemporalType.TIMESTAMP)
@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
@Column(name = "password_end_date")
private Date passwordEndDate;
@Column(name = "is_lock")
private int isLock;


@ManyToMany(fetch = FetchType.LAZY,
cascade = {
    CascadeType.PERSIST,
    CascadeType.MERGE
})
@JoinTable(name = "user_groups",
  joinColumns = { @JoinColumn(name = "user_id",referencedColumnName = "id") },
  inverseJoinColumns = { @JoinColumn(name = "group_id",referencedColumnName = "id")})
List<Groups> groups = new ArrayList<Groups>();




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

public int getIsLock() {
	return isLock;
}

public void setIsLock(int isLock) {
	this.isLock = isLock;
} 




}

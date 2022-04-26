package com.app.entity;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
public class Groups {
@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
@Column(name = "name")
	private String name; 
	
	
@Column(name = "isactive")
	private int isActive;

@ManyToMany
@JoinTable(name = "user_groups",
joinColumns = { @JoinColumn(name = "group_id",referencedColumnName = "id") },
inverseJoinColumns = { @JoinColumn(name = "user_id",referencedColumnName = "id") })
private List<Users> users = new ArrayList<Users>();



@ManyToMany
@JoinTable(name = "roles_groups",
joinColumns = { @JoinColumn(name = "group_id",referencedColumnName = "id") },
inverseJoinColumns = { @JoinColumn(name = "role_id",referencedColumnName = "id") })
private List<Role> roles = new ArrayList<Role>();

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getIsActive() {
		return isActive;
	}


	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}


	public List<Users> getUsers() {
		return users;
	}


	public void setUsers(List<Users> users) {
		this.users = users;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	} 
	
	
	
	
}

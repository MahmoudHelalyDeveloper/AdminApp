package com.app.model;

import java.util.List;

import com.app.entity.Groups;
import com.app.entity.Users;


public class UsersGroupRequest {

	
	private Groups groups;
	
	
	private List<Users> users;


	public Groups getGroups() {
		return groups;
	}


	public void setGroups(Groups groups) {
		this.groups = groups;
	}


	public List<Users> getUsers() {
		return users;
	}


	public void setUsers(List<Users> users) {
		this.users = users;
	}




}

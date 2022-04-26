package com.app.service;

import java.util.List;

import com.app.entity.Role;
import com.app.entity.Users;

public abstract class UserService {

	
	public abstract Users checkLogin(String name, int active);
	
	public abstract Users addUser(Users users); 
	
	public abstract List<Role> getRolesFoUsers(String userName);
	public abstract  List<Users> logFaild();
	
	public abstract Users getUser(String name);
	
	public abstract Users lockOrUnlock(int active,Users users);

	
}

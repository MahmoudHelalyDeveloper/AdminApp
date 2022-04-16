package com.app.service;

import com.app.entity.Users;

public abstract class UserService {

	
	public abstract Users checkLogin(String name);
	
	public abstract Users addUser(Users users);
}

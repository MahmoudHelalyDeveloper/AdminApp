package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Users;
import com.app.repo.UserRepo;
@Service
public class UserServiceImpl extends UserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public Users checkLogin(String name) {
		// TODO Auto-generated method stub
		return userRepo.findByUserName(name);
	} 
	
	@Override
	public Users addUser(Users users) {
		// TODO Auto-generated method stub
		
		return this.userRepo.save(users);
	}
}

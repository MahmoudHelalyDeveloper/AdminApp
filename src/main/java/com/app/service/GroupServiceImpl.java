package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Groups;
import com.app.entity.Users;
import com.app.entity.UsersGroups;
import com.app.model.UsersGroupRequest;
import com.app.model.UsersGroupResponse;
import com.app.repo.GroupRepo;
import com.app.repo.UserGroupsRepo;
@Service
public class GroupServiceImpl extends GroupService {

	@Autowired
	private GroupRepo groupRepo;
	
	@Autowired
	private UserGroupsRepo UserGroupsRepo;
	
	@Override
	public List<Groups> getAll() {
		// TODO Auto-generated method stub
		return this.groupRepo.findAll();
	}
	@Override
public Groups addGroups(Groups groups) {
	// TODO Auto-generated method stub
	return this.groupRepo.save(groups);
}
	@Override
	public Groups findGroup(int id) {
		// TODO Auto-generated method stub
		return this.groupRepo.findById(id).get();
	}
	
	@Override
	public Groups updateGroup(Groups groups) {
		// TODO Auto-generated method stub
		
		return this.groupRepo.save(groups);
	}
	
	@Override
	public void deleteGroup(int id) {
		// TODO Auto-generated method stub
		Groups groups = this.groupRepo.findById(id).get();	
	 this.groupRepo.delete(groups);
	}
	@Override
	public UsersGroupResponse addUsersToGroup(UsersGroupRequest userGroups) {
		// TODO Auto-generated method stub
		UsersGroups usersGroups = new UsersGroups();
		usersGroups.setGroups(userGroups.getGroups());
		List<Users> users = userGroups.getUsers();
		List<Users> usersResponse =new ArrayList<Users>();
		int id=0;
		UsersGroupResponse response = new UsersGroupResponse();
		for (Users users2 : users) {
			id++;
			usersGroups.setUsers(users2);;
			usersGroups.setId(id);
			UsersGroups save = this.UserGroupsRepo.save(usersGroups);
			usersResponse.add(save.getUsers());
			response.setGroups(save.getGroups());
			
		}
		response.setUsers(usersResponse);
		
		return response;
	}
	
}

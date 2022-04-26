package com.app.service;

import java.util.List;

import com.app.entity.Groups;
import com.app.entity.UsersGroups;
import com.app.model.UsersGroupRequest;
import com.app.model.UsersGroupResponse;

public abstract class GroupService {

	public abstract  List<Groups> getAll();
	public abstract Groups  addGroups (Groups groups);
	public abstract Groups  findGroup (int id);
	
	public abstract Groups updateGroup (Groups groups);
	
	public abstract void deleteGroup(int id);
	/// ADD USERS TO GROUP 
	public abstract UsersGroupResponse addUsersToGroup(UsersGroupRequest userGru);
}

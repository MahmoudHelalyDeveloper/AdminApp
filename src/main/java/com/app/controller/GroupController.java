package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Groups;
import com.app.exception.ExceptionSecurity;
import com.app.model.UsersGroupRequest;
import com.app.model.UsersGroupResponse;
import com.app.service.GroupService;
import com.app.util.SecurityConstant;
import com.app.util.SecurityInterface;

@RestController
@RequestMapping("group")
public class GroupController {

	@Autowired
	private GroupService groupService;

	@PostMapping("/addGroup")
	@SecurityInterface(checkApi = SecurityConstant.addGroup)
	public Groups addGroups(@RequestBody Groups groups)  {

	return this.groupService.addGroups(groups);
//throw new ExceptionSecurity("invaled Data");
	}

	@PostMapping("/updateGroup")
	@SecurityInterface(checkApi = SecurityConstant.updateGroup)
	public Groups updateGroups(@RequestBody Groups groups) {

		return this.groupService.updateGroup(groups);

	}

	@GetMapping("/getGroups")
	@SecurityInterface(checkApi = SecurityConstant.viewGroup)
	public List<Groups> getAll() {

		return this.groupService.getAll();

	}

	@GetMapping("/getGroup")
	@SecurityInterface(checkApi = SecurityConstant.viewGroup)

	public Groups findGroup(@RequestParam int id) throws Exception {

		return this.groupService.findGroup(id);
	}
	
	@DeleteMapping("/deleteGroup")
	@SecurityInterface(checkApi = SecurityConstant.deleteGroup)
	public String deleteGroup(@RequestParam int id) throws Exception {

		 this.groupService.deleteGroup(id);
		 return "Delete";
	}


	/// add users to group

	@PostMapping("/addUserToGroup")
	public UsersGroupResponse addUsersToGroup(@RequestBody UsersGroupRequest usersGroupRequest) {

		return this.groupService.addUsersToGroup(usersGroupRequest);

	}

}

package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.RolesGroups;
import com.app.service.PrivilegesService;

@RestController
@RequestMapping("privileges")
public class PrivilegesController {

	@Autowired
	private PrivilegesService privilegesService;
	@RequestMapping("/findAll")
	public List<RolesGroups> findAll() {
		
		return this.privilegesService.findPrivileges();
		
	}
	
	
	@PostMapping("/addPrivilege")
	public RolesGroups addPrivilege( @RequestBody RolesGroups rolesGroups) {
		
		
		return this.privilegesService.addPrivilege(rolesGroups);
	}
	
}

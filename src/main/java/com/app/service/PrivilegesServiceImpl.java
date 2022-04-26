package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.RolesGroups;
import com.app.repo.Privileges;

@Service
public class PrivilegesServiceImpl extends PrivilegesService {

	@Autowired
	private Privileges privileges;
	@Override
	public List<RolesGroups> findPrivileges() {
		// TODO Auto-generated method stub
		return this.privileges.findAll();
	}
	
	@Override
	public RolesGroups addPrivilege(RolesGroups rolesGroups) {
		// TODO Auto-generated method stub
		return this.privileges.save(rolesGroups);
	}
}

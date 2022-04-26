package com.app.service;

import java.util.List;

import com.app.entity.RolesGroups;

public abstract class PrivilegesService {

	
	public abstract RolesGroups addPrivilege(RolesGroups rolesGroups);
	
	
	public abstract List<RolesGroups> findPrivileges();
	
}

package com.app.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.entity.Role;
import com.app.entity.RolesGroups;

@Component
public class SessonUser {

	
	private  List<Role> roles;
	
	private boolean isUpdatedPassord;

	public boolean isUpdatedPassord() {
		return isUpdatedPassord;
	}

	public void setUpdatedPassord(boolean isUpdatedPassord) {
		this.isUpdatedPassord = isUpdatedPassord;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	


}

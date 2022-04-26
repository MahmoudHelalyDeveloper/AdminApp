package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@NamedQuery(name = "Role.getRolesForUsers",query = "select r from Users u, UsersGroups ug , Groups g, RolesGroups rg,Role r where  u.id=ug.users.id and g.id=ug.groups.id and g.id=rg.groups.id and r.id=  rg.roles.id and userName=:userName   ")

public class Role {

	
	
	@Id
	@Column(name = "id")
	private int id; 
	
	@Column(name = "name")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}





}



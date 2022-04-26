package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Role;
import com.app.entity.Users;
@Repository
public interface RoleRepo  extends JpaRepository<Role, Integer> {

	
	public List<Role> getRolesForUsers (String userName);

}

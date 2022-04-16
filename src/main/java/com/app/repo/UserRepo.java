package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Users;
@Repository
public interface UserRepo  extends JpaRepository<Users, Integer> {

	
	public Users findByUserName(String name);
}

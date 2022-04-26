package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.UsersGroups;

public interface UserGroupsRepo  extends JpaRepository<UsersGroups, Integer> {

}

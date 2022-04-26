package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.RolesGroups;

@Repository
public interface Privileges extends JpaRepository<RolesGroups	, Integer> {

}

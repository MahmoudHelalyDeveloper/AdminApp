package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Groups;
@Repository
public interface GroupRepo  extends JpaRepository<Groups, Integer> {

	
}

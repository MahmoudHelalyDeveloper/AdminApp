package com.app.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.Users;
@Repository
public interface UserRepo  extends JpaRepository<Users, Integer> {

	
	public Users findByUserNameAndIsActiveAndExpirationDateGreaterThan(String name,int active,Date currentDate);
	@Query("select e from Users e where year(e.passwordEndDate) = ?1 and month(e.passwordEndDate) = ?2 and day(e.passwordEndDate) = ?3")
	public List<Users> findByPasswordEndDateJpaql(int year, int month,int day);
	
	public Users findByUserName(String name);

	
}

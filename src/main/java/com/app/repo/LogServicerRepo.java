package com.app.repo;

import org.hibernate.type.NTextType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.LogService;
@Repository
public interface LogServicerRepo  extends JpaRepository<LogService, Integer>{
@Query( "select count(*) from LogService l where year(l.logDate)=?1 and month(l.logDate)=?2 and day(l.logDate)=?3 and l.userName=?4")
//where year(e.passwordEndDate) = ?1 and month(e.passwordEndDate) = ?2 and day(e.passwordEndDate) = ?3
	public int countLoginFaildPerDay(int year ,int month , int day, String name);
}

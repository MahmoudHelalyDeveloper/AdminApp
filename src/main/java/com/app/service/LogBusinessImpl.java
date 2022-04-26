package com.app.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.LogService;
import com.app.repo.LogServicerRepo;
@Service
public class LogBusinessImpl extends LogBusiness {
@Autowired
	private LogServicerRepo logServicerRepo;
	
	@Override
	public LogService saveLogService(LogService logService) {
		// TODO Auto-generated method stub
		return this.logServicerRepo.save(logService);
	}
@Override
	public int contLogingFalidForLogin(String userName) {
		// TODO Auto-generated method stub
	Date date = new Date();
	LocalDate currentDate = date.toInstant()
		      .atZone(ZoneId.systemDefault())
		      .toLocalDate();
		return this.logServicerRepo.countLoginFaildPerDay(currentDate.getYear(), currentDate.getMonthValue(), currentDate.getDayOfMonth(), userName);
	}
}

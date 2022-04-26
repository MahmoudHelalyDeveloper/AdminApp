package com.app.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Role;
import com.app.entity.Users;
import com.app.repo.RoleRepo;
import com.app.repo.UserRepo;

@Service
public class UserServiceImpl extends UserService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RoleRepo RoleRepo;

	@Override
	public Users checkLogin(String name, int active) {
		// TODO Auto-generated method stub
		return userRepo.findByUserNameAndIsActiveAndExpirationDateGreaterThan(name, active, new Date());
	}

	@Override
	public Users addUser(Users users) {
		// TODO Auto-generated method stub

		return this.userRepo.save(users);
	}

	@Override
	public List<Role> getRolesFoUsers(String userName) {
		// TODO Auto-generated method stub
		return this.RoleRepo.getRolesForUsers(userName);
	}

	public List<Users> logFaild() {
		LocalDate currentdate = LocalDate.now();

		int day = currentdate.getDayOfMonth();
		int month = currentdate.getMonthValue();
		int year = currentdate.getYear();
		return this.userRepo.findByPasswordEndDateJpaql(year, month, 20);

	}

	@Override
	public Users getUser(String name) {
		// TODO Auto-generated method stub
		return this.userRepo.findByUserName(name);
	}

	@Override
	public Users lockOrUnlock(int active, Users users) {
		// TODO Auto-generated method stub
		users.setIsLock(active);
		return this.userRepo.save(users);
	}

}

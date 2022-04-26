package com.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.entity.Role;
import com.app.entity.Users;
import com.app.model.SessonUser;
import com.app.util.ConverterDate;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	   @Autowired
	     private SessonUser SessonUser;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users checkLogin = userService.checkLogin(username,1);
		if (null == checkLogin) {

			throw new UsernameNotFoundException("User not found with username: " + username);
		}

		if (checkLogin.getUserName().equals(username)) {
			List<Role> rolesFoUsers = userService.getRolesFoUsers(username);
			this.SessonUser.setRoles(rolesFoUsers);
			Integer months = ConverterDate.getMonths(new Date(), checkLogin.getPasswordEndDate());
			if (months>=3) {
				this.SessonUser.setUpdatedPassord(true);
				
			}
			return new User(checkLogin.getUserName(), checkLogin.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
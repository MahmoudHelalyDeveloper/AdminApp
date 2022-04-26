package com.app.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Role;
import com.app.entity.Users;
import com.app.model.ChangePasswordRequest;
import com.app.model.SessonUser;
import com.app.model.UserRequest;
import com.app.service.UserService;
import com.app.util.ConverterDate;
import com.app.util.SecurityConstant;
import com.app.util.SecurityInterface;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	@SecurityInterface(checkApi = SecurityConstant.addUser)
	public Users addUsers(@RequestBody Users users) throws Exception {
		System.err.println("!");
		System.err.println("@");

//	Users user = new Users();
//	
//	user.setId(users.getId());
//	user.setUserName(users.getUserName());
//	user.setIsActive(0);
//	user.setPassword(users.getPassword());
//	try {
//		user.setExpirationDate(ConverterDate.formString(users.getExpirationDateString()));
//	} catch (ParseException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}

		Users addUser = this.userService.addUser(users);

//	return null;
		return addUser;
	}

	@PostMapping("/changePassword")
	public ResponseEntity<Users> changePassword(ChangePasswordRequest changePassword) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ZoneId defaultZoneId = ZoneId.systemDefault();

		Users checkLogin = this.userService.checkLogin(userDetails.getUsername(), 1);
//	LocalDate futureDate = LocalDate.now().plusMonths(3); 
		LocalDate futureDate = checkLogin.getPasswordEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
				.plusMonths(3);

		Date date = Date.from(futureDate.atStartOfDay(defaultZoneId).toInstant());

		checkLogin.setPasswordEndDate(date);
		/// save passwrd and handle this issue
		return new ResponseEntity<Users>(checkLogin, HttpStatus.OK);
	}

//@GetMapping
//public Users getRolesUsers( @RequestParam String name) {}

	@PostMapping("checkLogin")
	public String fidnUsers() {

		 Users users = this.userService.logFaild().get(0);
		 Date passwordEndDate = users.getPasswordEndDate();
		 Date curentDate = new Date();
		 
		 LocalDate passworDate = passwordEndDate.toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
		
		 LocalDate plusDays = passworDate.plusDays(3);
		 LocalDate currentDate = curentDate.toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
		 
		 boolean after = plusDays.isBefore(currentDate);
		 
		 return ""+after;
	}
}

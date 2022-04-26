package com.app.controller;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.app.service.JwtUserDetailsService;
import com.app.service.LogBusiness;
import com.app.service.UserService;
import com.app.configure.JwtTokenUtil;
import com.app.entity.LogService;
import com.app.entity.Role;
import com.app.entity.Users;
import com.app.exception.BusinessException;
import com.app.model.JwtRequest;
import com.app.model.JwtResponse;
import com.app.model.SessonUser;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	@Autowired
	private UserService userService;

	/// we will remove this service after we create Aop Layer
	@Autowired
	private LogBusiness logBusiness;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		// CHECK END PASSWORD DATE

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws BusinessException {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new BusinessException("USER_DISABLED", null, HttpStatus.UNAUTHORIZED);
		} catch (BadCredentialsException e) {

			LogService logService = new LogService();
			logService.setLogDate(new Date());
			logService.setServiceName("login");
			logService.setStatus(0);/// falid
			logService.setUserName(username);
			this.logBusiness.saveLogService(logService);
			int contLogingFalidForLogin = this.logBusiness.contLogingFalidForLogin(username);
			if (contLogingFalidForLogin<5) {
				throw new BusinessException("invalid username or password ", null, HttpStatus.UNAUTHORIZED);
			} else {
				Users user = userService.getUser(username);
				Users addUser = this.userService.lockOrUnlock(1, user);
				throw new BusinessException("userName is Locked ", null, HttpStatus.UNAUTHORIZED);

			}
		}
	}
}
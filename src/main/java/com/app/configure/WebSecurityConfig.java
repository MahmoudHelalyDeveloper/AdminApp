package com.app.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

@ComponentScan(basePackages = { "com.app.configure" })

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		System.err.println("Configure");
//		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
//
//	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
System.err.println("AuthenticationManagerBuilder !!");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = "123";
		String encodedPassword = passwordEncoder.encode(password);
		System.err.println("encode is " + encodedPassword);
		System.err.println("Mahmoud helaly " + auth);
		String x = "123";
		PasswordEncoder z = new BCryptPasswordEncoder();
		String hashedPassword = z.encode(x);
		System.err.println(hashedPassword);
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(bCryptPasswordEncoder());

	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// We don't need CSRF for this example
		httpSecurity.csrf().disable()
				// dont authenticate this particular request
				.authorizeRequests().antMatchers("/authenticate").permitAll().
				// all other requests need to be authenticated
				anyRequest().authenticated().and().
				// make sure we use stateless session; session won't be used to
				// store user's state.
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}


}
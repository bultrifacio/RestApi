package com.arroyo.carlos.juan.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.arroyo.carlos.juan.repositories.UserRepository;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationManagerBuilder builder,
			UserRepository userRepository) throws Exception {
		return super.authenticationManagerBean();
	}
	

}
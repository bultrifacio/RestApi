package com.arroyo.carlos.juan.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arroyo.carlos.juan.model.User;
import com.arroyo.carlos.juan.repository.UserRepository;

@RestController
public class UserController {

	private UserRepository userRepository;
	private User user;
	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public List<User> getUsers() {
		return new ArrayList<>(userRepository.findAll());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
	public User getUser(@PathVariable Long id) {
		return userRepository.findById(id).get();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public void createUser(@RequestBody User user) {
		this.user = null;
		this.user.setRole(user.getRole());
		this.user.setUsername(user.getUsername());
		this.user.setPassword(user.getPassword());
		userRepository.save(this.user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public boolean deleteUser(@PathVariable Long id) {
		if (userRepository.findById(id) != null) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
		
	}

	@RequestMapping(method = RequestMethod.PATCH, value = "/users/{id}")
	public boolean updateUser(@PathVariable Long id, @RequestBody User user) {
		if (userRepository.findById(id) != null) {
			this.user = userRepository.findById(id).get();
			if (user.getUsername() != null && user.getUsername() != this.user.getUsername())
				this.user.setUsername(user.getUsername());
			if (user.getRole() != null && user.getRole().getId() != this.user.getRole().getId())
				this.user.setRole(user.getRole());
			if (user.getPassword() != null && user.getPassword() != this.user.getPassword())
				this.user.setPassword(user.getPassword());
			userRepository.save(this.user);
			return true;
		}
		return false;
		
	}
	

}

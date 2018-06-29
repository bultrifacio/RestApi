package com.arroyo.carlos.juan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arroyo.carlos.juan.model.Role;
import com.arroyo.carlos.juan.model.User;
import com.arroyo.carlos.juan.services.UserService;

@RestController
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable Long id) {
		userService.updateUser(user, id);
	}

	@RequestMapping(method = RequestMethod.PATCH, value = "/users/roles/add/{id}")
	public void addRoles(@RequestBody Role role, @PathVariable Long id) {
		userService.addRole(role, id);
	}

	@RequestMapping(method = RequestMethod.PATCH, value = "/users/roles/remove/{id}")
	public void removeRole(@RequestBody Role role, @PathVariable Long id) {
		userService.removeRole(role, id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}

}

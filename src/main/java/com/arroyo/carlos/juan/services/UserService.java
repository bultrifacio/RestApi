package com.arroyo.carlos.juan.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.arroyo.carlos.juan.model.Role;
import com.arroyo.carlos.juan.model.User;
import com.arroyo.carlos.juan.repositories.UserRepository;
import com.arroyo.carlos.juan.security.AuthorizationUserDetails;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private User user;

	@Autowired
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public List<User> getUsers() {
		return new ArrayList<>(userRepository.findAll());
	}

	public User getUser(Long id) {
		return userRepository.findOne(id);
	}

	public boolean createUser(User user) {
		if (userRepository.findOne(user.getId()) == null) {
			userRepository
					.save(new User(user.getUsername(), passwordEncoder.encode(user.getPassword()), user.getRoles()));
			return true;
		}
		return false;
	}

	public boolean updateUser(User user, Long id) {
		if (userRepository.findOne(id) != null) {
			this.user = userRepository.findOne(id);
			if (user.getUsername() != null && user.getUsername() != this.user.getUsername())
				this.user.setUsername(user.getUsername());
			if (user.getPassword() != null)
				this.user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(this.user);
			return true;
		}
		return false;
	}

	public void addRole(Role role, Long id) {
		user = userRepository.findOne(id);
		user.addRole(role);
		userRepository.save(user);
	}

	public void removeRole(Role role, Long id) {
		user = userRepository.findOne(id);
		user.removeRole(role);
		userRepository.save(user);
	}

	public boolean deleteUser(Long id) {
		if (userRepository.findOne(id) != null) {
			userRepository.delete(id);
			return true;
		}
		return false;
	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		return new AuthorizationUserDetails(userRepository.findUserByUsername(s));
	}

}
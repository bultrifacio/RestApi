package com.arroyo.carlos.juan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arroyo.carlos.juan.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findUserByUsername(String username);
}

package com.arroyo.carlos.juan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arroyo.carlos.juan.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findUserByUsername(String username);
}

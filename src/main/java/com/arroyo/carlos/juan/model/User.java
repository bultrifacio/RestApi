package com.arroyo.carlos.juan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "userName", unique = true, nullable = false)
	private String username;
	
	@JsonIgnore
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "roleId", nullable = false)
	private Long roleId;
	
	private User() {}
	
	public User(final String username, final String password, final Long roleId) {
		this.username = username;
		this.password = password;
		this.roleId = roleId;
	}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	
	
	
	
}

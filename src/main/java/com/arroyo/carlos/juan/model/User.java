package com.arroyo.carlos.juan.model;

import static javax.persistence.GenerationType.AUTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = AUTO)
	@Column(name = "id", updatable = false, nullable = false, unique = true)
	private Long id;
	
	@Column(name = "user_name", nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Role> roles;

	public User() {}

	public User(String username, String password, List<Role> roles) {
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void addRole(Role role) {
		if (this.getRole(role) == null)
			roles.add(role);
	}

	public void removeRole(Role role) {
		roles.remove(getRole(role));
	}

	private Role getRole(Role role) {
		for (Role roleElement : roles) {
			if (roleElement.getName().equals(role.getName()))
				return roleElement;
		}
		return null;
	}

}

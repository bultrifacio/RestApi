package com.arroyo.carlos.juan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String roleName;
	
	private Role () {}
	
	public Role(final String roleName) {
		this.roleName = roleName;
	}

	public long getId() {
		return id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}

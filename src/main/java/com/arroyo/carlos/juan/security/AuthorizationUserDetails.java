package com.arroyo.carlos.juan.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.arroyo.carlos.juan.model.Role;
import com.arroyo.carlos.juan.model.User;

public class AuthorizationUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Collection<? extends GrantedAuthority> authorities;
	private String username;
	private String password;

	public AuthorizationUserDetails(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		List<GrantedAuthority> auths = new ArrayList<>();
		for (Role role : user.getRoles())
			auths.add(new SimpleGrantedAuthority(role.getName()));
		this.authorities = auths;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

package com.greatlearning.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.greatlearning.entity.Role;
import com.greatlearning.entity.User;

public class DomainUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private User user;

	public DomainUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> roles = this.user.getRoles();
		//input -> stream of Roles
		//output -> Stream of Roles (String)
		Stream<String> roleStream = roles.stream().map(role -> role.getRole());
		// input -> stream of roleString
		// output -> stream of GrantedAuthority
		Stream<SimpleGrantedAuthority> streamOfGrantedAuthorities = roleStream.map(roleString -> new SimpleGrantedAuthority(roleString));
		Set<SimpleGrantedAuthority> setOfGrantedAuthorities = streamOfGrantedAuthorities.collect(Collectors.toSet());
		return setOfGrantedAuthorities;
		//return this.user.getRoles().stream().map(Role::getRole).map(SimpleGrantedAuthority::new).collect(toSet());
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getName();
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

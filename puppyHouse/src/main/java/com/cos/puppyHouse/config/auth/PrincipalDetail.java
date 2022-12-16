package com.cos.puppyHouse.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.puppyHouse.model.Users;

import lombok.Getter;

@Getter
@SuppressWarnings("serial")
public class PrincipalDetail implements UserDetails{
	private Users user;

	public PrincipalDetail(Users user) {
		this.user=user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(()->{return "ROLE_"+user.getRoles();});
		return collectors;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getUserpassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserid();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}

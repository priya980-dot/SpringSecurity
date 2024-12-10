package com.project.security.Model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails{
private Users user;
	
	public UserPrincipal(Users user) {
		this.user=user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Collections.singleton( new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
    public boolean isAccountNonExpired() {
        return true; // Set logic to check if the account has expired
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Set logic to check if the account is locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Set logic to check if credentials have expired
    }

    @Override
    public boolean isEnabled() {
        return true; // Set logic to check if the user is enabled
    }
}

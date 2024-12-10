package com.project.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.web.server.ServerSecurityMarker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.security.Model.UserPrincipal;
import com.project.security.Model.Users;
import com.project.security.Repository.UsersRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsersRepo ur;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user= ur.findByUsername(username);
		if(user==null) {
			System.out.println("no such user found");
			throw new UsernameNotFoundException("no such user found");
		}
		
		return new UserPrincipal(user);
		
	}

}

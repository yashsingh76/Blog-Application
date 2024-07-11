package com.blog.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blog.app.entities.User;
import com.blog.app.exceptionhandler.ResourceNotFoundException;
import com.blog.app.repositories.UserRepo;

@Service
public class CustomUserDeatailService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//loading user from the database by username
		User user = this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User","email: "+username, 0));
				
		return user;
	}

}

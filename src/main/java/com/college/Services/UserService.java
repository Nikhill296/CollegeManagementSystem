package com.college.Services;

import org.apache.catalina.UserDatabase;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.college.Repositories.UserDetailsRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService implements UserDetailsService {

	UserDetailsRepository userDetailsRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return userDetailsRepo.findByEmail(username);
	}

}

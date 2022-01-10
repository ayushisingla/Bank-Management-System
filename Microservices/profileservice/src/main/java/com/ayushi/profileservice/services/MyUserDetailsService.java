package com.ayushi.profileservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ayushi.profileservice.entity.Customer;
import com.ayushi.profileservice.repos.CustomerRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	CustomerRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Customer> cust = repo.findByUsername(username);
		if (cust.size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
		} else {
			return new User(cust.get(0).getUsername(), cust.get(0).getPassword(), new ArrayList<>());
		}

	}

}

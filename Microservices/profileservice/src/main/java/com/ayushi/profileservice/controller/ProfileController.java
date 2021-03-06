package com.ayushi.profileservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ayushi.profileservice.entity.Customer;
import com.ayushi.profileservice.entity.Profile;
import com.ayushi.profileservice.models.AuthenticationRequest;
import com.ayushi.profileservice.models.AuthenticationResponse;
import com.ayushi.profileservice.repos.CustomerRepo;
import com.ayushi.profileservice.services.MyUserDetailsService;
import com.ayushi.profileservice.util.JwtUtil;

@RestController
@RequestMapping("/profileapi")
public class ProfileController {

	@Autowired
	CustomerRepo repo;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtTokenUtil;

	Customer customer;

	@RequestMapping(value = "/viewProfile/{username}", method = RequestMethod.GET)
	public Customer viewProfile(@PathVariable("username") String username) {
		List<Customer> customer = repo.findByUsername(username);
		if (customer.size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
		} else {
			return customer.get(0);
		}
	}

	@RequestMapping(value = "/updateProfile/{username}", method = RequestMethod.PUT)
	public Customer profileupdate(@PathVariable("username") String username, @RequestBody Profile profile) {
		List<Customer> customerInfo = repo.findByUsername(username);
		if (customerInfo.size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
		} else {
			customerInfo.get(0).setCustomername(profile.getCustomername());
			customerInfo.get(0).setEmail(profile.getEmail());
			customerInfo.get(0).setContactno(profile.getContactno());
			customerInfo.get(0).setPassword(profile.getPassword());
			repo.save(customerInfo.get(0));
		}
		return customerInfo.get(0);
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}

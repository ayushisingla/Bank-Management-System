package com.ayushi.authservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ayushi.authservice.entity.Customer;
import com.ayushi.authservice.entity.LoginDetails;
import com.ayushi.authservice.models.AuthenticationRequest;
import com.ayushi.authservice.models.AuthenticationResponse;
import com.ayushi.authservice.repos.CustomerRepo;
import com.ayushi.authservice.services.MyUserDetailsService;
import com.ayushi.authservice.util.JwtUtil;

@RestController
@RequestMapping("/authapi")
@RefreshScope
public class CustomerRegistrationController {

	@Value("${com.ayushi.auth-service.prop}")
	private String prop;

	@Autowired
	private CustomerRepo repo;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@GetMapping(value = "/prop")
	public String getProp() {
		return this.prop;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Customer registerCustomer(@Valid @RequestBody Customer customer) {
		List<Customer> cust = repo.findByUsername(customer.getUsername());
		if (cust.size() == 0) {
			return repo.save(customer);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginCustomer(@RequestBody LoginDetails loginDetails) {
		repo.findByUsername(loginDetails.getUsername());
		List<Customer> customer = repo.findByUsername(loginDetails.getUsername());
		String originalPassword = customer.get(0).getPassword();
		if (loginDetails.getPassword().equals(originalPassword)) {
			return "Login Successful";
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
		}

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

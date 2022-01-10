package com.ayushi.loanservice.models;

public class AuthenticationResponse {

	private String jwt;

	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
		// TODO Auto-generated constructor stub
	}

	public String getJwt() {
		return jwt;
	}
}

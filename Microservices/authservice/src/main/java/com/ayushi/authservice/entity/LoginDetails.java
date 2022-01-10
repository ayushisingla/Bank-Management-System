package com.ayushi.authservice.entity;

import javax.validation.constraints.NotEmpty;

public class LoginDetails {

	@NotEmpty(message = "Name field cannot be empty")
	private String username;

	@NotEmpty(message = "Password field cannot be empty")
	private String password;

	@Override
	public String toString() {
		return "LoginDetails [username=" + username + ", password=" + password + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

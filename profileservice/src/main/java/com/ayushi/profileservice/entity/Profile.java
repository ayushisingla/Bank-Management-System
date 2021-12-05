package com.ayushi.profileservice.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Profile {

	@NotEmpty(message = "Name field cannot be empty")
	private String customername;

	@NotEmpty(message = "Email field cannot be empty")
	@Email
	private String email;

	@Pattern(regexp = "[789]{1}[0-9]{9}") // 7347390097
	@NotNull(message = "Contact Number field cannot be empty")
	private String contactno;

	@NotEmpty(message = "Password field cannot be empty")
	private String password;

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	@Override
	public String toString() {
		return "Profile [customername=" + customername + ", password=" + password + ", email=" + email + ", contactno="
				+ contactno + "]";
	}
}

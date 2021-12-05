package com.ayushi.loanservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@Column(name = "accountno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountNo;

	@NotEmpty(message = "Name field cannot be empty")
	private String customername;

	@NotEmpty(message = "Name field cannot be empty")
	private String username;

	@NotEmpty(message = "Password field cannot be empty")
	private String password;

	@NotEmpty(message = "Email field cannot be empty")
	@Email
	private String email;

	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}") // YYYY-MM-DD
	@NotEmpty(message = "Date of Birth field cannot be empty")
	private String dob;

	@Pattern(regexp = "[789]{1}[0-9]{9}") // 7347390097
	@NotEmpty(message = "Contact Number field cannot be empty")
	private String contactno;

	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}") // ABCDE1234A
	@NotEmpty(message = "PAN number field cannot be empty")
	private String panno;

	@NotEmpty(message = "Account Type field cannot be empty")
	private String accounttype;

	@NotEmpty(message = "Address field cannot be empty")
	private String address;

	@NotEmpty(message = "City field cannot be empty")
	private String city;

	@NotEmpty(message = "State field cannot be empty")
	private String state;

	@NotEmpty(message = "Country field cannot be empty")
	private String country;

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Customer [accountNo=" + accountNo + ", customername=" + customername + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", dob=" + dob + ", contactno=" + contactno
				+ ", panno=" + panno + ", accounttype=" + accounttype + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", country=" + country + "]";
	}

}

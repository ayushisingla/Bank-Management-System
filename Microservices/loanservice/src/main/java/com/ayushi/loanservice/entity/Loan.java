package com.ayushi.loanservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "loan")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "Loan Id field cannot be empty")
	private int loanid;

	@NotEmpty(message = "Loan Type field cannot be empty")
	private String loantype;

	@NotNull(message = "Loan Amount field cannot be empty")
	private int loanamount;

	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}") // YYYY-MM-DD
	private String date;

	@NotNull(message = "Rate of interest field cannot be empty")
	private int rateofinterest;

	@NotNull(message = "Duration field cannot be empty")
	private int duration;

	@NotEmpty(message = "Username field cannot be empty")
	private String username;
	private boolean loanstatus = false;

	public String getLoantype() {
		return loantype;
	}

	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}

	public int getLoanamount() {
		return loanamount;
	}

	public void setLoanamount(int loanamount) {
		this.loanamount = loanamount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getRateofinterest() {
		return rateofinterest;
	}

	public void setRateofinterest(int rateofinterest) {
		this.rateofinterest = rateofinterest;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getLoanid() {
		return loanid;
	}

	public void setLoanid(int loanid) {
		this.loanid = loanid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean getLoanstatus() {
		return loanstatus;
	}

	public void setLoanstatus(boolean loanstatus) {
		this.loanstatus = loanstatus;
	}

	@Override
	public String toString() {
		return "Loan [loanid=" + loanid + ", loantype=" + loantype + ", loanamount=" + loanamount + ", date=" + date
				+ ", rateofinterest=" + rateofinterest + ", duration=" + duration + ", username=" + username
				+ ", loanstatus=" + loanstatus + "]";
	}
}

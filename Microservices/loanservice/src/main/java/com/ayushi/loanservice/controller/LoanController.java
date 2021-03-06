package com.ayushi.loanservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ayushi.loanservice.entity.Customer;
import com.ayushi.loanservice.entity.Loan;
import com.ayushi.loanservice.exception.DuplicateLoanRecordsFound;
import com.ayushi.loanservice.repos.CustomerRepo;
import com.ayushi.loanservice.repos.LoanRepo;

@RestController
@RequestMapping("/loanapi")
public class LoanController {

	@Autowired
	LoanRepo loanRepo;

	@Autowired
	CustomerRepo customerRepo;

	@RequestMapping(value = "/applyloan", method = RequestMethod.POST)
	public String createLoan(@RequestBody Loan loan) throws DuplicateLoanRecordsFound {
		// check if username exists
		List<Customer> customer = customerRepo.findByUsername(loan.getUsername());
		if (customer.size() == 0) {
			// user not exists
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Please enter correct details");
		} else {
			// user exists
			// check if user requested for loan application before?
			Loan loanDetails = loanRepo.findByUsername(customer.get(0).getUsername());
			if (loanDetails == null) // never applied
			{
				loan.setLoanstatus(true);
				loanRepo.save(loan);
				return "Loan applied";
			} else {
				throw new DuplicateLoanRecordsFound("Loan already applied");
			}
		}

	}

	@RequestMapping(value = "/loan/{username}", method = RequestMethod.GET)
	public Loan getLoanDetails(@PathVariable("username") String username) {
		Loan loan = loanRepo.findByUsername(username);
		if (loan == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan details not found");
		} else {
			return loan;
		}
	}
}

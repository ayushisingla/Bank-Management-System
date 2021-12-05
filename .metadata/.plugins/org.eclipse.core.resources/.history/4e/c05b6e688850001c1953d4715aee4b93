package com.ayushi.loanservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayushi.loanservice.entity.Loan;

public interface LoanRepo extends JpaRepository<Loan, Integer> {

	Loan findById(int loanid);

	Loan findByUsername(String username);

}

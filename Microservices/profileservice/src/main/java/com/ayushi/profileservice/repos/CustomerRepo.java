package com.ayushi.profileservice.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ayushi.profileservice.entity.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Long> {

	List<Customer> findByUsername(String username);

}

package com.ayushi.loanservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LoanserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanserviceApplication.class, args);
	}

}

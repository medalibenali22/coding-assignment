package com.manager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.manager.models.Customer;
import com.manager.repository.CustomerRepository;

@SpringBootApplication
public class AccountManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountManagerApplication.class, args);
	}
	
	
	@Bean
	CommandLineRunner inuitDatabaseH2(CustomerRepository customerRepository) {
		
		return args ->{
				customerRepository.save(new Customer(Long.valueOf(1),"med","ali"));
				customerRepository.save(new Customer(Long.valueOf(2),"javi","martnez"));
				customerRepository.save(new Customer(Long.valueOf(3),"consuelo","infantes"));
				};
	}

}

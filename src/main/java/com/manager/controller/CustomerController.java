package com.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.models.Customer;
import com.manager.repository.CustomerRepository;

@RestController
@RequestMapping("customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping
	public List<Customer> getAllCustomers(){
		return this.customerRepository.findAll();
	}

}

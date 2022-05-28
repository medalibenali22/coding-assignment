package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> { 

}

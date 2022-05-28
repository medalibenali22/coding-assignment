package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}

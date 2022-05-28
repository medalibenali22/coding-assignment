package com.manager.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.manager.enums.TransactionType;
import com.manager.models.Transaction;

@Service
public class TransactionService {

	public List<Transaction> createOpeningTransaction(double intialCredit) throws Exception {
		Transaction transaction = new Transaction();
		List<Transaction> transactionList = new ArrayList<>();
		
		transaction.setTransactionType(TransactionType.CREATED_ACCOUNT);
		transaction.setAmount(intialCredit);
		transaction.setTransactionDate(LocalDate.now());
		
		transactionList.add(transaction);
		
		return transactionList;
	}

}

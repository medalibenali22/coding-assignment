package com.manager.dataHelper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.manager.dto.AccountDto;
import com.manager.enums.TransactionType;
import com.manager.models.Account;
import com.manager.models.Customer;
import com.manager.models.Transaction;

public class DataHelperTest {
	
	
	
	public static AccountDto generateAccountDto() 
	{
		AccountDto dto = new AccountDto(1L, 500.00);
		
		return dto;
	}
	
	public static AccountDto generateAccountDtoNonCredit() 
	{
		AccountDto dto = new AccountDto(1L,0.00);
		
		return dto;
	}
	
	public static Account generateAccount() {
		
		Account account = new Account();
		
		account.setId(1L);
		account.setBalance(500.00);
		
		Transaction transaction = new Transaction();
		transaction.setAmount(500.00);
		transaction.setId(1L);
		transaction.setTransactionDate(LocalDate.now());
		transaction.setTransactionType(TransactionType.CREATED_ACCOUNT);
		
		List<Transaction> transactionList = new ArrayList<>();
		transactionList.add(transaction);
		account.setTransaction(transactionList);
		
		return account;
	}
	public static Account  getAccount() {
		Account account = new Account();
		account.setId(1L);
		account.setBalance(500.00);
		account.setTransaction(null);
		
		return account;
	}
	
	public static List<Transaction> generateTransactionList(Double initialCredit)
	{
		Transaction transaction = new Transaction(initialCredit,LocalDate.now(),TransactionType.CREATED_ACCOUNT);
		List<Transaction> Transactionlist = new ArrayList<>();
		
		Transactionlist.add(transaction);
		
		return Transactionlist;
		
	}
	
	public static List<Customer> generateListOfCustomers (){
		
		List<Customer> CustomerList = new ArrayList<>();
		
		Customer customerOne = new Customer(1L, "testOne", "testOne");
		Customer customerTwo = new Customer(1L, "TestTwo", "TestTwo");
		Customer customerThree = new Customer(1L, "TestThree", "TestThree");
		
		CustomerList.add(customerOne);
		CustomerList.add(customerTwo);
		CustomerList.add(customerThree);
		 return CustomerList;
		
	}
	
	public static Optional<Customer> generateOptCustomer() {
		
		Customer customer = new Customer(1L, "testOne", "testOne");
		Account account = new Account();
		account.setId(1L);
		account.setBalance(500.00);
		account.setTransaction(null);
		
		customer.setAccount(account);
		
		Optional<Customer> optCustomer = Optional.of(customer);
		
		return optCustomer;
		
	}
}

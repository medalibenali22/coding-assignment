package com.manager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.dto.AccountDto;
import com.manager.models.Account;
import com.manager.models.Customer;
import com.manager.repository.CustomerRepository;

@Service

public class AccountService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private TransactionService transactionService;

	public Account createAccount(AccountDto accountDto) throws Exception {
		Optional<Customer> customer = this.customerRepository.findById(accountDto.getCostumerId());

		if (customer.isPresent() && customer.get().getAccount() == null) {
			Account createdAccount = new Account();
			createdAccount.setBalance(accountDto.getInitialCredit());

			if (accountDto.getInitialCredit() > 0) {

				createdAccount.setTransaction(
						this.transactionService.createOpeningTransaction(accountDto.getInitialCredit()));
			}

			customer.get().setAccount(createdAccount);
			this.customerRepository.save(customer.get());

		} else if (customer.isPresent() && customer.get().getAccount() != null) {
			throw new Exception("This customer already has an account");
		}

		return customer.get().getAccount();

	}

}

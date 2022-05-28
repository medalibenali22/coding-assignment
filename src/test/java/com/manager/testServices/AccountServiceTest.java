package com.manager.testServices;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyLong;

import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.manager.dataHelper.DataHelperTest;
import com.manager.dto.AccountDto;
import com.manager.models.Account;
import com.manager.models.Customer;
import com.manager.repository.CustomerRepository;
import com.manager.services.AccountService;
import com.manager.services.TransactionService;

public class AccountServiceTest {

	@Mock
	private CustomerRepository customerRepository;
	@Mock
	private TransactionService transactionService;

	@InjectMocks
	private AccountService accountService;
	
	Customer customer;
	
	Optional<Customer> optCustomer;

	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		 customer = new Customer(1L, "test", "test");
		 optCustomer = Optional.of(customer);
		 when(customerRepository.findById(anyLong())).thenReturn(optCustomer);
	}

	@Test
	public void createAccountTest() throws Exception {

		AccountDto accountDto = DataHelperTest.generateAccountDto();
		Account account = accountService.createAccount(accountDto);

		assertNotNull(account);
		assertNotNull(account.getTransaction());
		

	}
	
	@Test
	public void custometWithNonAccountTest() throws Exception {

		
		assertTrue(optCustomer.isPresent());
		assertNull(optCustomer.get().getAccount());
		
		

	}
	
	@Test
	public void createAccountnonCreditTest() throws Exception {

		AccountDto accountDto = DataHelperTest.generateAccountDtoNonCredit();
		Account account = accountService.createAccount(accountDto);

		assertNotNull(account);
		assertNull(account.getTransaction());

	}

	@Test(expected = Exception.class)
	public void existingAccountTest() throws Exception {
	
		Account existingAccount = new Account();
		existingAccount.setBalance(500.00);
		existingAccount.setId(1L);
		
		customer.setAccount(existingAccount);
		
		Optional<Customer> optCustomer = Optional.of(customer);

		when(customerRepository.findById(anyLong())).thenReturn(optCustomer);

		AccountDto accountDto = DataHelperTest.generateAccountDto();

		accountService.createAccount(accountDto);

	}
	
	

}

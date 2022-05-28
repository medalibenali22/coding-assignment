package com.manager.testServices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.manager.dataHelper.DataHelperTest;
import com.manager.services.TransactionService;

public class TransactionServiceTest {
	
	@Mock
	private TransactionService transactionService;
	
	@Test
	public void createOpeningTransaction() throws Exception {
		
		transactionService = new TransactionService();
		assertEquals(transactionService.createOpeningTransaction(1), DataHelperTest.generateTransactionList(1.00));
		
	}
	

}

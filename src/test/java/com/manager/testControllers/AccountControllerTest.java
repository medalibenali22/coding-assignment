package com.manager.testControllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manager.controller.AccountController;
import com.manager.dataHelper.DataHelperTest;
import com.manager.dto.AccountDto;
import com.manager.repository.CustomerRepository;
import com.manager.services.AccountService;
import com.manager.services.TransactionService;

public class AccountControllerTest {

	private MockMvc mvc;

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private TransactionService transactionService;

	@Mock
	private AccountService accountService;

	@InjectMocks
	private AccountController accountController;

	@Before
	public void setUp() {

		JacksonTester.initFields(this, new ObjectMapper());
		MockitoAnnotations.openMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(accountController).build();
	}

	@Test
	public void AddAccountTest() throws Exception {

		when(customerRepository.findById(anyLong())).thenReturn(DataHelperTest.generateOptCustomer());
		when(accountService.createAccount(DataHelperTest.generateAccountDto()))
				.thenReturn(DataHelperTest.generateAccount());

		MockHttpServletResponse response = mvc.perform(post("/account/add").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(new AccountDto(1L, 500.00)))).andReturn().getResponse();

		assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

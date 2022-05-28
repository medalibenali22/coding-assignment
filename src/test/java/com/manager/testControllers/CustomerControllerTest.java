package com.manager.testControllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

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
import com.manager.controller.CustomerController;
import com.manager.dataHelper.DataHelperTest;
import com.manager.models.Customer;
import com.manager.repository.CustomerRepository;

public class CustomerControllerTest {

	private MockMvc mvc;

	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
	private CustomerController customerController;

	private JacksonTester<List<Customer>> jsonCustomer;

	@Before
	public void setUp() {

		JacksonTester.initFields(this, new ObjectMapper());
		MockitoAnnotations.openMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	@Test
	public void getAllCustomersTest() throws Exception {

		when(customerRepository.findAll()).thenReturn(DataHelperTest.generateListOfCustomers());

		// when
		MockHttpServletResponse response = mvc.perform(get("/customers").accept(MediaType.APPLICATION_JSON)).andReturn()
				.getResponse();

		// then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString())
				.isEqualTo(jsonCustomer.write(DataHelperTest.generateListOfCustomers()).getJson());

	}

}

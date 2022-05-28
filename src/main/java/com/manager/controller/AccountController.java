package com.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.dto.AccountDto;
import com.manager.services.AccountService;

@RestController
@RequestMapping("account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/add")
	public  ResponseEntity<?> addAccount (@RequestBody AccountDto accountDto) throws Exception
	{
		
		
		return new ResponseEntity<>(this.accountService.createAccount(accountDto),HttpStatus.CREATED);
	}
	
	

}

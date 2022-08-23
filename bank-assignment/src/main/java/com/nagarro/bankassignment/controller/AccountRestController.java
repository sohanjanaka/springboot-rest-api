package com.nagarro.bankassignment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.bankassignment.dto.AccountDTO;
import com.nagarro.bankassignment.exception.InvalidInputParameterException;
import com.nagarro.bankassignment.service.AccountService;
import com.nagarro.bankassignment.validation.RequestValidation;

@RestController
@RequestMapping("api/v1")
public class AccountRestController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private RequestValidation accountValidation;

	public Logger getLogger() {
		return LoggerFactory.getLogger(AccountRestController.class);
	}

	@GetMapping("/account")
	public ResponseEntity<List<AccountDTO>> getAllAccount() {
		getLogger().info("Request received to api/v1/account");
		return new ResponseEntity<>(accountService.getAccount(), HttpStatus.OK);
	}

	@GetMapping("/account/{accountNumber}")
	public ResponseEntity<AccountDTO> getAccount(@PathVariable String accountNumber)
			throws InvalidInputParameterException {
		getLogger().info("Request received to api/v1/account/{accountNumber}");
		accountValidation.isValidAccount(accountNumber);
		return new ResponseEntity<>(accountService.getAccountByAccountNumber(accountNumber), HttpStatus.OK);
	}

}

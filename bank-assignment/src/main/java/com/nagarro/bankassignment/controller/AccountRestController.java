package com.nagarro.bankassignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.bankassignment.dto.AccountDTO;
import com.nagarro.bankassignment.exception.InvalidInputParameterException;
import com.nagarro.bankassignment.service.AccountService;
import com.nagarro.bankassignment.validation.AccountValidation;

@RestController
@RequestMapping("api/v1/")
public class AccountRestController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountValidation accountValidation;

	@GetMapping("account/")
	public List<AccountDTO> getAllAccount() {
		return accountService.getAccount();
	}

	@GetMapping("account/{accountNumber}")
	public AccountDTO getAccount(@PathVariable String accountNumber) throws InvalidInputParameterException {
		accountValidation.isValidAccount(accountNumber);
		return accountService.getAccountByAccountNumber(accountNumber);
	}

}

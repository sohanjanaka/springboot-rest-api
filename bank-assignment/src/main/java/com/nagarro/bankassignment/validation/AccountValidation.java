package com.nagarro.bankassignment.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.bankassignment.entity.Account;
import com.nagarro.bankassignment.exception.InvalidInputParameterException;
import com.nagarro.bankassignment.repository.AccountRepository;

@Service
public class AccountValidation {

	@Autowired
	private AccountRepository accountRepository;

	public Account isValidAccount(String accountNumber) throws InvalidInputParameterException {
		Account account = accountRepository.findByAccountNumber(accountNumber);
		if (account == null) {
			throw new InvalidInputParameterException("Invalid Account number");
		} else {
			return account;
		}

	}
}

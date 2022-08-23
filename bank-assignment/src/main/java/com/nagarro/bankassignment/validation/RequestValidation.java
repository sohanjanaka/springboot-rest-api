package com.nagarro.bankassignment.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.bankassignment.entity.Account;
import com.nagarro.bankassignment.exception.InvalidInputParameterException;
import com.nagarro.bankassignment.model.StatementRequest;
import com.nagarro.bankassignment.repository.AccountRepository;

@Service
public class RequestValidation {

	@Autowired
	private AccountRepository accountRepository;

	public void requestValidation(StatementRequest statementRequest) throws InvalidInputParameterException {
		if (statementRequest.getMinimumAmount() > statementRequest.getMaximumAmount()) {
			throw new InvalidInputParameterException("Minimum amaount is grater than Maximun amount");
		}

		if (statementRequest.getStartDate().compareTo(statementRequest.getEndDate()) > 0) {
			throw new InvalidInputParameterException("startDate is grater than endDate");
		}
	}

	public Account isValidAccount(String accountNumber) throws InvalidInputParameterException {
		Account account = accountRepository.findByAccountNumber(accountNumber);
		if (account == null) {
			throw new InvalidInputParameterException("Invalid Account number");
		} else {
			return account;
		}

	}
}

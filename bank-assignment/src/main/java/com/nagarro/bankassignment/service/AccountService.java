package com.nagarro.bankassignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.bankassignment.dto.AccountDTO;
import com.nagarro.bankassignment.entity.Account;
import com.nagarro.bankassignment.repository.AccountRepository;
import com.nagarro.bankassignment.utils.AccountConvert;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public List<AccountDTO> getAccount(){
		Iterable<Account> accounts = accountRepository.findAll();
		List<AccountDTO> accountDTO = AccountConvert.EntitytoDTO(accounts);
		return  accountDTO;
	}
	
	public AccountDTO getAccountByAccountNumber(String accountNumber){
		Account accounts = accountRepository.findByAccountNumber(accountNumber);
		AccountDTO accountDTO = AccountConvert.EntitytoDTO(accounts);
		return  accountDTO;
	}

}

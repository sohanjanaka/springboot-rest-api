package com.nagarro.bankassignment.utils;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.bankassignment.dto.AccountDTO;
import com.nagarro.bankassignment.entity.Account;

public class AccountConvert {

	public static List<AccountDTO> EntitytoDTO(Iterable<Account> accounts) {
		List<AccountDTO> acountDTOs = new ArrayList<>();
		accounts.forEach((account) -> {
			acountDTOs.add(EntitytoDTO(account));
		});
		return acountDTOs;
	}

	public static AccountDTO EntitytoDTO(Account account) {
		return new AccountDTO(account.getAccountType(), account.getAccountNumber());
	}

}

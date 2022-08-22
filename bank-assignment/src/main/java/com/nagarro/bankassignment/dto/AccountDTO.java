package com.nagarro.bankassignment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {

	public AccountDTO(String accountType, String accountNumber) {
		this.accountType = accountType;
		this.accountNumber = accountNumber;
	}

	String accountType;
	String accountNumber;

}

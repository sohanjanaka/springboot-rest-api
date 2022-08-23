package com.nagarro.bankassignment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {

	private String accountType;
	private String accountNumber;

	public AccountDTO(String accountType, String accountNumber) {
		this.accountType = accountType;
		this.accountNumber = accountNumber;
	}

}

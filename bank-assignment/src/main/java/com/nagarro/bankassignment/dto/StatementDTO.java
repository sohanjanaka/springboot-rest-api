package com.nagarro.bankassignment.dto;

import java.time.LocalDate;

import com.nagarro.bankassignment.utils.StatementConvert;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatementDTO {

	private LocalDate dateField;
	private double amount;
	private String accountNumber;

	public StatementDTO(String dateField, String amount, AccountDTO account) {
		this.dateField = StatementConvert.textdateFieldToLocalDate(dateField);
		this.amount = Double.parseDouble(amount);
		this.accountNumber = account.getAccountNumber();
	}

}

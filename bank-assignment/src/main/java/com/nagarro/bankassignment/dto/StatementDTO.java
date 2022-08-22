package com.nagarro.bankassignment.dto;

import java.time.LocalDate;

import com.nagarro.bankassignment.utils.StatementConvert;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatementDTO {

	LocalDate dateField;
	double amount;
	AccountDTO account;

	public StatementDTO(String dateField, String amount, AccountDTO account) {
		try {
			this.dateField = StatementConvert.textdateFieldToLocalDate(dateField);
			this.amount = Double.parseDouble(amount);
			this.account = account;
		} catch (Exception e) {
			System.err.println("conversion error");
		}
	}

}

package com.nagarro.bankassignment.validation;

import java.time.LocalDate;

import com.nagarro.bankassignment.dto.StatementDTO;
import com.nagarro.bankassignment.model.StatementRequest;

public class StatementValidation {

	private StatementValidation() {

	}

	public static Boolean filterByAmountDate(StatementDTO statementDTO, StatementRequest statementRequestDTO) {

		Double amount = statementDTO.getAmount();
		LocalDate date = statementDTO.getDateField();
		LocalDate startDate = statementRequestDTO.getStartDate();
		LocalDate endDate = statementRequestDTO.getEndDate();
		Double min = statementRequestDTO.getMinimumAmount();
		Double max = statementRequestDTO.getMaximumAmount();

		return (filterByAmount(amount, min, max) && filterByDate(date, startDate, endDate));

	}

	public static Boolean filterByAmount(Double amount, Double min, Double max) {
		return (amount >= min && amount <= max);
	}

	public static Boolean filterByDate(LocalDate date, LocalDate startDate, LocalDate endDate) {
		return (date.compareTo(startDate) > 0 && date.compareTo(endDate) < 0);
	}

}

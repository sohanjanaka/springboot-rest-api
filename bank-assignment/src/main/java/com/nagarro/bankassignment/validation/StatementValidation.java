package com.nagarro.bankassignment.validation;

import java.time.LocalDate;

import com.nagarro.bankassignment.dto.StatementDTO;
import com.nagarro.bankassignment.dto.StatementRequestDTO;

public class StatementValidation {

	public static Boolean filterByAmountDate(StatementDTO statementDTO, StatementRequestDTO statementRequestDTO) {

		Double amount = statementDTO.getAmount();
		LocalDate date = statementDTO.getDateField();
		LocalDate startDate = statementRequestDTO.getStartDate();
		LocalDate endDate = statementRequestDTO.getEndDate();
		Double min = statementRequestDTO.getMinimumAmount();
		Double max = statementRequestDTO.getMaximumAmount();

		if (filterByAmount(amount, min, max) && filterByDate(date, startDate, endDate)) {
			return true;
		} else {
			return false;
		}

	}

	public static Boolean filterByAmount(Double amount, Double min, Double max) {
		if (amount >= min && amount <= max) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean filterByDate(LocalDate date, LocalDate startDate, LocalDate endDate) {
		if (date.compareTo(startDate) > 0 && date.compareTo(endDate) < 0) {
			return true;
		} else {
			return false;
		}
	}

}

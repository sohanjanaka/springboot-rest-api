package com.nagarro.bankassignment.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.bankassignment.dto.StatementDTO;
import com.nagarro.bankassignment.entity.Statement;

public class StatementConvert {

	private StatementConvert() {

	}

	public static List<StatementDTO> entitytoDTO(Iterable<Statement> statements) {
		List<StatementDTO> statementDTOs = new ArrayList<>();
		statements.forEach(statement -> statementDTOs.add(entitytoDTO(statement)));
		return statementDTOs;
	}

	public static StatementDTO entitytoDTO(Statement statement) {
		return new StatementDTO(statement.getDateField(), statement.getAmount(),
				AccountConvert.entitytoDTO(statement.getAccount()));
	}

	public static LocalDate textdateFieldToLocalDate(String datefield) throws NumberFormatException {

		String[] date = datefield.split("\\.");

		int day = Integer.parseInt(date[2]);
		int month = Integer.parseInt(date[1]);
		int year = Integer.parseInt(date[0]);

		return LocalDate.of(day, month, year);
	}

}

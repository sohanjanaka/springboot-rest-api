package com.nagarro.bankassignment.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.bankassignment.dto.StatementDTO;
import com.nagarro.bankassignment.entity.Statement;

public class StatementConvert {

	public static List<StatementDTO> EntitytoDTO(Iterable<Statement> statements) {
		List<StatementDTO> statementDTOs = new ArrayList<>();
		statements.forEach((statement) -> {
			statementDTOs.add(EntitytoDTO(statement));
		});
		return statementDTOs;
	}

	public static StatementDTO EntitytoDTO(Statement statement) {
		return new StatementDTO(statement.getDateField(), statement.getAmount(), AccountConvert.EntitytoDTO(statement.getAccount()));
	}

	public static LocalDate textdateFieldToLocalDate(String datefield) throws NumberFormatException{

		String[] date = datefield.split("\\.");

		int day = Integer.parseInt(date[2]);
		int month = Integer.parseInt(date[1]);
		int year = Integer.parseInt(date[0]);

		return LocalDate.of(day, month, year);
	}

}

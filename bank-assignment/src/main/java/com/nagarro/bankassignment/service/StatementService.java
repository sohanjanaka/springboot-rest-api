package com.nagarro.bankassignment.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.bankassignment.dto.StatementDTO;
import com.nagarro.bankassignment.dto.StatementRequestDTO;
import com.nagarro.bankassignment.entity.Statement;
import com.nagarro.bankassignment.repository.StatementRepository;
import com.nagarro.bankassignment.utils.StatementConvert;
import com.nagarro.bankassignment.validation.StatementValidation;

@Service
public class StatementService {

	@Autowired
	StatementRepository statementRepository;

	public List<StatementDTO> getStatementByAccountAccountNumber(String accountNumber) {
		Iterable<Statement> statement = statementRepository.findByAccountAccountNumber(accountNumber);
		return StatementConvert.entitytoDTO(statement);
	}

	public List<StatementDTO> getStatement3months(String accountNumber) {
		LocalDate date3monthsback = LocalDate.now().minusMonths(3);
		List<StatementDTO> filterStatementDTOs = new ArrayList<>();
		List<StatementDTO> statementDTOs = getStatementByAccountAccountNumber(accountNumber);
		statementDTOs.forEach(statementDTO -> {
			if (statementDTO.getDateField().compareTo(date3monthsback) > 0) {
				filterStatementDTOs.add(statementDTO);
			}
		});
		return filterStatementDTOs;
	}

	public List<StatementDTO> getStatementByDateAmount(String accountNumber, StatementRequestDTO statementRequestDTO) {
		List<StatementDTO> filterStatementDTOs = new ArrayList<>();
		List<StatementDTO> statementDTOs = getStatementByAccountAccountNumber(accountNumber);
		statementDTOs.forEach(statementDTO -> {
			if (StatementValidation.filterByAmountDate(statementDTO, statementRequestDTO)) {
				filterStatementDTOs.add(statementDTO);
			}
		});
		return filterStatementDTOs;
	}

}

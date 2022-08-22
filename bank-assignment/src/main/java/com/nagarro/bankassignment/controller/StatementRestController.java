package com.nagarro.bankassignment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.bankassignment.dto.StatementDTO;
import com.nagarro.bankassignment.dto.StatementRequestDTO;
import com.nagarro.bankassignment.exception.InvalidInputParameterException;
import com.nagarro.bankassignment.service.StatementService;
import com.nagarro.bankassignment.validation.AccountValidation;

@RestController
@RequestMapping("api/v1/")
public class StatementRestController {

	@Autowired
	StatementService StatementService;

	@Autowired
	AccountValidation accountValidation;

	@GetMapping("statement/{accountNumber}")
	public ResponseEntity<List<StatementDTO>> getStatement(@PathVariable String accountNumber)
			throws InvalidInputParameterException {
		accountValidation.isValidAccount(accountNumber);
		List<StatementDTO> responce = StatementService.getStatement3months(accountNumber);
		return new ResponseEntity<>(responce, HttpStatus.OK);
	}

	@GetMapping("advenceStatement/{accountNumber}")
	public ResponseEntity<List<StatementDTO>> getStatement(@PathVariable String accountNumber,
			@RequestBody @Valid StatementRequestDTO statementRequest) throws InvalidInputParameterException {
		accountValidation.isValidAccount(accountNumber);
		List<StatementDTO> responce = StatementService.getStatementByDateAmount(accountNumber, statementRequest);
		return new ResponseEntity<>(responce, HttpStatus.OK);
	}

}

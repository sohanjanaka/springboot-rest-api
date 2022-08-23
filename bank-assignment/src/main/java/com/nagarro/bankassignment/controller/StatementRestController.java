package com.nagarro.bankassignment.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.bankassignment.dto.StatementDTO;
import com.nagarro.bankassignment.exception.InvalidInputParameterException;
import com.nagarro.bankassignment.model.StatementRequest;
import com.nagarro.bankassignment.service.StatementService;
import com.nagarro.bankassignment.validation.RequestValidation;

@RestController
@RequestMapping("api/v1")
public class StatementRestController {

	@Autowired
	private StatementService statementService;

	@Autowired
	private RequestValidation accountValidation;

	public Logger getLogger() {
		return LoggerFactory.getLogger(StatementRestController.class);
	}

	@GetMapping("/statement/{accountNumber}")
	public ResponseEntity<List<StatementDTO>> getStatement(@PathVariable String accountNumber)
			throws InvalidInputParameterException {
		getLogger().info("Request received to api/v1/statement/{accountNumber}");
		accountValidation.isValidAccount(accountNumber);
		List<StatementDTO> response = statementService.getStatement3months(accountNumber);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/advenceStatement/{accountNumber}")
	public ResponseEntity<List<StatementDTO>> getStatement(@PathVariable String accountNumber,
			@RequestBody @Valid StatementRequest statementRequest) throws InvalidInputParameterException {
		getLogger().info("Request received to api/v1/advenceStatement/{accountNumber}");
		accountValidation.isValidAccount(accountNumber);
		accountValidation.requestValidation(statementRequest);
		List<StatementDTO> response = statementService.getStatementByDateAmount(accountNumber, statementRequest);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}

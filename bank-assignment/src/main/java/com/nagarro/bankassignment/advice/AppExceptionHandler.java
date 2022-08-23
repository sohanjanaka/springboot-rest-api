package com.nagarro.bankassignment.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.nagarro.bankassignment.exception.InvalidInputParameterException;

@RestControllerAdvice
public class AppExceptionHandler {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
		return errorMap;
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidFormatException.class)
	public Map<String, String> invalidFormatException(InvalidFormatException ex) {
		Map<String, String> errorMap = new HashMap<>();

		if (ex.getCause() != null) {
			errorMap.put(ex.getPath().get(0).getFieldName(), ex.getCause().getMessage());
		} else {
			errorMap.put(ex.getPath().get(0).getFieldName(), ex.getValue() + " is invalid please check the value");
		}

		return errorMap;
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidInputParameterException.class)
	public Map<String, String> invalidInputParameterException(InvalidInputParameterException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("Account number", "Invalid Account number please check the account number");
		return errorMap;
	}

}

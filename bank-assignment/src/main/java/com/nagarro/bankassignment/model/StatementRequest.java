package com.nagarro.bankassignment.model;

import java.time.LocalDate;

import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatementRequest {

	private LocalDate startDate;
	private LocalDate endDate;
	@Min(value = 0, message = "Please enter valid value for minimumAmount")
	private Double minimumAmount;
	@Min(value = 0, message = "Please enter valid value for maximumAmount")
	private Double maximumAmount;

}

package com.nagarro.bankassignment.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatementRequestDTO {

	LocalDate startDate;
	LocalDate endDate;
	@Min(value = 0, message = "Please enter valid value for minimumAmount")
	Double minimumAmount;
	@Min(value = 0, message = "Please enter valid value for maximumAmount")
	Double maximumAmount;

}

package com.nagarro.bankassignment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.nagarro.bankassignment.entity.Statement;

public interface StatementRepository extends CrudRepository<Statement, Integer> {
	
	List<Statement> findByAccountAccountNumber(String accountNumber);

}

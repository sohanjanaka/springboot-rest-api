package com.nagarro.bankassignment.repository;

import org.springframework.data.repository.CrudRepository;
import com.nagarro.bankassignment.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {

	Account findByAccountNumber(String accountNumber);

}

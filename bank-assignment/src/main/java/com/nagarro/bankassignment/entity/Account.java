package com.nagarro.bankassignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	int id;

	@Column(name = "account_type")
	String accountType;

	@Column(name = "account_number", unique = true)
	String accountNumber;

}

package com.nagarro.bankassignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "statement")
public class Statement {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "account_id")
	private Account account;

	@Column(name = "datefield")
	private String dateField;

	@Column(name = "amount")
	private String amount;

}

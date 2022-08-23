package com.nagarro.bankassignment.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthendicationResponse implements Serializable {

	private String jwt;

	public AuthendicationResponse(String jwt) {
		this.jwt = jwt;
	}

}

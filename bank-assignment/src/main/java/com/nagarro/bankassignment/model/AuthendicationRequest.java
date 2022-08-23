package com.nagarro.bankassignment.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthendicationRequest {

	public AuthendicationRequest() {

	}

	public AuthendicationRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	private String username;
	private String password;

}

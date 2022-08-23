package com.nagarro.bankassignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.bankassignment.model.AuthendicationRequest;
import com.nagarro.bankassignment.model.AuthendicationResponse;
import com.nagarro.bankassignment.service.MyUserDetailsService;
import com.nagarro.bankassignment.utils.JwtUtil;

@RestController
public class JWTAuthRestController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<AuthendicationResponse> createAuthToken(
			@RequestBody AuthendicationRequest authendicationRequest) throws BadCredentialsException {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authendicationRequest.getUsername(),
				authendicationRequest.getPassword()));

		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authendicationRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);

		return new ResponseEntity<>(new AuthendicationResponse(jwt), HttpStatus.OK);

	}

}

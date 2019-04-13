package com.service.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountService {
	
	@Autowired
	private ServerProperties serverProperties;
	
	@GetMapping("/getaccnum")
	public String getAccountNumber() {
		return "1234567890 from "+serverProperties.getPort();
	}

}

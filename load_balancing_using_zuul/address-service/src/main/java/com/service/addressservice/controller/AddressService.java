package com.service.addressservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressService {
	
	@Autowired
	private ServerProperties serverProperties;
	
	@Autowired
	private org.springframework.core.env.Environment springEnv;
	
	@GetMapping("/getaddress")
	public String getAddress() {
		return "402 ARR Residency from "+springEnv.getProperty("server.port");
	}

}

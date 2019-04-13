package com.sample;

import org.springframework.stereotype.Component;

@Component("current")
public class CurrentAccount implements IAccount {

private String accountType;

	
	public CurrentAccount() {
		super();
		this.accountType="Current";
	}

	public String getType() {
		return this.accountType;
	}

	public void setType(String accType) {
		this.accountType=accType;
		
	}

}

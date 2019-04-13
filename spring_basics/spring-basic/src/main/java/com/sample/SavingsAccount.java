package com.sample;

import org.springframework.stereotype.Component;

@Component("saving")
public class SavingsAccount implements IAccount {

	private String accountType;

	
	public SavingsAccount() {
		super();
		this.accountType="Savings";
	}

	public String getType() {
		return this.accountType;
	}

	public void setType(String accType) {
		this.accountType=accType;
		
	}

}

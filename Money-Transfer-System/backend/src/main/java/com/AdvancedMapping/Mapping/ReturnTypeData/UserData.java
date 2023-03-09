package com.AdvancedMapping.Mapping.ReturnTypeData;

import java.math.BigDecimal;

import javax.persistence.Column;

public class UserData {
	
	private String name;
	private String accountNumber;
	private BigDecimal balance;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public UserData(String name, String accountNumber, BigDecimal balance) {
		super();
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}

package com.AdvancedMapping.Mapping.ReturnTypeData;

public class PayeeData {

	private String name;
	private String accountNumber;
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
	public PayeeData(String name, String accountNumber) {
		super();
		this.name = name;
		this.accountNumber = accountNumber;
	}
	public PayeeData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}

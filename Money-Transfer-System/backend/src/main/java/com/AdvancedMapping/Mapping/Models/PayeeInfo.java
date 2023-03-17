package com.AdvancedMapping.Mapping.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Payee")
public class PayeeInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="AccountNumber")
	@Pattern(regexp="[0-9]{12}", message="AccountNumber should contain only 12 digit number")
	private String accountNumber;
	
	@Column(name="Name")
	@NotEmpty(message="Please provide Payee Name")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PayeeInfo(String accountNumber, String name) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
	}

	public PayeeInfo(int id, String accountNumber, String name) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.name = name;
	}

	public PayeeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

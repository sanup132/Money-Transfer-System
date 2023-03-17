package com.AdvancedMapping.Mapping.ReturnTypeData;

import java.math.BigDecimal;

import javax.persistence.Column;

public class TransactionData {
	
	private BigDecimal amount;
	private String transactionType;
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public TransactionData(BigDecimal amount, String transactionType) {
		super();
		this.amount = amount;
		this.transactionType = transactionType;
	}
	public TransactionData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

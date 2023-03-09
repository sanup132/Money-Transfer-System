package com.AdvancedMapping.Mapping.ReturnTypeData;

import java.math.BigDecimal;

public class TransferAmountData {
	
	private String payeeName;
	private String payeeAccountNumber;
	private BigDecimal amount;
	
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getPayeeAccountNumber() {
		return payeeAccountNumber;
	}
	public void setPayeeAccountNumber(String payeeAccountNumber) {
		this.payeeAccountNumber = payeeAccountNumber;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public TransferAmountData(String payeeName, String payeeAccountNumber, BigDecimal amount) {
		super();
		this.payeeName = payeeName;
		this.payeeAccountNumber = payeeAccountNumber;
		this.amount = amount;
	}
	public TransferAmountData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

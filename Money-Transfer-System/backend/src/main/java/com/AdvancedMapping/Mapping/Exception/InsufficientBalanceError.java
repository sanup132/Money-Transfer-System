package com.AdvancedMapping.Mapping.Exception;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InsufficientBalanceError {
	
	private LocalDate date;
	private String msg;
	private BigDecimal currentBalance;
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}
	public InsufficientBalanceError(LocalDate date, String msg, BigDecimal currentBalance) {
		super();
		this.date = date;
		this.msg = msg;
		this.currentBalance = currentBalance;
	}
	public InsufficientBalanceError() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

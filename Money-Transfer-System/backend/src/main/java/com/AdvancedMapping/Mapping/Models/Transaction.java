package com.AdvancedMapping.Mapping.Models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Entity
@Table(name="Transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Date")
	@PastOrPresent(message = "Transaction date can not be a future date")
	private LocalDate date;
	
	@Column(name="Amount")
	@Positive(message="Transcation Amount can not be Negative")
	private BigDecimal amount;
	
	@Column(name="TransactionType")
//	@Pattern(regexp="[c|d]", message="") ToDO define the transaction type
	private String transactionType;
		
	@Column(name="Remarks")
	private String remarks;
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



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



	public String getRemarks() {
		return remarks;
	}



	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Transaction(BigDecimal amount, String transactionType, String remarks) {
		super();
		this.amount = amount;
		this.transactionType = transactionType;
		this.remarks = remarks;
		this.date=LocalDate.now();
	}



	public Transaction(BigDecimal amount, String transactionType) {
		super();
		this.amount = amount;
		this.transactionType = transactionType;
		this.date=LocalDate.now();
	// TODO what should be the default value
		this.remarks="default remarks";
	}
	
	

}

package com.AdvancedMapping.Mapping.Models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;


@Entity
@Table(name="UserAccount")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotEmpty(message="Please provide User Name")
	@Column(name="UserName")
	private String name;
	
	@NotNull
	@NotEmpty(message= "Please provide User ID")
	@Column(name="UserId")
	private String userId;

	@NotNull
	@NotEmpty(message= "Please provide Password")
	@Column(name="Password")
	private String password;
	
	@NotNull
	@Pattern(regexp="[0-9]{12}", message="AccountNumber should contain only 12 digit number")
	@Column(name="AccountNumber")
	private String accountNumber;
	
	
	@Column(name="AccountBalance")
	@Range(min=10000)	
	private BigDecimal balance;
	
	
	@OneToMany
	private List<PayeeInfo> payeeList= new ArrayList<>();
	
	@OneToMany(fetch=FetchType.LAZY)
	private List<Transaction> transactionList= new ArrayList<>();
	
	
	
	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

	public List<PayeeInfo> getPayeeList() {
		return payeeList;
	}

	public void setPayeeList(List<PayeeInfo> payeeList) {
		this.payeeList = payeeList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public User(int id, String name, String userId, String accountNumber, String password, BigDecimal balance) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
		this.accountNumber = accountNumber;
		this.password = password;
		this.balance = balance;
	}

	public User(String name, String userId, String accountNumber, String password, BigDecimal balance) {
		super();
		this.name = name;
		this.userId = userId;
		this.accountNumber = accountNumber;
		this.password = password;
		this.balance = balance;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
}

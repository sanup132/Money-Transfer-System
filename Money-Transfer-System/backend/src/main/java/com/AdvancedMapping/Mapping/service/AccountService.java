package com.AdvancedMapping.Mapping.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AdvancedMapping.Mapping.Models.PayeeInfo;
import com.AdvancedMapping.Mapping.Models.Transaction;
import com.AdvancedMapping.Mapping.Models.User;
import com.AdvancedMapping.Mapping.Repository.PayeeRepo;
import com.AdvancedMapping.Mapping.Repository.TransactionRepo;
import com.AdvancedMapping.Mapping.Repository.UserRepo;

@Service
@Transactional
public class AccountService {
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private PayeeRepo payeeRepo;
	
	@Autowired
	private TransactionRepo transactionRepo;
/*	
	
	public User getPayee(String userid, PayeeInfo payee) {
		// validate payee info is there
		String payeeAccountNumber=payee.getAccountNumber();
		
		User userPayee=repo.getUserAccountNumber(payeeAccountNumber);
		if(userPayee==null) {
			// throw exception
		}
		payeeRepo.addPayee(payee);
		
		// get user info
		User user= repo.getUser(userid);
		
		
		// save payee in payee table
	    
		// save user update info
		
		return repo.addPayee(user, payee);
		
	}
	
	public User addTransaction(String userId, Transaction transaction) {
		// get user
		User user=repo.getUser(userId);
		BigDecimal currentBalance=user.getBalance();
		// set the current balance, remarks accordingly
		BigDecimal debit=transaction.getDebitAmount();
		BigDecimal creadit=transaction.getCreaditAmount();
		BigDecimal finalAmount=currentBalance.add(creadit);
		finalAmount=finalAmount.subtract(debit);
		transaction.setCurrentBalance(finalAmount);
		
		// save the transaction
		transactionRepo.addTransaction(transaction);		
		//save the user
		user.setBalance(finalAmount);
		
	return repo.addTransaction(user, transaction);
	}
	
	
	public List<Transaction> getTransaction() {
		return transactionRepo.getTransaction();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public User getUser(String userId) {
		return repo.getUser(userId);
	}
	
	public String updateBalance(String userId, BigDecimal amount, String type) {
		String value="";
		if(type.equalsIgnoreCase("c"))
		 value=repo.creaditBalance(userId, amount);
		else {
			value=repo.debitBalance(userId, amount);
		}
		return value;
	}
	
	
	public String createUser(User info) {
		return repo.createUser(info);
	}
	
	*/

}

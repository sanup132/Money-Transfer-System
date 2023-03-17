package com.AdvancedMapping.Mapping.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AdvancedMapping.Mapping.Exception.InsufficientBalance;
import com.AdvancedMapping.Mapping.Exception.NoUserFoundException;
import com.AdvancedMapping.Mapping.Models.PayeeInfo;
import com.AdvancedMapping.Mapping.Models.Transaction;
import com.AdvancedMapping.Mapping.Models.User;
import com.AdvancedMapping.Mapping.Repository.PayeeRepo;
import com.AdvancedMapping.Mapping.Repository.TransactionRepo;
import com.AdvancedMapping.Mapping.Repository.UserRepo;
import com.AdvancedMapping.Mapping.ReturnTypeData.PayeeData;
import com.AdvancedMapping.Mapping.ReturnTypeData.TransactionData;
import com.AdvancedMapping.Mapping.ReturnTypeData.TransferAmountData;
import com.AdvancedMapping.Mapping.ReturnTypeData.UserData;
import com.AdvancedMapping.Mapping.ReturnTypeData.UserWithPayee;

@Service
@Transactional(rollbackOn= SQLException.class)
public class UserAccountService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PayeeRepo payeeRepo;
		
	@Autowired
	private TransactionRepo transactionRepo;
	
	@Autowired
	private DataConversion dataConversion;

	
//Method to get the user account information 
// Data Conversion is used to send the required data, it can be removed if suggested
	public UserData getUserAccountInfo(String userId) {
		User user= userRepo.getUser(userId);
		return dataConversion.getUserData(user);
	}
	
	
// Method to add Beneficiary
	
	public UserWithPayee addPayee(PayeeInfo payeeInfo, String userId)  {	
		Optional<User> user=Optional.ofNullable(validatePayee(payeeInfo));
		if(user.isEmpty()) {
			throw new NoUserFoundException("Payee Name is not matching for the given account number");
		}
		
			payeeRepo.addPayee(payeeInfo);		
			User userInfo= userRepo.getUser(userId);		
			User userPayee=userRepo.addPayee(userInfo, payeeInfo);			
			return dataConversion.getUserWithPayee(userPayee);
		
	
	}

	
	
// Method to get the payee for a user using userId
	
	public List<PayeeData> getPayeeforUser(String userId) {
		User user=userRepo.getUser(userId);	
		if(user.getPayeeList().size()==0) {
			throw new NoUserFoundException("Given User don't have any Payee Linked");
		}
		return dataConversion.getPayeeForUser(user);
		
	}
		
	
//Method to perform transaction 
	public User debitBalance(String userId, BigDecimal amount, PayeeInfo payeeInfo) {	
	// Validating if the given Payee is in Payee Table and account Number and Name are correct or Not	
		User payee=validatePayee(payeeInfo);
	
	// Getting User Account info
		User useraccount=userRepo.getUser(userId);	
	
	// Validating if given payee is linked with given user	
		Boolean validationResult=validatePayee(payeeInfo, useraccount);
		if(!validationResult) {
			throw new NoUserFoundException("Given Payee Is Not Added for this user");
		}
		
	// Checking current balance and testing it 
		BigDecimal currentBalance=useraccount.getBalance();
		if(currentBalance.compareTo(amount)<0) {
			throw new InsufficientBalance("Insufficient Balance");
		}
		
		useraccount.setBalance(currentBalance.subtract(amount));
		Transaction userTransaction=updateTransaction(useraccount,amount,false);
		useraccount.getTransactionList().add(userTransaction);
		userRepo.createUser(useraccount);		
		
		payee.setBalance(payee.getBalance().add(amount));
		Transaction payeeTransaction=updateTransaction(payee,amount,true);
		payee.getTransactionList().add(payeeTransaction);
		userRepo.createUser(payee);		
		// Update the transaction
		return userRepo.getUser(userId);
	}
	
// Second Method to Make transfer	
	public User transferAmount(TransferAmountData amountData, String userId) {
		PayeeInfo payee=payeeRepo.getPayee(amountData.getPayeeAccountNumber());
		return debitBalance(userId, amountData.getAmount(), payee);		
	}
	
		
	
	
	// Method to get the transaction 
	
	public void getTransaction(String userId) {
		
	}
	
	
// Validate User	
	private User validatePayee(PayeeInfo payeeInfo) {
		String accountNumber=payeeInfo.getAccountNumber();
		User user =  userRepo.getUserAccountNumber(accountNumber);
		if(user.getName().equals(payeeInfo.getName())){
					return user;
		}
		return null;		
	}
	
	
	private boolean validatePayee(PayeeInfo payeeInfo, User user) {
		List<PayeeInfo> payeeInfoList= user.getPayeeList();
		for(PayeeInfo payee:payeeInfoList) {
				if(payeeInfo.getAccountNumber().equals(payee.getAccountNumber()) && payeeInfo.getName().equals(payee.getName())) {
					return true;
				}
		}
		return false;
	}
	
// Update the transaction 
	private Transaction updateTransaction(User user, BigDecimal amount, Boolean creadit) {
		BigDecimal transferAmount=amount;
		String transactionType="";
		BigDecimal current=user.getBalance();
		if(creadit)
		{
			transactionType="CREADIT";
		}else {
			transactionType="DEBIT";
		}
		Transaction transaction=new Transaction(amount,transactionType);
		transactionRepo.addTransaction(transaction);
		return transaction;
	}
	
	
	public List<TransactionData> getTransactionforUsers(String userId) {
		User user= userRepo.getUser(userId);
		
		return dataConversion.getTransactionforUsers(user);
	}


    public String addUser(User user) {
		User newUser = new User();
		newUser.setName(user.getName());
		newUser.setUserId(user.getUserId());
		newUser.setAccountNumber(user.getAccountNumber());
		newUser.setPassword(user.getPassword());
		newUser.setBalance(user.getBalance());
		userRepo.createUser(newUser);

		return "User created successfully";
    }
}

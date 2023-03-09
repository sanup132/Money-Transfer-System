package com.AdvancedMapping.Mapping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.AdvancedMapping.Mapping.Models.PayeeInfo;
import com.AdvancedMapping.Mapping.Models.Transaction;
import com.AdvancedMapping.Mapping.Models.User;
import com.AdvancedMapping.Mapping.ReturnTypeData.PayeeData;
import com.AdvancedMapping.Mapping.ReturnTypeData.TransactionData;
import com.AdvancedMapping.Mapping.ReturnTypeData.TransferAmountData;
import com.AdvancedMapping.Mapping.ReturnTypeData.UserData;
import com.AdvancedMapping.Mapping.ReturnTypeData.UserWithPayee;

@Service
public class DataConversion {


	
	public UserData getUserData(User user) {
	//String name, String userId, String accountNumber, BigDecimal balance	
		UserData userData= new UserData(
				user.getName(), 
				user.getAccountNumber(), 
				user.getBalance());
		
		return userData;
	}

	public UserWithPayee getUserWithPayee(User user) {
		
		List<PayeeInfo> list= user.getPayeeList();
		List<PayeeData> payeeList= new ArrayList<>();
		for(PayeeInfo payee: list) {
			PayeeData data= new PayeeData(payee.getName(), payee.getAccountNumber());
			payeeList.add(data);
		}	
		UserWithPayee userPayee= new UserWithPayee(user.getName(), payeeList);		
		return userPayee;
	}
	
	public List<PayeeData> getPayeeForUser(User user) {
		
		List<PayeeInfo> list= user.getPayeeList();
		List<PayeeData> payeeList= new ArrayList<>();
		for(PayeeInfo payee: list) {
			PayeeData data= new PayeeData(payee.getName(), payee.getAccountNumber());
			payeeList.add(data);
		}		
		return payeeList;
	}
	
	
	public PayeeInfo getPayeeInfoFromTransferClass(TransferAmountData amountData) {
		PayeeInfo payee= new PayeeInfo(amountData.getPayeeAccountNumber(), amountData.getPayeeName());
		return payee;
	}
	
	
	
	
	
	
	
	public List<TransactionData> getTransactionforUsers(User user) {
		List<Transaction> list=user.getTransactionList();
		List<TransactionData> transactionList= new ArrayList<>();
		for(Transaction trans: list) {
			TransactionData data= 
					new TransactionData(trans.getAmount(), trans.getTransactionType());
			transactionList.add(data);
		}	
		
		return transactionList;
	}
	
	
	
}

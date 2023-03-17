package com.AdvancedMapping.Mapping.Repository;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.AdvancedMapping.Mapping.Exception.NoUserFoundException;
import com.AdvancedMapping.Mapping.Models.PayeeInfo;
import com.AdvancedMapping.Mapping.Models.Transaction;
import com.AdvancedMapping.Mapping.Models.User;

@Repository
public class UserRepo {
	
	@Autowired
	private EntityManager entity;
	
// METHOD TO ADD USER IN DB
	public String createUser(User info) {
		Session session=entity.unwrap(Session.class);
		session.saveOrUpdate(info);
		session.flush();		
		return info.getUserId()+" account is successfully created";
	}
	
// METHOD TO ADD PAYEE IN A PERTICULAR USER
	
	public User addPayee(User user, PayeeInfo payee) {
		user.getPayeeList().add(payee);
		Session session=entity.unwrap(Session.class);
		session.saveOrUpdate(user);	
		session.flush();
		session.close();
		return user;
	}
	
// METHOD OT DELETE PAYEE
	public void deletePayee(String userId, String accountNumber) {
		// to do post data addition
	}
	
// METHOD TO GET PAYEE FOR A USER USING PAYEE ACCOUNT NUMBER
	public void getPayeeOfaUser(String userId, String accountNumber) {
		//todo post data addition
	}
	
	
	
	
// METHOD TO ADD TRANSACTION OF A USER	
	public User addTransaction(User user, Transaction transaction) {
		user.getTransactionList().add(transaction);
		Session session=entity.unwrap(Session.class);
		session.saveOrUpdate(user);	
		session.flush();
		session.close();
		return user;
	}
	
// METHOD TO DEBOT BALANCE FORM USER ACCOUNT
	
	
	public String debitBalance(String userId, BigDecimal amount) {
		// need to validate if account is correct todo
		User accountInfo=getUser(userId);
		BigDecimal currentBalance=accountInfo.getBalance();
		if(currentBalance.compareTo(amount)>=0) {
			Session session=entity.unwrap(Session.class);
			accountInfo.setBalance(currentBalance.subtract(amount));
			session.update(accountInfo);
			session.flush();
		}else {
			// throw insufficient balance
			return "Insufficient Balance Sorry";
		}
		
		return "Updated Balance: "+currentBalance.subtract(amount)+"";
	}
	
// METHOD TO CREADIT BALANCE TO USER ACCOUNT
	
	public String creaditBalance(String userId, BigDecimal amount) {
		// need to validate if account is correct todo
		User accountInfo=getUser(userId);
		BigDecimal currentBalance=accountInfo.getBalance();
		
			Session session=entity.unwrap(Session.class);
			accountInfo.setBalance(currentBalance.add(amount));
			session.update(accountInfo);
			session.flush();
		return "Updated Balance: "+currentBalance.add(amount)+"";
	}
	
// METHOD TO GET USER FROM DB USING USER ID
	
	public User getUser(String userId) {
		User userInfo = null;
		try {
			Session session=entity.unwrap(Session.class);
			Query<User> query=session.createQuery(" select account from User account where account.userId=:userId", User.class);
			query.setParameter("userId", userId);
			userInfo=query.getSingleResult();
			return userInfo;
		}catch(NoResultException e) {
			throw new NoUserFoundException("No User Found");
		}catch(Exception e) {
			// to throw generic exception stating server error/ db error
			throw new NoUserFoundException("No User FOund for this Exception");
		}
	
	}

// METHOD TO GET USER FORM DB USING USER ACCOUNT NUMBER 
	
	public User getUserAccountNumber(String accountNumber) {
		try {
			Session session=entity.unwrap(Session.class);
			Query<User> query=session.createQuery(" select account from User account where account.accountNumber=:accountNumber", User.class);
			query.setParameter("accountNumber", accountNumber);
			User userInfo=query.getSingleResult();
			return userInfo;
		}catch(NoResultException e) {
			throw new NoUserFoundException("No User Found for the given Account Number");
		}
		catch(Exception e) {
			// to throw generic exception stating server error/ db error
			throw new NoUserFoundException("Basically to deal with DB or server error");
		}
	}
	

}

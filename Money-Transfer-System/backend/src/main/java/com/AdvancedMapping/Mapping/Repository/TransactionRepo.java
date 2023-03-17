package com.AdvancedMapping.Mapping.Repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.AdvancedMapping.Mapping.Models.Transaction;
import com.AdvancedMapping.Mapping.Models.User;

@Repository
public class TransactionRepo {
	
	@Autowired
	private EntityManager entity;
	
// Method to add transaction	
	public String addTransaction(Transaction trans) {

		Session session=entity.unwrap(Session.class);
		session.saveOrUpdate(trans);
		session.flush();				
		return "";
	}
// Method to get transaction whole transaction list	
	public List<Transaction> getTransaction() {
		Session session=entity.unwrap(Session.class);
		Query<Transaction> query=session.createQuery("from Transaction", Transaction.class);
		List<Transaction> list=query.getResultList();
		return list;
	}
	
// Method to get the last 10 transaction
	public void getLastTenTransaction() {
		// todo
	}
	
// Method to get the transaction from last 3 months
	public void getLastThreeMonthTransaction() {
		//todo
	}

	
}

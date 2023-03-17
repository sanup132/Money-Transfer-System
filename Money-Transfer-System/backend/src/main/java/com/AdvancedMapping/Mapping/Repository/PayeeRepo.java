package com.AdvancedMapping.Mapping.Repository;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.AdvancedMapping.Mapping.Models.PayeeInfo;

@Repository
public class PayeeRepo {
	
	@Autowired
	private EntityManager entity;

// Method to add Payee 
	
	public String addPayee(PayeeInfo payee) {
		
		Session session=entity.unwrap(Session.class);
		session.saveOrUpdate(payee);
		session.flush();		
		return "Payee Successfully Added";
	}

// Method to remove Payee
	
	public String removePayee(String accountNumber) {
		Session session=entity.unwrap(Session.class);
		Query query=session.createQuery("delete from PayeeInfo df where df.accountNumber=:id");
		query.setParameter("id", accountNumber);
		int num=query.executeUpdate();
		return "Payee Removed Successfully";
	}
	
// Method to get Payee
	
	public PayeeInfo getPayee(String accountNumber) {
		Session session=entity.unwrap(Session.class);
		Query<PayeeInfo> query=session.createQuery("select payee from PayeeInfo payee where payee.accountNumber=:accountNumber", PayeeInfo.class);
		query.setParameter("accountNumber", accountNumber);
		return query.getSingleResult();
	}
	

}

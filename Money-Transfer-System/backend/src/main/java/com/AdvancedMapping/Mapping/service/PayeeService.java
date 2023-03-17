package com.AdvancedMapping.Mapping.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AdvancedMapping.Mapping.Models.PayeeInfo;
import com.AdvancedMapping.Mapping.Repository.PayeeRepo;


@Service
@Transactional
public class PayeeService {
	
//	private UserRepo user;
	@Autowired
	private PayeeRepo payee;
	
	public String addPayee(PayeeInfo payeeInfo) {
		return payee.addPayee(payeeInfo);
	}
	
	public String removePayee(String accountNumber) {
		return payee.removePayee(accountNumber);
	}
	
	public PayeeInfo getPayee(String accountNumber) {
		return payee.getPayee(accountNumber);
	}
	

}

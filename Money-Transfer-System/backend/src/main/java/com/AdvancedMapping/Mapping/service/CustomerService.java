package com.AdvancedMapping.Mapping.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.AdvancedMapping.Mapping.Models.Customer;
import com.AdvancedMapping.Mapping.Repository.CustomerRepo;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public void saveCustomer(Customer customer) {
		String enteredPassword=customer.getPassword();
		String hashCodePassword=passwordEncoder.encode(enteredPassword);
		customer.setPassword(hashCodePassword);
		customerRepo.saveAndFlush(customer);
	}
	
	@SuppressWarnings("deprecation")
	public Customer getCustomer(String userId) {
		try {
		return customerRepo.getCustomerFromUserName(userId);
		}catch(Exception e) {
			return customerRepo.getById(1);
		}
	}
	
	
	
}

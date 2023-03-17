package com.AdvancedMapping.Mapping.Controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AdvancedMapping.Mapping.Models.PayeeInfo;
import com.AdvancedMapping.Mapping.Models.Transaction;
import com.AdvancedMapping.Mapping.Models.User;
import com.AdvancedMapping.Mapping.service.AccountService;
import com.AdvancedMapping.Mapping.service.PayeeService;

@RestController
public class AccountController {

	@Autowired
	private AccountService service;
	
	@Autowired
	private PayeeService payeeService;
/*	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable String id) {
	return	service.getUser(id);	
	}
	
	// logic seems to work depend upon the front end can be modified
	@GetMapping("/users/{userId}/{amount}")
	public String updateBalance(@PathVariable String userId, @PathVariable BigDecimal amount, @RequestParam String type) {
		return service.updateBalance(userId,amount , type);
	}
	
	@PostMapping("/payees/{userId}")
	public User addPayee(@PathVariable String userId, @RequestBody PayeeInfo payee) {
		
	return	service.getPayee(userId, payee);	
		
		
	}
	
	@PostMapping("/transaction/{userId}")
	public User addPayee(@PathVariable String userId, @RequestBody Transaction payee) {
		
	return	service.addTransaction(userId, payee);	
		
		
	}
	
	@GetMapping("/transaction")
	public List<Transaction> getTransactionList() {
		
	return	service.getTransaction();	
		
		
	}
	
		
	
	@GetMapping("/users")
	public String getUser() {
	return	"successfulll";
	}
	
	@PostMapping("/payees")
	public PayeeInfo addPayee(@RequestBody PayeeInfo payee) {
	 payeeService.addPayee(payee);
	 return payee;
	}
	
	@DeleteMapping("/payees/{accountNumber}")
	public String removePayee(@PathVariable String accountNumber) {
		return payeeService.removePayee(accountNumber);
	}
	
	@GetMapping("/payees/{accountNumber}")
	public PayeeInfo getPayee(@PathVariable String accountNumber) {
		return payeeService.getPayee(accountNumber);
	}
	
	
	*/
}

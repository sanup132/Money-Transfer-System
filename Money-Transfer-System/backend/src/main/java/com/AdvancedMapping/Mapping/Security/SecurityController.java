package com.AdvancedMapping.Mapping.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AdvancedMapping.Mapping.Models.Customer;
import com.AdvancedMapping.Mapping.service.CustomerService;

@RestController
@RequestMapping("/security")
public class SecurityController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers/{userId}")
	public Customer getCustomer(@PathVariable String userId) {
		return customerService.getCustomer(userId);
	}
	
	@PostMapping("/customers")
	public String saveCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return "User Successfully Added: "+customer.getUserId();
	}
	
	@GetMapping("/customers")
	public String test() {
		return "Good One";
	}
	
	
	
}

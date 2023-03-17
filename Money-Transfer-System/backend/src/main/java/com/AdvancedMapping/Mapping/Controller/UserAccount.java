package com.AdvancedMapping.Mapping.Controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.AdvancedMapping.Mapping.Models.PayeeInfo;
import com.AdvancedMapping.Mapping.Models.User;
import com.AdvancedMapping.Mapping.ReturnTypeData.PayeeData;
import com.AdvancedMapping.Mapping.ReturnTypeData.TransactionData;
import com.AdvancedMapping.Mapping.ReturnTypeData.TransferAmountData;
import com.AdvancedMapping.Mapping.ReturnTypeData.UserData;
import com.AdvancedMapping.Mapping.ReturnTypeData.UserWithPayee;
import com.AdvancedMapping.Mapping.service.UserAccountService;

@RestController()
@RequestMapping("/bank")
public class UserAccount {
	
	@Autowired
	private UserAccountService userService;
	
	//Method to get the user account info
	@GetMapping("/users/{userId}")
	public ResponseEntity<UserData> getUserAccountInfo(@PathVariable String userId) {
		 UserData data=userService.getUserAccountInfo(userId);	
		 return ResponseEntity.ok().body(data);
	}	

// Method to add Beneficiary
	@PostMapping("/users/{userId}")
	public ResponseEntity<UserWithPayee> addPayee(@RequestBody PayeeInfo payeeInfo, @PathVariable String userId) {
		return ResponseEntity.ok().body(userService.addPayee(payeeInfo, userId));
	}

// Method to add User
	@CrossOrigin(origins = "*")
	@PostMapping("/users")
	public String addUser(@RequestBody User user) {
		userService.addUser(user);
		return "User registered successfully";
	}
	
	
// METHOD TO GET USER PAYEE FOR A USER
	@GetMapping("/users/{userId}/payees")
	public ResponseEntity<List<PayeeData>> getPayeeforUser(@PathVariable String userId) {
		return ResponseEntity.ok().body(userService.getPayeeforUser(userId));
	}
	
	
//Method to perform transaction 
	// First API Call will be need to depricate in future as per team suggestion
	@PostMapping("/users/{userId}/{amount}")
	public ResponseEntity<String> debitBalance(@PathVariable String userId,@PathVariable BigDecimal amount, @RequestBody PayeeInfo payeeInfo) {
		User user=userService.debitBalance(userId, amount, payeeInfo);
		
		return ResponseEntity.ok("Transaction Successful");
	}
	
	// Second API call to make transfer amount 
	
	@PostMapping("/transfer/{userId}")
	public ResponseEntity<User> transferBalance(@PathVariable String userId, @RequestBody TransferAmountData amountData) {
		return ResponseEntity.ok().body(userService.transferAmount(amountData, userId));
	}
		
	
// Method to get the transaction 	
	
	
	@GetMapping("/users/{userId}/transaction")
	public ResponseEntity<List<TransactionData>> getTransaction(@PathVariable String userId) {		
		return ResponseEntity.ok().body(userService.getTransactionforUsers(userId));
	}
	
	
// adding user 							/users - post Method 
// getting user							/users/{userId}
// adding payee							/users/{userId}/payees
// getting payee						/users/{userId}/payees   
// deleting payee						/users/{userId}/payees/{accountNumber}
// perform transaction					/transfer
// getting transaction 					/
// capable of handling external calls only - handle bad request - use aspect(aop) oriented programming


}

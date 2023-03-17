package com.AdvancedMapping.Mapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.AdvancedMapping.Mapping.Models.Customer;

@SuppressWarnings("unused")
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	@Query("select customer from Customer customer where customer.userId = :name")
	public Customer getCustomerFromUserName(@Param("name") String userName);
	
}

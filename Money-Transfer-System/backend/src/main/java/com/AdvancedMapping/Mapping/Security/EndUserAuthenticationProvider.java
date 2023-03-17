package com.AdvancedMapping.Mapping.Security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.AdvancedMapping.Mapping.Models.Customer;
import com.AdvancedMapping.Mapping.service.CustomerService;

@Component
public class EndUserAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
			String userId=authentication.getName();
			Customer customer=customerService.getCustomer(userId);
			String password=authentication.getCredentials().toString();
			List<GrantedAuthority> authorities= new ArrayList<>();
			if(passwordEncoder.matches(password, customer.getPassword())) {
				return new UsernamePasswordAuthenticationToken(userId, password, authorities);
			}else {
				throw new BadCredentialsException("Invalid Credentials");
			}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}

package com.AdvancedMapping.Mapping.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecuirtyConfig {
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
		http.cors().disable().csrf().disable()
			.authorizeHttpRequests()
			.antMatchers("/bank/**").permitAll()
			.antMatchers("/security/customers").authenticated()
			.antMatchers("/security/login").permitAll()
			.and().formLogin().and().httpBasic();
		return http.build();
	}

	
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}

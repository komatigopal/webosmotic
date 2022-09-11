package com.webosmotic.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.webosmotic.model.Customer;
import com.webosmotic.model.CustomerDto;

public interface CustomerService extends UserDetailsService {
	public Customer save(CustomerDto customerDto);

}

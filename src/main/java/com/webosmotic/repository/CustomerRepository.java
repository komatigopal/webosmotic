package com.webosmotic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.webosmotic.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	Customer findByCustId(long custId);

	Customer findByUserName(String userName);

	List<Customer> findAll();
}

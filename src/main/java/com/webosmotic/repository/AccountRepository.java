package com.webosmotic.repository;

import org.springframework.data.repository.CrudRepository;

import com.webosmotic.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
	Account findByAccountNumber(long accountNumber);
}

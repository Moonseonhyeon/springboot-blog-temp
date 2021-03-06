package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Account;

public interface AccountRepository {
	
	public void update(Account account);
	
	public List<Account> findAll();
	
	public Account findByAccountNumber(String accountNumber);
	
}
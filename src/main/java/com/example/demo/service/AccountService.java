package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.SendRequestDto;
import com.example.demo.dto.WithdrawRequestDto;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Transactional
	public void 송금(SendRequestDto dto) {
		Account 홍길동 = accountRepository.findByAccountNumber(dto.getSenderAccountNumber());
		홍길동.setMoney(홍길동.getMoney()- dto.getMoney());
		accountRepository.update(홍길동);
		
		Account 장보고 = accountRepository.findByAccountNumber(dto.getReceiverAccountNumber());
		장보고.setMoney(장보고.getMoney()+dto.getMoney());
		accountRepository.update(장보고);
	}
	
	@Transactional
	public void 인출 (WithdrawRequestDto dto) {
		Account 홍길동 = accountRepository.findByAccountNumber(dto.getAccountNumber());
		홍길동.setMoney(홍길동.getMoney() - dto.getMoney());
		accountRepository.update(홍길동);
	}
	
	@Transactional(readOnly = true)
	public List<Account> 계좌정보보기 () {
		return accountRepository.findAll();		
	}

}

package com.company.bank.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.bank.web.config.BankConfiguration;
import com.company.bank.web.proxy.AccountServiceProxy;
import com.company.bank.web.service.BankService;
import com.company.bank.web.vo.BankVO;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankConfiguration bankConfiguration;
	
	@Autowired
	private AccountServiceProxy accountServiceProxy;
	
	@Override
	public BankVO getBankInformation(int id) {
		BankVO bankVO = accountServiceProxy.getAccount(id);
		String accountID = String.valueOf(bankVO.getId());
		String baseIBAN = bankConfiguration.getIban();
		String accountIBAN = baseIBAN.substring(0, (baseIBAN.length() - accountID.length())) + accountID; 
		bankVO.setIban(accountIBAN);		
		return bankVO;
	}
}

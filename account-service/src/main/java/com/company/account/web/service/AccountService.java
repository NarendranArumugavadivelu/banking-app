package com.company.account.web.service;

import java.util.List;

import com.company.account.web.vo.AccountVO;

public interface AccountService {

	public List<AccountVO> findAll();
	
	public AccountVO findById(int id);
	
	public void save(AccountVO accountVO);
	
}

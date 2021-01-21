package com.company.account.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.account.web.dto.AccountDTO;
import com.company.account.web.repository.AccountRepository;
import com.company.account.web.service.AccountService;
import com.company.account.web.vo.AccountVO;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<AccountVO> findAll() {
		List<AccountVO> accountVOs = new ArrayList<>();
		List<AccountDTO> accountDTOs = accountRepository.findAll();
		for(AccountDTO accountDTO : accountDTOs) {
			AccountVO accountVO = new AccountVO();
			accountVO.setId(accountDTO.getId());
			accountVO.setFirstName(accountDTO.getFirstName());
			accountVO.setLastName(accountDTO.getLastName());
			accountVOs.add(accountVO);
		}
		return accountVOs;
	}

	@Override
	public AccountVO findById(int id) {
		AccountVO accountVO = new AccountVO();
		AccountDTO accountDTO = accountRepository.findById(id).get();
		if(accountDTO != null) {
			accountVO.setId(accountDTO.getId());
			accountVO.setFirstName(accountDTO.getFirstName());
			accountVO.setLastName(accountDTO.getLastName());
		}
		return accountVO;
	}

	@Override
	public void save(AccountVO accountVO) {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(accountVO.getId());
		accountDTO.setFirstName(accountVO.getFirstName());
		accountDTO.setLastName(accountVO.getLastName());
		accountRepository.save(accountDTO);		
	}
}

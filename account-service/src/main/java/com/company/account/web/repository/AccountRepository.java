package com.company.account.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.account.web.dto.AccountDTO;

public interface AccountRepository extends JpaRepository<AccountDTO, Integer> {

	
}

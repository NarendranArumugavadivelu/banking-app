package com.company.bank.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.bank.web.service.BankService;
import com.company.bank.web.vo.BankVO;

@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BankController {
	
	@Autowired
	private BankService bankService;

	@GetMapping(path = "/bank/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public @ResponseBody BankVO getBankInformation(@PathVariable("id") int id) {
		return bankService.getBankInformation(id);
	}
}

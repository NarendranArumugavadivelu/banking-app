package com.company.account.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.account.web.service.AccountService;
import com.company.account.web.vo.AccountVO;

@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping(path = "/account", produces = {MediaType.APPLICATION_JSON_VALUE})
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public @ResponseBody List<AccountVO> getAccounts() {
		return accountService.findAll();
	}
	
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping(path = "/account/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody AccountVO getAccount(@PathVariable ("id") int id) {
		return accountService.findById(id);
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping(path = "/account", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> saveAccount(@RequestBody AccountVO accountVO) {
		accountService.save(accountVO);
		return new ResponseEntity<String>("Saved Successfully", HttpStatus.OK);
	}
	
}

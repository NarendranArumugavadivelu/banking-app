package com.company.bank.web.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.bank.web.config.AccountClientConfiguration;
import com.company.bank.web.vo.BankVO;

@FeignClient(name = "netflix-zuul-api-gateway-server", configuration = AccountClientConfiguration.class)
@RibbonClient(name = "account-service")
public interface AccountServiceProxy {

	@GetMapping(path = "/account-service/account/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody BankVO getAccount(@PathVariable ("id") int id);
	
}

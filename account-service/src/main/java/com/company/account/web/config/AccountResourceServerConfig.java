package com.company.account.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
public class AccountResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private AccountConfiguration accountConfiguration;
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(accountConfiguration.getResourceId());
	}

	@Bean
	@Primary
    public RemoteTokenServices tokenServices() {
        final RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl(accountConfiguration.getTokenInfoURI());
        tokenService.setClientId(accountConfiguration.getClientId());
        tokenService.setClientSecret(accountConfiguration.getClientSecret());
        return tokenService;
    }
}

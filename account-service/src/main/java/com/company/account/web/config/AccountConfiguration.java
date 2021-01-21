package com.company.account.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("account-service")
public class AccountConfiguration {
	
	private String clientId;
	
	private String clientSecret;
	
	private String resourceId;
	
	private String tokenInfoURI;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getTokenInfoURI() {
		return tokenInfoURI;
	}

	public void setTokenInfoURI(String tokenInfoURI) {
		this.tokenInfoURI = tokenInfoURI;
	}
	
	

}

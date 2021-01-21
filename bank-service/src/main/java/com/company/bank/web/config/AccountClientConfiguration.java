package com.company.bank.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class AccountClientConfiguration {

	@Bean
	public RequestInterceptor requestTokenBearerInterceptor() {
		return new RequestInterceptor() {
			
			@Override
			public void apply(RequestTemplate template) {
				OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
				template.header("Authorization", "bearer " + oAuth2AuthenticationDetails.getTokenValue());
			}
		};
	}
}

package com.claim_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigrationRest {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}

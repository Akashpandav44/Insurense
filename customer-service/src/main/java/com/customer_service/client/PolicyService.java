package com.customer_service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class PolicyService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public String getPolicy(String  customerId) {
		
		String url="http://localhost:9093:policy/{customerId}"+customerId;
		return restTemplate.getForObject(url, String.class);
	}
	

}

package com.example.salesforceapp.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.salesforceapp.config.SalesforceConfig;

@Component
public class BearerTokenService {

	@Autowired
	private SalesforceConfig salesforceConfig;
	
	@Autowired
	private RestTemplate restTemplate;

	
	public String getBarerToken() throws RuntimeException {
		StringBuffer buf = new StringBuffer();
		buf.append(salesforceConfig.getHostName()+salesforceConfig.getTokenServiceUrl());
		System.out.println("Url :" +buf.toString());
		MultiValueMap<String, String> map = getRequestBodyForBarerToken();
		Map<String, String> resp = restTemplate.postForObject(buf.toString(), 
				  map, Map.class);
		return resp.get("access_token");
		
	}

	private MultiValueMap<String, String> getRequestBodyForBarerToken() {
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
		requestBody.add("password",salesforceConfig.getPassword()+salesforceConfig.getSecurityToken());
		requestBody.add("username",salesforceConfig.getUsername());
		requestBody.add("client_id",salesforceConfig.getClientId());
		requestBody.add("client_secret",salesforceConfig.getClientSecret());
		requestBody.add("grant_type","password");
		System.out.println(requestBody.toString());
		return requestBody;
	}
}

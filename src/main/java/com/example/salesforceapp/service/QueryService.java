package com.example.salesforceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.salesforceapp.config.SalesforceConfig;
import com.example.salesforceapp.model.SObjectDescribeSalesforceData;

@Service
public class QueryService {

	@Autowired
	private BearerTokenService tokenService;
	
	@Autowired
	private SalesforceConfig salesforceConfig;
	
	public void getQueryResult(String query) {
		String url = salesforceConfig.getQueryUrl();
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+tokenService.getBarerToken());
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<SObjectDescribeSalesforceData> response = template.exchange(url, HttpMethod.GET, entity, SObjectDescribeSalesforceData.class);
        //return response.getBody();
	}
}

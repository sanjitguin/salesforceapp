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
import com.example.salesforceapp.model.QuerySalesforceData;

@Service
public class QueryService {

	@Autowired
	private BearerTokenService tokenService;
	
	@Autowired
	private SalesforceConfig salesforceConfig;
	
	@Autowired
	private RestTemplate template;
	
	public QuerySalesforceData getQueryResult(String query) {
		String url = salesforceConfig.queryServiceUrl(query);
		System.out.println("URL "+url);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+tokenService.getBarerToken());
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<QuerySalesforceData> response = template.exchange(url, HttpMethod.GET, entity, QuerySalesforceData.class);
        return response.getBody();
	}
}

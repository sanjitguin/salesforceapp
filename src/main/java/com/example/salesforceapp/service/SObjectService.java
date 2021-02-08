package com.example.salesforceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.salesforceapp.config.SalesforceConfig;
import com.example.salesforceapp.model.SObject;
import com.example.salesforceapp.model.SObjectDescribeSalesforceData;
import com.example.salesforceapp.model.SObjectSalesforceData;
import com.example.salesforceapp.model.SObjectsSalesforceData;

@Service
public class SObjectService {

	@Autowired
	private BearerTokenService tokenService;
	
	@Autowired
	private SalesforceConfig salesForceConf;
	
	@Autowired
	RestTemplate template;
	
	public List<SObject> findAllSObjects() {
		String url = salesForceConf.sobjectServiceUrl(null);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+tokenService.getBarerToken());
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<SObjectsSalesforceData> response = template.exchange(url, HttpMethod.GET, entity, SObjectsSalesforceData.class);
        return response.getBody().getSobjects();
		
	}
	
	public SObject findSObject(String name) {
		String url = salesForceConf.sobjectServiceUrl(name);
		System.out.println("Url :" +url);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+tokenService.getBarerToken());
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<SObjectSalesforceData> response = template.exchange(url, HttpMethod.GET, entity, SObjectSalesforceData.class);
        return response.getBody().getObjectDescribe();
		
	}
	
	public SObjectDescribeSalesforceData findSObjectDescribe(String sobjectname) {
		String url = salesForceConf.sobjectDescribeServiceUrl(sobjectname);
		System.out.println("Url :" +url);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+tokenService.getBarerToken());
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<SObjectDescribeSalesforceData> response = template.exchange(url, HttpMethod.GET, entity, SObjectDescribeSalesforceData.class);
        return response.getBody();
		
	}
}

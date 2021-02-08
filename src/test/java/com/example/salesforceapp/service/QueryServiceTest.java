package com.example.salesforceapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.salesforceapp.TestDataProvider;
import com.example.salesforceapp.config.SalesforceConfig;
import com.example.salesforceapp.model.QuerySalesforceData;
import com.example.salesforceapp.model.SObject;
import com.example.salesforceapp.model.SObjectSalesforceData;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class QueryServiceTest {
	
	@Injectable private BearerTokenService tokenService;
	@Injectable private SalesforceConfig salesforceConfig;
	@Injectable	private RestTemplate template;
	
	@Tested QueryService service;
	
	@Test
	public void test_getQueryResult() {
		String query = "";
		QuerySalesforceData data = new QuerySalesforceData();
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<QuerySalesforceData> fakeResp = new ResponseEntity<>(
				data,
				header, 
			    HttpStatus.OK
			);
		new Expectations() {{
			tokenService.getBarerToken(); result="most_secret_token";
			template.exchange(anyString, HttpMethod.GET, (HttpEntity)any, QuerySalesforceData.class); result=fakeResp;
		}};
		QuerySalesforceData queryResult = service.getQueryResult(query);
		assertEquals(queryResult, data);
	}
	
	@Test(expected = RuntimeException.class)
	public void test_getQueryResult_throwsException() {
		String query = "";
		QuerySalesforceData data = new QuerySalesforceData();
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<QuerySalesforceData> fakeResp = new ResponseEntity<>(
				data,
				header, 
			    HttpStatus.OK
			);
		new Expectations() {{
			tokenService.getBarerToken(); result="most_secret_token";
			template.exchange(anyString, HttpMethod.GET, (HttpEntity)any, QuerySalesforceData.class); result=new RuntimeException();
		}};
		QuerySalesforceData queryResult = service.getQueryResult(query);
		assertEquals(queryResult, data);
	}
	

}

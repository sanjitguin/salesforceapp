package com.example.salesforceapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.salesforceapp.TestDataProvider;
import com.example.salesforceapp.config.SalesforceConfig;
import com.example.salesforceapp.model.SObject;
import com.example.salesforceapp.model.SObjectDescribeSalesforceData;
import com.example.salesforceapp.model.SObjectSalesforceData;
import com.example.salesforceapp.model.SObjectsSalesforceData;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class SObjectServiceTest {

	@Injectable	private BearerTokenService tokenService;
	@Injectable	private SalesforceConfig salesForceConf;
	@Injectable private RestTemplate template;
	
	@Tested private SObjectService service;
	
	@Test
	public void test_findAllSObjects() {
		SObjectsSalesforceData data = new SObjectsSalesforceData();
		data.setSobjects(TestDataProvider.getSObjects());
		data.setEncoding("UTF-8");
		data.setMaxBatchSize("200");
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<SObjectsSalesforceData> fakeResp = new ResponseEntity<>(
				data,
				header, 
			    HttpStatus.OK
			);
		new Expectations() {{
			tokenService.getBarerToken(); result="most_secret_token";
			template.exchange(anyString, HttpMethod.GET, (HttpEntity)any, SObjectsSalesforceData.class); result=fakeResp;
		}};
		List<SObject> sobjects = service.findAllSObjects();
		assertEquals(sobjects.size(), data.getSobjects().size());
		assertEquals(sobjects, data.getSobjects());
	}
	
	
	@Test
	public void test_findSObject() {
		
		SObject sobjectData = TestDataProvider.getSObjects().get(0);
		String sobjectName = "";
		
		SObjectSalesforceData data = new SObjectSalesforceData();
		data.setObjectDescribe(sobjectData);
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<SObjectSalesforceData> fakeResp = new ResponseEntity<>(
				data,
				header, 
			    HttpStatus.OK
			);
		new Expectations() {{
			tokenService.getBarerToken(); result="most_secret_token";
			template.exchange(anyString, HttpMethod.GET, (HttpEntity)any, SObjectSalesforceData.class); result=fakeResp;
		}};
		SObject sobjects = service.findSObject(sobjectName);
		assertEquals(sobjects, sobjectData);
	}
	
	@Test
	public void test_findSObjectDescribe() {
		
		SObjectDescribeSalesforceData data = new SObjectDescribeSalesforceData();
		String sobjectName = "";
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<SObjectDescribeSalesforceData> fakeResp = new ResponseEntity<>(
				data,
				header, 
			    HttpStatus.OK
			);
		new Expectations() {{
			tokenService.getBarerToken(); result="most_secret_token";
			template.exchange(anyString, HttpMethod.GET, (HttpEntity)any, SObjectDescribeSalesforceData.class); result=fakeResp;
		}};
		SObjectDescribeSalesforceData sobjects = service.findSObjectDescribe(sobjectName);
		assertEquals(sobjects, data);
	}
	
	@Test(expected = RuntimeException.class)
	public void test_findAllSObjects_throwsException() {
		SObjectsSalesforceData data = new SObjectsSalesforceData();
		data.setSobjects(TestDataProvider.getSObjects());
		data.setEncoding("UTF-8");
		data.setMaxBatchSize("200");
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<SObjectsSalesforceData> fakeResp = new ResponseEntity<>(
				data,
				header, 
			    HttpStatus.OK
			);
		new Expectations() {{
			tokenService.getBarerToken(); result="most_secret_token";
			template.exchange(anyString, HttpMethod.GET, (HttpEntity)any, SObjectsSalesforceData.class); result=new RuntimeException();
		}};
		List<SObject> sobjects = service.findAllSObjects();
	}
	
	
	
}

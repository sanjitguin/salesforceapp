package com.example.salesforceapp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.salesforceapp.controller.response.SObjectResponse;
import com.example.salesforceapp.model.SObject;

public class TestDataProvider {

	public static List<SObject> getSObjects() {
		SObject o = new SObject();
		return Arrays.asList(o);
	}
	
	public static ResponseEntity<SObjectResponse> getSobjectResponse() {
		SObjectResponse resp = new SObjectResponse();
		resp.setData(getSObjects());
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<>(
				resp,
				header, 
			    HttpStatus.OK
			);
	}
	
	
}

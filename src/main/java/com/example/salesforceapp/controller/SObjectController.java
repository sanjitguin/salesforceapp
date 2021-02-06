package com.example.salesforceapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.salesforceapp.controller.response.SObjectDescribeResponse;
import com.example.salesforceapp.controller.response.SObjectResponse;
import com.example.salesforceapp.model.SObject;
import com.example.salesforceapp.model.SObjectDescribeSalesforceData;
import com.example.salesforceapp.service.SObjectService;

@RestController
@RequestMapping("/sobject")
public class SObjectController {

	@Autowired
	private SObjectService sobjectService;
	
	@GetMapping
	public ResponseEntity<SObjectResponse> getAllSObjects() {
		SObjectResponse resp = new SObjectResponse(HttpStatus.OK);
		try {
			List<SObject> vos = sobjectService.findAllSObjects();
			resp.setData(vos);
			resp.setSuccess(true);
		}catch (RuntimeException e) {
			resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			resp.setMessage(e.getMessage());
			resp.setSuccess(false);
		}
		return new ResponseEntity<SObjectResponse>(resp, resp.getStatus());
		
	}
	
	@GetMapping(value = "/{name}")
	public ResponseEntity<SObjectResponse> getSObject(@PathVariable("name") String name) {
		SObjectResponse resp = new SObjectResponse(HttpStatus.OK);
		try {
			SObject vos = sobjectService.findSObject(name);
			resp.setData(Arrays.asList(vos));
			resp.setSuccess(true);
		}catch (RuntimeException e) {
			resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			resp.setMessage(e.getMessage());
			resp.setSuccess(false);
		}
		return new ResponseEntity<SObjectResponse>(resp, resp.getStatus());
		
	}
	
	@GetMapping(value = "/{name}/describe")
	public ResponseEntity<SObjectDescribeResponse> getSObjectDescribe(@PathVariable("name") String name) {
		SObjectDescribeResponse resp = new SObjectDescribeResponse(HttpStatus.OK);
		try {
			SObjectDescribeSalesforceData vo = sobjectService.findSObjectDescribe(name);
			resp.setData(Arrays.asList(vo));
			resp.setSuccess(true);
		}catch (RuntimeException e) {
			resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			resp.setMessage(e.getMessage());
			resp.setSuccess(false);
		}
		return new ResponseEntity<SObjectDescribeResponse>(resp, resp.getStatus());
		
	}
}

package com.example.salesforceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.salesforceapp.controller.response.QueryResultResponse;
import com.example.salesforceapp.model.QuerySalesforceData;
import com.example.salesforceapp.service.QueryService;

@RestController
@RequestMapping("query")
public class QueryController {

	@Autowired
	private QueryService service;
	
	@GetMapping
	public ResponseEntity<QueryResultResponse> getQueryResult(@RequestParam("q") String query) {
		QueryResultResponse resp = new QueryResultResponse(HttpStatus.OK);
		try {
			System.out.println(query);
			QuerySalesforceData vos = service.getQueryResult(query);
			resp.setData(vos);
			resp.setSuccess(true);
		}catch (RuntimeException e) {
			resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			resp.setMessage(e.getMessage());
			resp.setSuccess(false);
		}
		return new ResponseEntity<QueryResultResponse>(resp, resp.getStatus());
		
	}
}

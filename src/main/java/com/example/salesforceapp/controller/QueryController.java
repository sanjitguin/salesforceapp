package com.example.salesforceapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("query")
public class QueryController {

	@GetMapping
	public void getQueryResult(@RequestParam("q") String query) {
		
		System.out.println(query);
	}
}

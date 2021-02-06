package com.example.salesforceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.salesforceapp.service.BearerTokenService;

@RestController
@RequestMapping("/salesforce")
public class AppController {
	
	@Autowired
	private BearerTokenService tokenService;
	
	@GetMapping
	public void getData() {
		
	}

}

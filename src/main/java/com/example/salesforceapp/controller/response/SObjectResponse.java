package com.example.salesforceapp.controller.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.example.salesforceapp.model.SObject;

public class SObjectResponse extends BaseResponse<SObject> {

	private List<SObject> data;
	
	@Override
	public List<SObject> getData() {
		return this.data;
	}
	
	public void setData(List<SObject> data) {
		this.data = data;
	}
	
	public SObjectResponse(HttpStatus status) {
		super(status);
	}
	
	public SObjectResponse() {
		// TODO Auto-generated constructor stub
	}
	
}

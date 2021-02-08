package com.example.salesforceapp.controller.response;

import org.springframework.http.HttpStatus;

import com.example.salesforceapp.model.SObjectSalesforceData;

public class SObjectResponse extends BaseResponse<SObjectSalesforceData>{
	
	private SObjectSalesforceData data;

	@Override
	public SObjectSalesforceData getData() {
		// TODO Auto-generated method stub
		return this.data;
	}

	public void setData(SObjectSalesforceData data) {
		this.data = data;
	}
	public SObjectResponse(HttpStatus status) {
		super(status);
	}
	public SObjectResponse() {
		// TODO Auto-generated constructor stub
	}
	

}

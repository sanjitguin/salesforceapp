package com.example.salesforceapp.controller.response;

import org.springframework.http.HttpStatus;

import com.example.salesforceapp.model.SObjectsSalesforceData;

public class SObjectsResponse extends BaseResponse<SObjectsSalesforceData> {

	private SObjectsSalesforceData data;
	
	@Override
	public SObjectsSalesforceData getData() {
		return this.data;
	}
	
	public void setData(SObjectsSalesforceData data) {
		this.data = data;
	}
	
	public SObjectsResponse(HttpStatus status) {
		super(status);
	}
	
	public SObjectsResponse() {
		// TODO Auto-generated constructor stub
	}
	
}

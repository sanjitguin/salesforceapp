package com.example.salesforceapp.controller.response;

import org.springframework.http.HttpStatus;

import com.example.salesforceapp.model.SObjectDescribeSalesforceData;

public class SObjectDescribeResponse extends BaseResponse<SObjectDescribeSalesforceData> {

	private SObjectDescribeSalesforceData data;


	public void setData(SObjectDescribeSalesforceData data) {
		this.data = data;
	}

	@Override
	public SObjectDescribeSalesforceData getData() {
		// TODO Auto-generated method stub
		return this.data;
	}

	public SObjectDescribeResponse(HttpStatus status) {
		super(status);
	}
	
	public SObjectDescribeResponse() {
		// TODO Auto-generated constructor stub
	}
	
}

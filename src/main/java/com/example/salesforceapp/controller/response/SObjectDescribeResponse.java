package com.example.salesforceapp.controller.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.example.salesforceapp.model.SObjectDescribeSalesforceData;

public class SObjectDescribeResponse extends BaseResponse<SObjectDescribeSalesforceData> {

	private List<SObjectDescribeSalesforceData> data;

	public List<SObjectDescribeSalesforceData> getData() {
		return data;
	}

	public void setData(List<SObjectDescribeSalesforceData> data) {
		this.data = data;
	}

	public SObjectDescribeResponse(HttpStatus status) {
		super(status);
	}
	
	public SObjectDescribeResponse() {
		// TODO Auto-generated constructor stub
	}
	
}

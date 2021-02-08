package com.example.salesforceapp.controller.response;

import org.springframework.http.HttpStatus;

import com.example.salesforceapp.model.QuerySalesforceData;

public class QueryResultResponse extends BaseResponse<QuerySalesforceData>{

	private QuerySalesforceData data;
	
	
	public void setData(QuerySalesforceData data) {
		this.data = data;
	}

	@Override
	public QuerySalesforceData getData() {
		// TODO Auto-generated method stub
		return this.data;
	}
	public QueryResultResponse(HttpStatus status) {
		// TODO Auto-generated constructor stub
		super(status);
	}
	public QueryResultResponse() {
		// TODO Auto-generated constructor stub
	}

}

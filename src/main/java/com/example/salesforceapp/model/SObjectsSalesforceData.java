package com.example.salesforceapp.model;

import java.util.List;

public class SObjectsSalesforceData {
	private String encoding;
    private String maxBatchSize;
    private List<SObject> sobjects;
    
    public SObjectsSalesforceData() {
		// TODO Auto-generated constructor stub
	}
	public String getEncoding() {
		return encoding;
	}
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	public String getMaxBatchSize() {
		return maxBatchSize;
	}
	public void setMaxBatchSize(String maxBatchSize) {
		this.maxBatchSize = maxBatchSize;
	}
	public List<SObject> getSobjects() {
		return sobjects;
	}
	public void setSobjects(List<SObject> sobjects) {
		this.sobjects = sobjects;
	}
	
}

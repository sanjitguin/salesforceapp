package com.example.salesforceapp.model;

import java.util.List;

public class QuerySalesforceData {

	public int totalSize;
	public boolean done;
	public List<QueryRecord> records;
	public QuerySalesforceData() {
		// TODO Auto-generated constructor stub
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public List<QueryRecord> getRecords() {
		return records;
	}
	public void setRecords(List<QueryRecord> records) {
		this.records = records;
	}
	
	
}

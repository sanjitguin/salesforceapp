package com.example.salesforceapp;

import java.util.Arrays;
import java.util.List;

import com.example.salesforceapp.model.SObject;

public class TestDataProvider {

	public static List<SObject> getSObjects() {
		SObject o = new SObject();
		return Arrays.asList(o);
	}
	
	
	
}

package com.example.salesforceapp.model;

public class QueryRecord {

	public QueryAttributes attributes;
    public Object controllingFieldDefinitionId;
    public String dataType;
    public boolean isNameField;
    public String label; 
    public String qualifiedApiName;
    public QueryRecord() {
		// TODO Auto-generated constructor stub
	}

	public QueryAttributes getAttributes() {
		return attributes;
	}

	public void setAttributes(QueryAttributes attributes) {
		this.attributes = attributes;
	}

	public Object getControllingFieldDefinitionId() {
		return controllingFieldDefinitionId;
	}

	public void setControllingFieldDefinitionId(Object controllingFieldDefinitionId) {
		this.controllingFieldDefinitionId = controllingFieldDefinitionId;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public boolean isNameField() {
		return isNameField;
	}

	public void setNameField(boolean isNameField) {
		this.isNameField = isNameField;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getQualifiedApiName() {
		return qualifiedApiName;
	}

	public void setQualifiedApiName(String qualifiedApiName) {
		this.qualifiedApiName = qualifiedApiName;
	}
    
    
}

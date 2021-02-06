package com.example.salesforceapp.config;

import java.util.Objects;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@ConfigurationProperties(prefix = "salesforce")
public class SalesforceConfig {

	private String hostName;
	private String tokenServiceUrl;
	private String username;
	private String password;
	private String securityToken;
	private String clientSecret;
	private String clientId;
	private String grantType;
	private String sobjectUrl;
	private String toolingUrl;
	private String describeUrl;
	private String queryUrl;
	
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecurityToken() {
		return securityToken;
	}
	public void setSecurityToken(String securityToken) {
		this.securityToken = securityToken;
	}
	public String getTokenServiceUrl() {
		return tokenServiceUrl;
	}
	public void setTokenServiceUrl(String tokenServiceUrl) {
		this.tokenServiceUrl = tokenServiceUrl;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getGrantType() {
		return grantType;
	}
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
	public String getSobjectUrl() {
		return sobjectUrl;
	}
	public void setSobjectUrl(String sobjectUrl) {
		this.sobjectUrl = sobjectUrl;
	}
	public String getToolingUrl() {
		return toolingUrl;
	}
	public void setToolingUrl(String toolingUrl) {
		this.toolingUrl = toolingUrl;
	}
	public String getDescribeUrl() {
		return describeUrl;
	}
	public void setDescribeUrl(String describeUrl) {
		this.describeUrl = describeUrl;
	}
	public String getQueryUrl() {
		return queryUrl;
	}
	public void setQueryUrl(String queryUrl) {
		this.queryUrl = queryUrl;
	}
	
	public String sobjectServiceUrl(String name) {
		if(Objects.isNull(name) || "".equals(name.trim()))
			return this.hostName+this.toolingUrl+this.sobjectUrl;
		else
			return this.hostName+this.toolingUrl+this.sobjectUrl+"/"+name;
	}
	public String sobjectDescribeServiceUrl(String sobjectName) {
		return sobjectServiceUrl(sobjectName)+this.describeUrl;
	}
	public String queryServiceUrl(String query) {
		return this.hostName+this.getQueryUrl()+"/?q="+query;
	}
	
	
}

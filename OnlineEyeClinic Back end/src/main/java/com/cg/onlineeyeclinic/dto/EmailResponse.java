package com.cg.onlineeyeclinic.dto;

public class EmailResponse 
{
	String token;

	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public EmailResponse(String token) {
		this.token = token;
	}

	public EmailResponse() {
	}
	
}

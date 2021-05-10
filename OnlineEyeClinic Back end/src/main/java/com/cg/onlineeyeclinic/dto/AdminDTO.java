package com.cg.onlineeyeclinic.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

//************************************Admin DTO Class**************************************//

public class AdminDTO 
{
	
	long id;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$"
	,message="please provide valid username.It can contains alphanumeric and _.It can be started only with alphabets")
	private String username;
	
	@NotNull
	@Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,10}$"
	,message="It can be minimum of 8 characters and maximum 10 characters.It contains at least one digit,one lowercase alphabet,one uppercase alphabet,one special character which includes !@#$%&*()-+=^.")
	private String password;


	//getters and setters
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
	
}

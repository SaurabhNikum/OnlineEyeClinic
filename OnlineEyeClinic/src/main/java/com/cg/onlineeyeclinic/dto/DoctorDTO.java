package com.cg.onlineeyeclinic.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//************************************Doctor DTO Class**************************************//

public class DoctorDTO 
{
	
	long id;
	
	@NotNull 
	@Size(min=2,max =50 ,message="Name should have atleast 2 characters and max to max 50 characters ") 
	private String name; 
	 
	@NotNull
	@Pattern(regexp = "^[a-zA-Z]([.-](?![.-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$",message="please provide valid username.It can contains alphanumeric and _.It can be started only with alphabets ") 
	private String userName; 
	 
	@NotNull
	@Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,10}$",
			message="It can be minimum of 8 characters and maximum 10 characters.It contains at least one digit,one lowercase alphabet,one uppercase alphabet,one special character which includes !@#$%&*()-+=^.")
	private String password; 
	 
	@NotNull 
	@Email(message="Please provide a valid email id") 
	private String email; 
	 
	@NotNull
	@Column(name="Consultation_Time") 
	private String consultationTime; 
	 
	@NotNull 
	@Pattern(regexp="^[6-9][0-9]{9}$",message="please enter valid mobile number")  
	@Column(name="Mobile_Number") 
	private String mobile; 
	 
	@NotNull
	@Size(min=2,max =200 ,message="Address should have atleast 2 characters and max to max 200 characters ") 
	@Column(name="Address") 
	private String address;

	
	//getters and setters
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	


	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getConsultationTime() {
		return consultationTime;
	}



	public void setConsultationTime(String consultationTime) {
		this.consultationTime = consultationTime;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}


	
	 
}

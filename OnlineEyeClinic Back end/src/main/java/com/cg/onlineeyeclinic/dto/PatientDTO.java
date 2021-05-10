package com.cg.onlineeyeclinic.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//************************************Patient DTO Class**************************************//

public class PatientDTO 
{	
	long id;
	
	@NotNull
	@Size(min=2,max =50 ,message="Name should have atleast 2 characters and max to max 50 characters ")
	private String name;
	
	@NotNull
	@Min(value = 1, message = "Age should not be less than 0")
    @Max(value = 150, message = "Age should not be greater than 100")
	private int age;
	
	@NotNull
	@Pattern(regexp="^[6-9][0-9]{9}$",message="please enter valid mobile number") 
	private String mobile;
	
	@NotNull
	@Email(message="Please provide a valid email id")
	private String email;
	
	@NotNull
	//@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20}$ ",message="please provide valid username.It can contains alphanumeric and _.It can be started only with alphabets ")
	private String userName;
	
	@NotNull
	@Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&]).{8,20}$",
	message="It can be minimum of 8 characters and maximum 10 characters.It contains at least one digit,one lowercase alphabet,one uppercase alphabet,one special character which includes !@#$%&*()-+=^.")
	private String password;
	
	@NotNull
	@Size(min=2,max =200 ,message="Address should have atleast 2 characters and max to max 200 characters ")
	private String address;
	
	

	//getters and setters 
	
	
	
	
	public String getName() {
		return name;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
}

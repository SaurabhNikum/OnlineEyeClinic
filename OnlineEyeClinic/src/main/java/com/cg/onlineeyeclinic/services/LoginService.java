package com.cg.onlineeyeclinic.services;

//******************************Login Service Interface***************************//

public interface LoginService 
{
	//admin login
	String adminLogin(String username,String password);
	
	//patient login
	String patientLogin(String username,String password);
	
	//doctor login
	String doctorLogin(String username,String password);
}

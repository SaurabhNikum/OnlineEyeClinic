package com.cg.onlineeyeclinic.services;

//******************************Login Service Interface***************************//

public interface LoginService 
{
	//admin login
	boolean adminLogin(String username,String password);
	
	//patient login
	boolean patientLogin(String username,String password);
	
	//doctor login
	boolean doctorLogin(String username,String password);
}

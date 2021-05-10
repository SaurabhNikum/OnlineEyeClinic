package com.cg.onlineeyeclinic.exceptions;

//Exception class,if no patient is available in the table
public class PatientNotFoundException extends Exception
{

	private static final long serialVersionUID = 1L;
	
	public PatientNotFoundException(String message)
	{
		super(message);
	}

}

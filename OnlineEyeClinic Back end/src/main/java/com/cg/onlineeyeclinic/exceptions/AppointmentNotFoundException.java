package com.cg.onlineeyeclinic.exceptions;

//Exception class,if no appointment is available in the table
public class AppointmentNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public AppointmentNotFoundException(String message)
	{
		super(message);
	}
	
}

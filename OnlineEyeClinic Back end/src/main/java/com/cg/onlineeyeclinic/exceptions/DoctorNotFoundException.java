package com.cg.onlineeyeclinic.exceptions;

//Exception class,if no doctor is available in the table
public class DoctorNotFoundException extends Exception
{

	private static final long serialVersionUID = 1L;

	public DoctorNotFoundException(String message)
	{
		super(message);
	}
}

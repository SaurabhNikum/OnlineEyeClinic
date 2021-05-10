package com.cg.onlineeyeclinic.exceptions;

//Exception class,if no admin is available in the table

public class AdminNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public AdminNotFoundException(String message)
	{
		super(message);
	}

}

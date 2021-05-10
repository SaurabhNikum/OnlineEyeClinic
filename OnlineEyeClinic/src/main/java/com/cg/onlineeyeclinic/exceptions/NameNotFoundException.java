package com.cg.onlineeyeclinic.exceptions;

//Exception class,if no object found with given name in the table
public class NameNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public NameNotFoundException(String message)
	{
		super(message);
	}

}

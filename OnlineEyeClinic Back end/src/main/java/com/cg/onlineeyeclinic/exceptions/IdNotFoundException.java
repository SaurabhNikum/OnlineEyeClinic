package com.cg.onlineeyeclinic.exceptions;


//Exception class,if no object is available with the given id in the table
public class IdNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public IdNotFoundException(String message)
	{
		super(message);
	}

}

package com.cg.onlineeyeclinic.exceptions;

//Exception class,if no spectacle is available in the table
public class SpectacleNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public SpectacleNotFoundException(String message)
	{
		super(message);
	}

}

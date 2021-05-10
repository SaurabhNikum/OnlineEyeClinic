package com.cg.onlineeyeclinic.exceptions;

//Exception class,if no test is available in the table
public class TestNotFoundException extends Exception
{

	private static final long serialVersionUID = 1L;
	
	public TestNotFoundException(String message)
	{
		super(message);
	}

}

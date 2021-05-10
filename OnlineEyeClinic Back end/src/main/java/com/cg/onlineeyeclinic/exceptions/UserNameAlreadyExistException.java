package com.cg.onlineeyeclinic.exceptions;


//Exception class,if given username is already available in the table
public class UserNameAlreadyExistException extends Exception
{
	private static final long serialVersionUID = 1L;

	public UserNameAlreadyExistException(String message)
	{
		super(message);
	}
}

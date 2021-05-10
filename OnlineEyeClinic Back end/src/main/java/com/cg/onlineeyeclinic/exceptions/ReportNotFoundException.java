package com.cg.onlineeyeclinic.exceptions;

//Exception class,if no report is available in the table
public class ReportNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;

	public ReportNotFoundException(String message)
	{
		super(message);
	}
}

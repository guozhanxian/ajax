package com.ralph.util;

public class DataAccessException extends RuntimeException
{
	public DataAccessException()
	{
		super();
	}

	public DataAccessException(String msg)
	{
		super(msg);
	}

	public DataAccessException(String msg, Throwable e)
	{
		super(msg, e);
	}
}

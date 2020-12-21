package com.rk.springboot.retry.exception;

public class RemoteServiceNotAvailableException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public RemoteServiceNotAvailableException()
	{
		
	}

	public RemoteServiceNotAvailableException(String message) {
		super(message);
	}
	
}

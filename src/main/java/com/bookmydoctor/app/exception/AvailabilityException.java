package com.bookmydoctor.app.exception;

public class AvailabilityException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final String message;

	public AvailabilityException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;

	}
}
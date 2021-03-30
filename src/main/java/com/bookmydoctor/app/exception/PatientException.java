package com.bookmydoctor.app.exception;

public class PatientException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final String message;
	public PatientException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
		
	}
}
package com.bookmydoctor.app.exception;

public class DoctorException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public DoctorException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;

	}
}

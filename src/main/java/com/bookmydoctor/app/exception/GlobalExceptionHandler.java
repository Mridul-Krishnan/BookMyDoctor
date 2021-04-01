/**
 * 
 */
package com.bookmydoctor.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Mri scan
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DoctorException.class)
	public final ResponseEntity<ExceptionResponse> handleGlobalException(DoctorException ex, WebRequest req)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), req.getDescription(false), HttpStatus.FORBIDDEN.getReasonPhrase());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(FeedBackException.class)
	public final ResponseEntity<ExceptionResponse> handleGlobalException(FeedBackException ex, WebRequest req)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), req.getDescription(false), HttpStatus.FORBIDDEN.getReasonPhrase());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(PatientException.class)
	public final ResponseEntity<ExceptionResponse> handleGlobalException(PatientException ex, WebRequest req)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), req.getDescription(false), HttpStatus.FORBIDDEN.getReasonPhrase());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(AppointmentException.class)
	public final ResponseEntity<ExceptionResponse> handleGlobalException(AppointmentException ex, WebRequest req)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), req.getDescription(false), HttpStatus.FORBIDDEN.getReasonPhrase());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(AdminException.class)
	public final ResponseEntity<ExceptionResponse> handleGlobalException(AdminException ex, WebRequest req)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), req.getDescription(false), HttpStatus.FORBIDDEN.getReasonPhrase());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.FORBIDDEN);
	}
	
}

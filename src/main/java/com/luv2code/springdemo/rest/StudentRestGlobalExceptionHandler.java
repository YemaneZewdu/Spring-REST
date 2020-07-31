package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// This class pre-processes the request and handles the exceptions globally
@ControllerAdvice
public class StudentRestGlobalExceptionHandler {
	
	// exception handler copied from StudentRestController class
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
			
			// create a StudentErrorResponse
			StudentErrorResponse error = new StudentErrorResponse();
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
		
		// generic exception handler
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
			
			// create a StudentErrorResponse
			StudentErrorResponse error = new StudentErrorResponse();
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			//error.setMessage(exc.getMessage());
			error.setMessage("Bad Request! Please enter a valid student Id");
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}

	
}

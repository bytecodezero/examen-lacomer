package com.odma.api.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.odma.api.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExpcetionHandler {
	
	
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorResponse> handleAllExceptions(Exception e, WebRequest request) {
	       ErrorResponse error = new ErrorResponse(
	    		   HttpStatus.SC_CONFLICT, e.getClass().getSimpleName(), e.getMessage());
	 
	       return new ResponseEntity<ErrorResponse>(error, null, HttpStatus.SC_CONFLICT);
	    
	 }
}

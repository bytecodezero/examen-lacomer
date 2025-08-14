package com.odma.api.exception;

public class CopomexApiException extends RuntimeException{
	
	public CopomexApiException(String message) {
        super(message);
    }

    public CopomexApiException(String message, Throwable cause) {
        super(message, cause);
    }

}

package com.odma.api.dto;


public class CopomexResponseDTO {
	
	private boolean error;
	private int code_error;
	private String error_message;
	private DireccionDTO response;
	
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public int getCode_error() {
		return code_error;
	}
	public void setCode_error(int code_error) {
		this.code_error = code_error;
	}
	public String getError_message() {
		return error_message;
	}
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
	public DireccionDTO getResponse() {
		return response;
	}
	public void setResponse(DireccionDTO response) {
		this.response = response;
	}
	
	

}

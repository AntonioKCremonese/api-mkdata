package com.br.antonio.apimkdata.handlerExceptions;

public class CustomException extends RuntimeException  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String message;
	private String error;
	
	public CustomException() {};
	
	public CustomException(String error,String message) {
		this.error = error;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
	
}

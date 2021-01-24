package br.com.company.client.exceptions;

import org.springframework.http.HttpStatus;

public abstract class BusinessException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private final HttpStatus status;
	
	BusinessException(String message, HttpStatus status){
		super(message,null, false, false);
		this.status = status;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	
}

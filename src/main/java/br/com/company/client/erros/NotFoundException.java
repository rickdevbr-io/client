package br.com.company.client.erros;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BusinessException{
	
	private static final long serialVersionUID = 1L;
	
	public NotFoundException(String message) {
		super(message,HttpStatus.NOT_FOUND);
	}

}

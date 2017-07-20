package com.vieira.rest.restsample.exeption;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

	private String message;
	private String details;
	public BaseException(String message, String detail) {
		super();
		this.message = message;
		this.details = detail;
	}
	
}

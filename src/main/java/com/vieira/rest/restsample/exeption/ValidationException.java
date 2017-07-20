package com.vieira.rest.restsample.exeption;

import lombok.Getter;

@Getter
public class ValidationException extends BaseException {

	public ValidationException(String message, String detail) {
		super(message, detail);
	}

	
}

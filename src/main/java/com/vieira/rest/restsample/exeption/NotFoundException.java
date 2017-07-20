package com.vieira.rest.restsample.exeption;

import lombok.Getter;

@Getter
public class NotFoundException extends BaseException {

	public NotFoundException(String message, String detail) {
		super(message, detail);
	}

}

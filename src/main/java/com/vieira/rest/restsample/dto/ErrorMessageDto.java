package com.vieira.rest.restsample.dto;

import lombok.Data;

@Data
public class ErrorMessageDto {

	private String code;
	private String message;
	private String details;

	
}

package com.vieira.rest.restsample.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vieira.rest.restsample.dto.ErrorMessageDto;
import com.vieira.rest.restsample.exeption.NotFoundException;
import com.vieira.rest.restsample.exeption.ValidationException;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {ValidationException.class})
	protected ResponseEntity<Object> handle(ValidationException ex,
			WebRequest request) {

		ErrorMessageDto error = new ErrorMessageDto();
		error.setCode("400");
		error.setMessage(ex.getMessage());
		error.setDetails(ex.getDetails());

		return handleExceptionInternal(ex, error, new HttpHeaders(),
				HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = {NotFoundException.class})
	protected ResponseEntity<Object> handle(NotFoundException ex,
			WebRequest request) {

		ErrorMessageDto error = new ErrorMessageDto();
		error.setCode("404");
		error.setMessage(ex.getMessage());
		error.setDetails(ex.getDetails());

		return handleExceptionInternal(ex, error, new HttpHeaders(),
				HttpStatus.NOT_FOUND, request);
	}

}

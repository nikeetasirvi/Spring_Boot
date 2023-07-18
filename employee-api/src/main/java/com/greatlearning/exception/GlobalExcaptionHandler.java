package com.greatlearning.exception;

import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Component
@RestControllerAdvice
public class GlobalExcaptionHandler {

	@ExceptionHandler(value = NoSuchElementException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public String invalidEmployeeId(NoSuchElementException e) {
		return "Invalid employee id passed for fetching";
	}
	
	@ExceptionHandler(value = EmptyResultDataAccessException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public String invalidEmployeeId(EmptyResultDataAccessException e) {
		return "Invalid employee id passed for deletion";
	}
	
}
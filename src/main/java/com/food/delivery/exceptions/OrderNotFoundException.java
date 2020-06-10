package com.food.delivery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class OrderNotFoundException.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException{
	
	/**
	 * Instantiates a new order not found exception.
	 *
	 * @param exception the exception
	 */
	public OrderNotFoundException(String exception) {
		super(exception);	
	}

}

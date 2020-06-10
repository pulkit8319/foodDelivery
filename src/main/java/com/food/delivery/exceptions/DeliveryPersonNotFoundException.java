package com.food.delivery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class DeliveryPersonNotFoundException.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DeliveryPersonNotFoundException extends RuntimeException{
	
	/**
	 * Instantiates a new delivery person not found exception.
	 *
	 * @param exception the exception
	 */
	public DeliveryPersonNotFoundException(String exception) {
		super(exception);	
	}

}

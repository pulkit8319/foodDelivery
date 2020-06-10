package com.food.delivery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class NotAcceptingOrdersException.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotAcceptingOrdersException extends RuntimeException{
	
	/**
	 * Instantiates a new not accepting orders exception.
	 *
	 * @param exception the exception
	 */
	public NotAcceptingOrdersException(String exception) {
		super(exception);	
	}

}

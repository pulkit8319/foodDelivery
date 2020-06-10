package com.food.delivery.util;

import org.springframework.stereotype.Service;

/**
 * The Class OrderUtil.
 */
@Service
public class OrderUtil {
	
	/** The id. */
	int id = 1;
	
	/**
	 * Gets the next order id.
	 *
	 * @return the next order id
	 */
	public int getNextOrderId(){
		return id++;
	}

}

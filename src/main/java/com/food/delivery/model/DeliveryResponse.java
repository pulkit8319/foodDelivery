package com.food.delivery.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class DeliveryResponse.
 */
@JsonInclude(Include.NON_NULL)
public class DeliveryResponse {
	
	/** The status. */
	private String status;
	
	/** The order id. */
	private Integer orderId;
	
	/** The time left. */
	private Integer timeLeft;
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Gets the order id.
	 *
	 * @return the order id
	 */
	public Integer getOrderId() {
		return orderId;
	}
	
	/**
	 * Sets the order id.
	 *
	 * @param orderId the new order id
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	/**
	 * Gets the time left.
	 *
	 * @return the time left
	 */
	public Integer getTimeLeft() {
		return timeLeft;
	}
	
	/**
	 * Sets the time left.
	 *
	 * @param timeLeft the new time left
	 */
	public void setTimeLeft(Integer timeLeft) {
		this.timeLeft = timeLeft;
	}
	
}

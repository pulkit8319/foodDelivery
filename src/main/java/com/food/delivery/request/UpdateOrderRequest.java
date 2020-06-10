package com.food.delivery.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The Class UpdateOrderRequest.
 */
public class UpdateOrderRequest {
	
	/** The order id. */
	@NotNull
	private Integer orderId;
	
	/** The status. */
	@NotNull
	@NotEmpty
	private String status;

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
	
	

}

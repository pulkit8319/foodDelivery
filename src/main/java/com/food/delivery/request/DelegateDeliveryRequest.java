package com.food.delivery.request;

import javax.validation.constraints.NotNull;

/**
 * The Class DelegateDeliveryRequest.
 */
public class DelegateDeliveryRequest {
	
	/** The order id. */
	@NotNull
	private Integer orderId;
	
	/** The delivery person id. */
	@NotNull
	private Integer deliveryPersonId;

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
	 * Gets the delivery person id.
	 *
	 * @return the delivery person id
	 */
	public Integer getDeliveryPersonId() {
		return deliveryPersonId;
	}

	/**
	 * Sets the delivery person id.
	 *
	 * @param deliveryPersonId the new delivery person id
	 */
	public void setDeliveryPersonId(Integer deliveryPersonId) {
		this.deliveryPersonId = deliveryPersonId;
	}
	
}

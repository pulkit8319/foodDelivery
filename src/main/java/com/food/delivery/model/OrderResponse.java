package com.food.delivery.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.food.delivery.enums.OrderStatus;

/**
 * The Class OrderResponse.
 */
@JsonInclude(Include.NON_NULL)
public class OrderResponse {

	/** The order id. */
	private Integer orderId;
	
	/** The order status. */
	private OrderStatus orderStatus;

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
	 * Gets the order status.
	 *
	 * @return the order status
	 */
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	/**
	 * Sets the order status.
	 *
	 * @param orderStatus the new order status
	 */
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * Instantiates a new order response.
	 *
	 * @param orderId the order id
	 * @param orderStatus the order status
	 */
	public OrderResponse(Integer orderId, OrderStatus orderStatus) {
		this.orderId = orderId;
		this.orderStatus = orderStatus;
	}

	/**
	 * Instantiates a new order response.
	 *
	 * @param orderStatus the order status
	 */
	public OrderResponse(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

}

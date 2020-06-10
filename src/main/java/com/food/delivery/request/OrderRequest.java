package com.food.delivery.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.food.delivery.enums.OrderStatus;
import com.food.delivery.model.Order;

/**
 * The Class OrderRequest.
 */
public class OrderRequest {

	/** The no of items. */
	@NotNull
	private Integer noOfItems;

	/**
	 * Gets the order.
	 *
	 * @return the order
	 */
	public Order getOrder() {
		return new Order.Builder().withNoOfItems(this.noOfItems).withCreateTime(new Date())
				.withOrderStatus(OrderStatus.ACCEPTED).build();
	}

	/**
	 * Gets the no of items.
	 *
	 * @return the no of items
	 */
	public Integer getNoOfItems() {
		return noOfItems;
	}

	/**
	 * Sets the no of items.
	 *
	 * @param noOfItems the new no of items
	 */
	public void setNoOfItems(Integer noOfItems) {
		this.noOfItems = noOfItems;
	}

}

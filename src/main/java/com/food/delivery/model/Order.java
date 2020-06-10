package com.food.delivery.model;

import java.util.Date;

import com.food.delivery.enums.OrderStatus;

/**
 * The Class Order.
 */
public class Order {

	/** The order id. */
	private int orderId;

	/** The create time. */
	private Date createTime;

	/** The time in minutes. */
	private int timeInMinutes;

	/** The no of items. */
	private int noOfItems;
	
	/** The order status. */
	private OrderStatus orderStatus;

	/**
	 * Instantiates a new order.
	 *
	 * @param builder the builder
	 */
	public Order(Builder builder) {
		this.noOfItems = builder.noOfItems;
		this.orderId = builder.orderId;
		this.createTime = builder.createTime;
		this.timeInMinutes = builder.timeInMinutes;
		this.orderStatus = builder.orderStatus;
	}

	/**
	 * The Class Builder.
	 */
	public static final class Builder {
		
		/** The order id. */
		private int orderId;

		/** The create time. */
		private Date createTime;

		/** The time in minutes. */
		private int timeInMinutes;

		/** The no of items. */
		private int noOfItems;
		
		/** The order status. */
		private OrderStatus orderStatus;

		/**
		 * Instantiates a new builder.
		 */
		public Builder() {
		}

		/**
		 * With no of items.
		 *
		 * @param noOfItems the no of items
		 * @return the builder
		 */
		public Builder withNoOfItems(int noOfItems) {
			this.noOfItems = noOfItems;
			return this;
		}

		/**
		 * With order id.
		 *
		 * @param id the id
		 * @return the builder
		 */
		public Builder withOrderId(int id) {
			this.orderId = id;
			return this;
		}

		/**
		 * With create time.
		 *
		 * @param createTime the create time
		 * @return the builder
		 */
		public Builder withCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}

		/**
		 * With time in minutes.
		 *
		 * @param timeInMinutes the time in minutes
		 * @return the builder
		 */
		public Builder withTimeInMinutes(int timeInMinutes) {
			this.timeInMinutes = timeInMinutes;
			return this;
		}

		/**
		 * With order status.
		 *
		 * @param orderStatus the order status
		 * @return the builder
		 */
		public Builder withOrderStatus(OrderStatus orderStatus){
			this.orderStatus = orderStatus;
			return this;
			
		}
		
		/**
		 * Builds the.
		 *
		 * @return the order
		 */
		public Order build() {
			return new Order(this);
		}
		

	}
	
	/**
	 * Gets the order id.
	 *
	 * @return the order id
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * Sets the order id.
	 *
	 * @param orderId the new order id
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * Gets the creates the time.
	 *
	 * @return the creates the time
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * Sets the creates the time.
	 *
	 * @param createTime the new creates the time
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * Gets the time in minutes.
	 *
	 * @return the time in minutes
	 */
	public int getTimeInMinutes() {
		return timeInMinutes;
	}

	/**
	 * Sets the time in minutes.
	 *
	 * @param timeInMinutes the new time in minutes
	 */
	public void setTimeInMinutes(int timeInMinutes) {
		this.timeInMinutes = timeInMinutes;
	}

	/**
	 * Gets the no of items.
	 *
	 * @return the no of items
	 */
	public int getNoOfItems() {
		return noOfItems;
	}

	/**
	 * Sets the no of items.
	 *
	 * @param noOfItems the new no of items
	 */
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
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

}

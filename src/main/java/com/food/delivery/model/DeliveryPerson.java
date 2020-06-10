package com.food.delivery.model;

/**
 * The Class DeliveryPerson.
 */
public class DeliveryPerson {

	/** The id. */
	private int id;
	
	/** The order. */
	private Order order;

	/**
	 * Instantiates a new delivery person.
	 *
	 * @param id the id
	 */
	public DeliveryPerson(int id) {
		this.id = id;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the order.
	 *
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * Sets the order.
	 *
	 * @param order the new order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

}

package com.food.delivery.service;

import java.util.Queue;

import com.food.delivery.model.DeliveryPerson;

/**
 * The Interface DeliveryService.
 */
public interface DeliveryService {

	/**
	 * Gets the first available delivery person.
	 *
	 * @return the first available delivery person
	 */
	DeliveryPerson getFirstAvailableDeliveryPerson();

	/**
	 * Gets the free delivery person by id.
	 *
	 * @param deliveryPersonId the delivery person id
	 * @return the free delivery person by id
	 */
	DeliveryPerson getFreeDeliveryPersonById(int deliveryPersonId);

	/**
	 * Gets the free delivery persons.
	 *
	 * @return the free delivery persons
	 */
	Queue<DeliveryPerson> getFreeDeliveryPersons();

	/**
	 * Gets the busy delivery persons.
	 *
	 * @return the busy delivery persons
	 */
	Queue<DeliveryPerson> getBusyDeliveryPersons();

}

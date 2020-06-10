package com.food.delivery.service.impl;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.delivery.exceptions.DeliveryPersonNotFoundException;
import com.food.delivery.exceptions.NotAcceptingOrdersException;
import com.food.delivery.model.DeliveryPerson;
import com.food.delivery.service.DeliveryService;

/**
 * The Class DeliveryServiceImpl.
 */
@Service
public class DeliveryServiceImpl implements DeliveryService {

	/** The delivery persons num. */
	int deliveryPersonsNum = 5;

	/** The busy delivery persons. */
	private Queue<DeliveryPerson> busyDeliveryPersons = new LinkedList<>();
	
	/** The free delivery persons. */
	private Queue<DeliveryPerson> freeDeliveryPersons = new LinkedList<>();
	
	/**
	 * Instantiates a new delivery service impl.
	 */
	@Autowired
	public DeliveryServiceImpl(){
		for (int i = 1; i <= deliveryPersonsNum; i++) {
			DeliveryPerson dp = new DeliveryPerson(i);
			freeDeliveryPersons.add(dp);
		}
	}

	/* (non-Javadoc)
	 * @see com.food.delivery.service.DeliveryService#getBusyDeliveryPersons()
	 */
	@Override
	public Queue<DeliveryPerson> getBusyDeliveryPersons() {
		return busyDeliveryPersons;
	}

	/* (non-Javadoc)
	 * @see com.food.delivery.service.DeliveryService#getFreeDeliveryPersons()
	 */
	@Override
	public Queue<DeliveryPerson> getFreeDeliveryPersons() {
		return freeDeliveryPersons;
	}

	

	/* (non-Javadoc)
	 * @see com.food.delivery.service.DeliveryService#getFirstAvailableDeliveryPerson()
	 */
	public DeliveryPerson getFirstAvailableDeliveryPerson() {
		if (freeDeliveryPersons.isEmpty()) {
			throw new NotAcceptingOrdersException("Currently not accepting order. Inconvenience regretted");
		}
		DeliveryPerson deliveryPerson = freeDeliveryPersons.poll();
		return deliveryPerson;
	}

	/* (non-Javadoc)
	 * @see com.food.delivery.service.DeliveryService#getFreeDeliveryPersonById(int)
	 */
	public DeliveryPerson getFreeDeliveryPersonById(int deliveryPersonId) {
		DeliveryPerson deliveryPerson = freeDeliveryPersons.stream().filter(p -> p.getId() == deliveryPersonId)
				.findAny().orElse(null);
		if (deliveryPerson == null) {
			throw new DeliveryPersonNotFoundException("Delivery person not found or is not free");
		}
		return deliveryPerson;
	}

}

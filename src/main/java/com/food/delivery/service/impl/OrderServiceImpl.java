package com.food.delivery.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.delivery.enums.OrderStatus;
import com.food.delivery.exceptions.NotAcceptingOrdersException;
import com.food.delivery.exceptions.OrderNotFoundException;
import com.food.delivery.model.DeliveryPerson;
import com.food.delivery.model.Order;
import com.food.delivery.model.OrderResponse;
import com.food.delivery.service.DeliveryService;
import com.food.delivery.service.OrderService;

/**
 * The Class OrderServiceImpl.
 */
@Service
public class OrderServiceImpl implements OrderService {

	/** The delivery persons num. */
	int deliveryPersonsNum = 5;

	/** The delivery service. */
	@Autowired
	private DeliveryService deliveryService;

	/** The order map. */
	Map<Integer, Order> orderMap = new HashMap<>();

	/* (non-Javadoc)
	 * @see com.food.delivery.service.OrderService#processOrder(com.food.delivery.model.Order)
	 */
	@Override
	public OrderResponse processOrder(Order order) {
		DeliveryPerson deliveryPerson;
		try {
			deliveryPerson = deliveryService.getFirstAvailableDeliveryPerson();

			deliveryPerson.setOrder(order);

			order.setOrderStatus(OrderStatus.IN_PROCESS);

			orderMap.put(order.getOrderId(), order);

			deliveryService.getBusyDeliveryPersons().add(deliveryPerson);
			
		} catch (NotAcceptingOrdersException e) {
			order.setOrderStatus(OrderStatus.CURRENTLY_NOT_ACCEPTING);
		}
		return new OrderResponse(order.getOrderId(), order.getOrderStatus());
	}

	/* (non-Javadoc)
	 * @see com.food.delivery.service.OrderService#getOrderStatus(int)
	 */
	@Override
	public OrderResponse getOrderStatus(int orderId) {
		Order order = getOrderByOrderId(orderId);
		return new OrderResponse(order.getOrderStatus());
	}

	/* (non-Javadoc)
	 * @see com.food.delivery.service.OrderService#updateOrderStatus(int, com.food.delivery.enums.OrderStatus)
	 */
	@Override
	public OrderResponse updateOrderStatus(int orderId, OrderStatus orderStatus) {
		Order order = getOrderByOrderId(orderId);
		order.setOrderStatus(orderStatus);
		return new OrderResponse(OrderStatus.COMPLETE);
	}

	/* (non-Javadoc)
	 * @see com.food.delivery.service.OrderService#getOrderByOrderId(int)
	 */
	@Override
	public Order getOrderByOrderId(int orderId) {
		Order order = orderMap.get(orderId);
		if (order == null) {
			throw new OrderNotFoundException("No such order exists");
		}
		return order;
	}
}

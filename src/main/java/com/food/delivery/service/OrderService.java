package com.food.delivery.service;

import com.food.delivery.enums.OrderStatus;
import com.food.delivery.model.Order;
import com.food.delivery.model.OrderResponse;

/**
 * The Interface OrderService.
 */
public interface OrderService {

	/**
	 * Process order.
	 *
	 * @param order the order
	 * @return the order response
	 */
	OrderResponse processOrder(Order order);

	/**
	 * Gets the order status.
	 *
	 * @param orderId the order id
	 * @return the order status
	 */
	OrderResponse getOrderStatus(int orderId);

	/**
	 * Update order status.
	 *
	 * @param orderId the order id
	 * @param orderStatus the order status
	 * @return the order response
	 */
	OrderResponse updateOrderStatus(int orderId, OrderStatus orderStatus);

	/**
	 * Gets the order by order id.
	 *
	 * @param orderId the order id
	 * @return the order by order id
	 */
	Order getOrderByOrderId(int orderId);

}

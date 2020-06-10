package com.food.delivery.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.delivery.enums.OrderStatus;
import com.food.delivery.model.DeliveryPerson;
import com.food.delivery.model.Order;
import com.food.delivery.model.OrderResponse;
import com.food.delivery.request.OrderRequest;
import com.food.delivery.request.UpdateOrderRequest;
import com.food.delivery.service.DeliveryService;
import com.food.delivery.service.OrderService;
import com.food.delivery.util.OrderUtil;

/**
 * The Class OrderController.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

	/** The order service. */
	@Autowired
	private OrderService orderService;

	/** The delivery service. */
	@Autowired
	private DeliveryService deliveryService;

	/** The order util. */
	@Autowired
	private OrderUtil orderUtil;

	/** The order prepare time per item. */
	@Value("${timetaken.per.item.minutes}")
	int orderPrepareTimePerItem;

	/**
	 * Creates the order.
	 *
	 * @param orderRequest the order request
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody OrderRequest orderRequest) {
		Order order = orderRequest.getOrder();
		order.setOrderId(orderUtil.getNextOrderId());
		order.setTimeInMinutes(orderPrepareTimePerItem * order.getNoOfItems());
		OrderResponse orderResponse = orderService.processOrder(order);
		return new ResponseEntity<>(orderResponse, HttpStatus.OK);
	}

	/**
	 * Gets the order status.
	 *
	 * @param orderId the order id
	 * @return the order status
	 */
	@GetMapping(path = "/{orderId}")
	public ResponseEntity<OrderResponse> getOrderStatus(@PathVariable(value = "orderId") int orderId) {
		OrderResponse orderResponse = orderService.getOrderStatus(orderId);
		return new ResponseEntity<>(orderResponse, HttpStatus.OK);
	}

	/**
	 * Update order status.
	 *
	 * @param updateOrderRequest the update order request
	 * @return the response entity
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<OrderResponse> updateOrderStatus(@Valid @RequestBody UpdateOrderRequest updateOrderRequest) {
		OrderResponse orderResponse = orderService.updateOrderStatus(updateOrderRequest.getOrderId(),
				OrderStatus.valueOf(updateOrderRequest.getStatus()));
		return new ResponseEntity<>(orderResponse, HttpStatus.OK);
	}

	/**
	 * Gets the active delivery persons.
	 *
	 * @return the active delivery persons
	 */
	@GetMapping(path = "/active")
	public ResponseEntity<List<Integer>> getActiveDeliveryPersons() {
		List<Integer> list = deliveryService.getBusyDeliveryPersons().stream().map(DeliveryPerson::getId)
				.collect(Collectors.toList());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}

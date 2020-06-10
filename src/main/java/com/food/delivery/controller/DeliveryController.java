package com.food.delivery.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.Queue;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.food.delivery.model.DeliveryResponse;
import com.food.delivery.model.Order;
import com.food.delivery.model.OrderResponse;
import com.food.delivery.request.DelegateDeliveryRequest;
import com.food.delivery.service.DeliveryService;
import com.food.delivery.service.OrderService;

/**
 * The Class DeliveryController.
 */
@RestController
@RequestMapping("/deliver")
public class DeliveryController {

	/** The delivery service. */
	@Autowired
	private DeliveryService deliveryService;

	/** The order service. */
	@Autowired
	private OrderService orderService;

	/**
	 * Delegate delivery.
	 *
	 * @param deliveryRequest the delivery request
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<OrderResponse> delegateDelivery(@Valid @RequestBody DelegateDeliveryRequest deliveryRequest) {
		Order order = orderService.getOrderByOrderId(deliveryRequest.getOrderId());
		DeliveryPerson deliveryPerson = deliveryService
				.getFreeDeliveryPersonById(deliveryRequest.getDeliveryPersonId());
		freeAlreadyAssignedPerson(order);
		deliveryService.getFreeDeliveryPersons().remove(deliveryPerson);
		deliveryService.getBusyDeliveryPersons().add(deliveryPerson);
		deliveryPerson.setOrder(order);
		return new ResponseEntity<>(new OrderResponse(OrderStatus.ACCEPTED), HttpStatus.OK);
	}

	/**
	 * Free already assigned person.
	 *
	 * @param order the order
	 */
	private void freeAlreadyAssignedPerson(Order order) {
		Queue<DeliveryPerson> busyDeliveryPerson = deliveryService.getBusyDeliveryPersons();
		for(DeliveryPerson dp : busyDeliveryPerson){
			if(dp.getOrder().equals(order)){
				busyDeliveryPerson.remove(dp);
				deliveryService.getFreeDeliveryPersons().add(dp);
				break;
			}
		}
		
	}

	/**
	 * Delivery person state.
	 *
	 * @param deliveryPersonId the delivery person id
	 * @return the response entity
	 */
	@GetMapping(path = "/{deliveryPersonId}")
	public ResponseEntity<DeliveryResponse> deliveryPersonState(
			@PathVariable(value = "deliveryPersonId") int deliveryPersonId) {
		DeliveryResponse deliveryResponse = new DeliveryResponse();
		DeliveryPerson deliveryPerson = deliveryService.getBusyDeliveryPersons().stream()
				.filter(p -> p.getId() == deliveryPersonId).findFirst().orElse(null);
		if (deliveryPerson != null) {
			deliveryResponse.setStatus("ACTIVE");
			deliveryResponse.setOrderId(deliveryPerson.getOrder().getOrderId());
			deliveryResponse.setTimeLeft(getTimeLeft(deliveryPerson.getOrder()));
		} else {
			deliveryResponse.setStatus("INACTIVE");
		}
		return new ResponseEntity<>(deliveryResponse, HttpStatus.OK);
	}

	/**
	 * Gets the time left.
	 *
	 * @param order the order
	 * @return the time left
	 */
	private Integer getTimeLeft(Order order) {
		int timeInMinutes = order.getTimeInMinutes();
		Calendar calendar = Calendar.getInstance();
		Date currentTime = calendar.getTime();
		calendar.setTime(order.getCreateTime());
		calendar.add(Calendar.MINUTE, timeInMinutes);
		Date expectedTime = calendar.getTime();
		long diffTime = expectedTime.getTime() - currentTime.getTime();
		return (int) diffTime / (60 * 1000);
	}

}

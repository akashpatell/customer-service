package com.akash.customerservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.customerservice.dto.OrderDto;
import com.akash.customerservice.entity.OrderSummary;
import com.akash.customerservice.service.CustomerOrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customers/{customerId}")
@Slf4j
public class CustomerOrderController {

	@Autowired
	private CustomerOrderService orderService;

	@PostMapping("/placeorder")
	public ResponseEntity<OrderSummary> placeOrder(@Valid @RequestBody OrderDto orderDto,
			@PathVariable String customerId) {

		log.info("In placeOrder for customer {}", customerId);
		return ResponseEntity.ok(orderService.placeOrder(orderDto, customerId));
	}

	@GetMapping("/ordersummary/{orderId}")
	public ResponseEntity<OrderSummary> getOrderStatus(@PathVariable String customerId, @PathVariable String orderId) {

		log.info("In getOrderStatus for customer {}", customerId);
		return ResponseEntity.ok(orderService.getOrderStatus(customerId, orderId));
	}

}

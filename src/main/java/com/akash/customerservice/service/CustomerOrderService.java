package com.akash.customerservice.service;

import com.akash.customerservice.dto.OrderDto;
import com.akash.customerservice.entity.OrderSummary;

public interface CustomerOrderService {

	OrderSummary placeOrder(OrderDto orderDto, String customerId);

	OrderSummary getOrderStatus(String customerId, String orderId);

}

package com.akash.customerservice.service;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akash.customerservice.config.ServiceProperty;
import com.akash.customerservice.dto.OrderDto;
import com.akash.customerservice.entity.Customer;
import com.akash.customerservice.entity.MenuItem;
import com.akash.customerservice.entity.Order;
import com.akash.customerservice.entity.OrderSummary;
import com.akash.customerservice.enums.OrderStatus;
import com.akash.customerservice.exception.CustomerServiceException;
import com.akash.customerservice.repository.CustomerRepository;
import com.akash.customerservice.repository.MenuItemRepository;
import com.akash.customerservice.repository.OrderSummaryRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author AKASH PATEL
 *
 */
@Service
@Slf4j
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private ServiceProperty serviceProperty;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private MenuItemRepository menuItemRepository;

	@Autowired
	private OrderSummaryRepository orderSummaryRepository;

	/**
	 * 
	 */
	@Override
	@Transactional
	public OrderSummary placeOrder(OrderDto orderDto, String customerId) {

		Customer customer = fetchCustomer(customerId);

		MenuItem menuItem = fetchMenuItem(orderDto);

		Order order = new Order(UUID.randomUUID().toString(), menuItem, orderDto.getQuantity(),
				orderDto.getQuantity() * menuItem.getPrice());

		OrderSummary orderSummary = new OrderSummary(UUID.randomUUID().toString(), customer, order, OrderStatus.PLACED,
				"order placed succesfully in coffeshop[" + orderDto.getShopId() + "]");

		orderSummary = orderSummaryRepository.save(orderSummary);

		sendToQueue(orderSummary);

		return orderSummary;
	}

	/**
	 * @param orderSummary
	 */
	private void sendToQueue(OrderSummary orderSummary) {

		rabbitTemplate.convertAndSend(serviceProperty.getCoffeeShopMQExchange(),
				serviceProperty.getCoffeeShopMQRoutingKey(), orderSummary);

		log.info("Order placed & Produce to queue {}", orderSummary);
	}

	/**
	 * @param customerId
	 * @return
	 */
	private Customer fetchCustomer(String customerId) {

		return customerRepository.findById(customerId).orElseThrow(() -> {
			log.error("Customer Not found");
			return new CustomerServiceException("Customer Not found", HttpStatus.NOT_FOUND);
		});
	}

	/**
	 * @param orderDto
	 * @return
	 */
	private MenuItem fetchMenuItem(OrderDto orderDto) {

		return menuItemRepository.findByItemIdAndCoffeeShopId(orderDto.getMenuItemId(), orderDto.getShopId())
				.orElseThrow(() -> {
					log.error("MenuItem Not found");
					return new CustomerServiceException("MenuItem Not found", HttpStatus.NOT_FOUND);
				});
	}

	@Override
	public OrderSummary getOrderStatus(String customerId, String orderId) {

		return orderSummaryRepository.findByCustomerIdAndOrderOrderId(customerId, orderId).orElseThrow(() -> {
			log.error("Order Not found");
			return new CustomerServiceException("Order Not found", HttpStatus.NOT_FOUND);
		});
	}

}

package com.akash.customerservice.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.akash.customerservice.constant.ServiceConstant;
import com.akash.customerservice.entity.OrderSummary;

/**
 * An OrderSummaryConsumer for listening the queue for every orders which are
 * placed
 * 
 * @author AKASH PATEL
 *
 */
@Component
public class OrderSummaryConsumer {

	@RabbitListener(queues = ServiceConstant.COFFEESHOP_MESSAGING_QUEUE)
	public void consumeMessageFromQueue(OrderSummary orderSummary) {
		System.out.println("Order Summary recieved from queue : " + orderSummary);
	}
}

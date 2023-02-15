package com.akash.customerservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Component
@Getter
@NoArgsConstructor
public class ServiceProperty {

	@Value("${coffeeshop1.queue}")
	private String coffeeShopMQueue;

	@Value("${coffeeshop1.exchange}")
	private String coffeeShopMQExchange;

	@Value("${coffeeshop1.routingkey}")
	private String coffeeShopMQRoutingKey;

}

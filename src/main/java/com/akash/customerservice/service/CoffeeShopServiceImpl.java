package com.akash.customerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.customerservice.entity.CoffeeShop;
import com.akash.customerservice.repository.CoffeeShopRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * An Implementation of {@link CoffeeShopService}
 * 
 * @author AKASH PATEL
 *
 */
@Service
@Slf4j
public class CoffeeShopServiceImpl implements CoffeeShopService {

	@Autowired
	private CoffeeShopRepository coffeeShopRepository;

	/**
	 * Get All Coffee Shops
	 */
	@Override
	public List<CoffeeShop> getAllCoffeeShops() {
		log.info("Loading all coffeeshops");
		return coffeeShopRepository.findAll();
	}

}

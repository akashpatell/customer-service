package com.akash.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.customerservice.entity.CoffeeShop;
import com.akash.customerservice.service.CoffeeShopService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/coffeeshops")
@Slf4j
public class CoffeeShopController {

	@Autowired
	private CoffeeShopService coffeeShopService;

	@GetMapping()
	public ResponseEntity<List<CoffeeShop>> getAllCoffeeShops() {

		log.info("In getAllCoffeeShops");
		return ResponseEntity.ok(coffeeShopService.getAllCoffeeShops());
	}

}

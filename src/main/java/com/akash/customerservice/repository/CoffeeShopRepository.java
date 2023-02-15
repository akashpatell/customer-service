package com.akash.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash.customerservice.entity.CoffeeShop;

@Repository
public interface CoffeeShopRepository extends JpaRepository<CoffeeShop, String> {

}

package com.akash.customerservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash.customerservice.entity.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, String> {

	@EntityGraph(attributePaths = { "coffeeShop" })
	Optional<MenuItem> findByItemIdAndCoffeeShopId(String menuItemId, String shopId);

}

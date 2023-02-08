package com.akash.customerservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash.customerservice.entity.OrderSummary;

@Repository
public interface OrderSummaryRepository extends JpaRepository<OrderSummary, String> {

	Optional<OrderSummary> findByCustomerIdAndOrderOrderId(String customerId, String orderId);

}

package com.akash.customerservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.akash.customerservice.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_summary")
public class OrderSummary {

	@Id
	private String id;

	@OneToOne(fetch = FetchType.EAGER)
	private Customer customer;

	@OneToOne(cascade = CascadeType.ALL)
	private Order order;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	private String message;

}
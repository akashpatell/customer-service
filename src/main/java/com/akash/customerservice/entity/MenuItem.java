package com.akash.customerservice.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu_items")
public class MenuItem {

	@Id
	private String itemId;

	private String foodName;

	private Double price;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	private CoffeeShop coffeeShop;
}

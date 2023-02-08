package com.akash.customerservice.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coffee_shops")
public class CoffeeShop {

	@Id
	private String id;
	private String shopName;
	private String shopAddress;
	private Integer zipCode;
	@JsonManagedReference
	@OneToMany(mappedBy = "coffeeShop", fetch = FetchType.LAZY)
	private List<MenuItem> menuItems;

	@Override
	public String toString() {
		return "CoffeeShop [id=" + id + ", shopName=" + shopName + ", shopAddress=" + shopAddress + ", zipCode="
				+ zipCode + "]";
	}

}

package com.akash.customerservice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

	@NotBlank(message = "shopId must not be blank")
	private String shopId;
	
	@NotBlank(message = "menuItemId must not be blank")
	private String menuItemId;
	
	@NotNull(message = "quantity must not be zero")
	private Integer quantity;

}

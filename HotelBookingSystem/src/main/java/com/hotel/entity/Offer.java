package com.hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Offer {

	@Id
	private Integer oId;
	
	@Size(max = 10)
	private String coupon;
	
}

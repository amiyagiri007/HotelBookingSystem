package com.hotel.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class wishList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer wishId;
	
	private List<Hotel> hotel;
}

package com.hotel.entity;


import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name  = "room")
public class Room  implements Serializable{
	
	@ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "hotel_id")
	private Hotel hotel;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roomId;
	@NotEmpty
	private String roomName;
	@NotNull
	@Size(min = 1)
	private String maxGuest;
	@NotNull
	private Double price;
//	private List<String> listOfPhotos;
	@NotEmpty
	private String description;
}

package com.hotel.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table( name ="hotel")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
private Integer hotelId;
	@NotEmpty
private String hotelName;
private String hotelPhotos;
private List<Room> listOfRoom;
@NotNull
private Date checkIn;
@NotNull
private Date checkOut;
@Size(min = 1)
private Integer adultNo;
private Integer childrenNo;
@Digits(integer = 10, fraction = 0, message = "The value must be numbers only")
@NotNull
private String phoneNo;
@NotNull
private String address;
@Email
@Column(unique = true , nullable = false)
private String email;

}

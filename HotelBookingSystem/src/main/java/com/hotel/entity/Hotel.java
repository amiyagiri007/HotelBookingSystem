package com.hotel.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "hotel")
@EnableTransactionManagement
public class Hotel  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hotelId;
	@NotEmpty
	private String hotelName;
	
	private String hotelBackgroundPhotos;
	
	@ElementCollection(fetch = FetchType.LAZY)
	private List<String> carouselPhtos;
	
	@CreationTimestamp
	private LocalDate registerDate;
	
	@NotEmpty
	@Size(max = 30)
	private String ownerName;
	
	@OneToOne
	private Address  address;
	
	@NotEmpty(message = "Enter description of hotel")
	private String hotelDesc;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Room> listOfRoom;

	@NotNull
	@Min(10)
	@Max(300)
	private Integer totalRoomCapacity;
	
	@NotEmpty
	private String hotelVideo;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private Map<String, String> socials;

	
	private String hotelType;
}

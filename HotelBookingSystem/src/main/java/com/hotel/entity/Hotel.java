package com.hotel.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

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
@Table(name = "hotel")
@EnableTransactionManagement
public class Hotel  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hotelId;
	@NotEmpty
	private String hotelName;
	private String hotelPhotos;

//	@OneToM/any(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hotel")
	//@JoinColumn(name = "hotelId", referencedColumnName = "rid")
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Room> listOfRoom;

    @CreationTimestamp
	@NotNull
	private Date checkIn;
	@NotNull
	@UpdateTimestamp
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
	@Column(unique = true, nullable = false)
	private String email;

}

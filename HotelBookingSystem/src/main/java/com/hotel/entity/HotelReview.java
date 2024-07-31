package com.hotel.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Data
public class HotelReview  implements Serializable{

	@Id
	private Integer roomId;
	@NotEmpty
	@Size(max = 100)
	private String reviewDesc;
	@NotNull
//	@Min(value = 1)
//	@Max(value = 5)
//	@Digits(integer = 1, fraction = 1)
	private Float roomRating;
	@DateTimeFormat
	private LocalDate reviewDate;
	
	
	//need to add some more column
	
}

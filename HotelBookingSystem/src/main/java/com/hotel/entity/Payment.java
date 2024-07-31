package com.hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Payment {

	@Id
	private Integer pId;
	
	@Digits(integer = 16,  fraction = 0  ,message = "Invalid card no")
	@NotNull
	private String cardNo;
	
	@NotEmpty(message = "Enter Card holder name")
	@Size(max = 30)
	private String cardHolderName;
	@Digits(integer = 3 , fraction = 0, message = "Invalid cvv")
	@NotNull
	private Integer CVV;
	
	@NotEmpty(message = "Invalid expire date")
	private String expDate;
	
//	private String modeOfPayment;
	
	
	
}

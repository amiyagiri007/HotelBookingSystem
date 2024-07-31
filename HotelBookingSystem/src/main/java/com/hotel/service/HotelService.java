package com.hotel.service;

import java.util.List;

import com.hotel.entity.Booking;

public interface HotelService {
	
	Booking confirmBooking(Booking booking);
	
	Booking getBookingById(Integer id);
	
	List<Booking> getBookingsByUserId(Integer userId);
	
	List<Booking> getBookingByHotelId(Integer hotelId);
	
	Booking cancelBooking(Integer id);
	
}

package com.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	List<Booking> findByUser_UserId(Integer userId);
	List<Booking> findByHotel_Id(Integer Id);
	
}

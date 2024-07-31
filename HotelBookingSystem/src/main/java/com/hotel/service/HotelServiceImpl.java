package com.hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Booking;
import com.hotel.entity.Hotel;
import com.hotel.entity.Room;
import com.hotel.entity.User;
import com.hotel.repository.BookingRepository;
import com.hotel.repository.HotelRepository;
import com.hotel.repository.RoomRepository;
import com.hotel.repository.UserRepository;

@Service
public class HotelServiceImpl  implements HotelService{
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoomRepository roomRepository;

	@Override
	public Booking confirmBooking(Booking booking) {

		Optional<User> userOptional = userRepository.findById(booking.getUser().getUserId());
		
		Optional <Hotel> hotelOptional = hotelRepository.findById(booking.getHotel().getId());
		
		Optional <Room> roomOptional = roomRepository.findById(booking.getRoom().getRoomId());
		
		if(userOptional.isPresent()  && hotelOptional.isPresent()  && roomOptional.isPresent()) {
			
			Booking confirmedBooking  = new Booking();
			
			confirmedBooking .setUser(userOptional.get());
			confirmedBooking .setHotel(hotelOptional.get());
			confirmedBooking .setRoom(roomOptional.get());
			
			confirmedBooking.setStatus("CONFIRMED");
			
			return bookingRepository.save(confirmedBooking);
		}
		throw new IllegalArgumentException("User , Hotel  or Room not found");
		
	}

	@Override
	public Booking getBookingById(Integer id) {
		
		return bookingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Booking not found"));
	}
	

	@Override
	public List<Booking> getBookingsByUserId(Integer userId) {
		try {
			return bookingRepository.findByUser_UserId(userId);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	
	@Override
	public List<Booking> getBookingByHotelId(Integer hotelId) {
		try {
			return bookingRepository.findByHotel_Id(hotelId);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	
	@Override
	public Booking cancelBooking(Integer id) {
		Booking booking = getBookingById(id);
		booking.setStatus("CANCELLED");
		return bookingRepository.save(booking);
	}

}

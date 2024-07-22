package com.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hotel.entity.User;
import com.hotel.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void save(User user) {
		user.setUPassword(bCryptPasswordEncoder.encode(user.getUPassword()));
		userRepository.save(user);
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUName(username);
	}
	
}

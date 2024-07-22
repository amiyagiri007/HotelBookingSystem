package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hotel.entity.User;
import com.hotel.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void saveUser(User user) {
		String encodePassword=passwordEncoder.encode(user.getUserPassword());
		user.setUserPassword(encodePassword);
		userRepository.save(user);
				
//		user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
//		userRepository.save(user);
	}
	
	public User findByUsername(String uName) {
		return userRepository.findByUserName(uName);
	}
	
}
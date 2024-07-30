package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hotel.entity.Role;
import com.hotel.entity.User;
import com.hotel.repository.RoleRepository;
import com.hotel.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

//	register user
	public void registerUser(User user) {
		user.setUsername(user.getUsername());
		
		String encodePassword = passwordEncoder.encode(user.getPassword());
		user.setUserpassword(encodePassword);

		Role role = roleRepository.findByRoleName("USER").orElseThrow(() -> new RuntimeException("Role not found"));
		user.setRole(role);
		System.err.println("user is registter with username "+user.getUsername());
		userRepository.save(user);
	}

//	public User findByUsername(String uName) {
//		return userRepository.findByUserEmail(uName);
//	}

//	taking help loadUserByUsername for login
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    System.out.println("Attempting to load user with email: " + email);
	    User user = userRepository.findByUserEmail(email);
	    if (user == null) {
	        System.err.println("User not found with email: " + email);
	        throw new UsernameNotFoundException("User not found with email: " + email);
	    }
	    System.out.println("User found: " + user.getUserEmail());
	    return org.springframework.security.core.userdetails.User
                .withUsername(user.getUserEmail())
                .password(user.getPassword())
                .roles(user.getRole().getRoleName())
                .build();
	}

	//	login user
	public  void loginUser(String email) {
		System.err.println("loginUser method");
		loadUserByUsername(email);
		
	}

}
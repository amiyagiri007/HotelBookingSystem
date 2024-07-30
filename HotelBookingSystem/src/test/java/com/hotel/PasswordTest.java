package com.hotel;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {

	public static void main(String[] args) {
BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        // Encode a password
        String rawPassword = "123";
        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println("Encoded Password: " + encodedPassword);
        
        // Check if a raw password matches the encoded password
        boolean matches = passwordEncoder.matches("321", encodedPassword);
        System.out.println("Password Matches: " + matches);

	}

}

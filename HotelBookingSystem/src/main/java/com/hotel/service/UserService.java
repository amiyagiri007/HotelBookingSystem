package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.RepositoryCreationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hotel.entity.User;
import com.hotel.repository.UserRepository;


@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public void saveUser(User user)  throws Exception{
		/*UserBO bo = new UserBO();
		bo.setUsername(userDTO.getUsername());
		bo.setUserEmail(userDTO.getUserEmail());
		bo.setUserpassword(userDTO.getUserpassword());*/
		
		try {
			String encodePassword=passwordEncoder.encode(user.getPassword());
			user.setUserpassword(encodePassword);
		}catch( SecurityException se) {
			System.out.println("UserService.saveUser()");
			se.printStackTrace();
			throw se;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		try {
			userRepository.save(user);
		}catch(RepositoryCreationException re) {
			re.printStackTrace();
			throw re;
		}
		
		
	}
	public User findByUsername(String uName) throws Exception {
		return userRepository.findByusername(uName);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByusername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return  null;
	}
	
}
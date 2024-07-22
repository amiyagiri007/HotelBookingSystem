package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entity.User;
import java.util.List;


@Repository
public interface UserRepository  extends JpaRepository<User,Integer>{
	User findByUserName(String userName);
	
//	findby is keyword + UserName is you variable name in entity class
}

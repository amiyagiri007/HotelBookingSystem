package com.hotel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
//	 Role findbyRoleName(String roleName);
	 Optional<Role> findByRoleName(String roleName);
}

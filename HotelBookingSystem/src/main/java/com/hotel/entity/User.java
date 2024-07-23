package com.hotel.entity;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;


@Entity
@Getter
@Setter
//@AllArgsConstructor
@Table(name = "user")
public class User implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@Email
	@Column(unique = true,nullable = false)
	private String userEmail;

	@Column(unique = true)
	@Size(min = 4, max = 30)
    @Setter( AccessLevel.NONE)
	@Getter( AccessLevel.NONE)
	private String username;

	@Column(nullable  = true)
	@Size(min = 6)
<<<<<<< HEAD
	private String userPassword;

=======
	private String userpassword;
	
>>>>>>> e1376339b397681ad23dcec53e1f09aa9ea1d394
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userEmail=" + userEmail
				+ ", username=" + username + ", userpassword=" + userpassword
				+ "]";
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

	@Override
	public String getPassword() {
		return userpassword;
	}

	@Override
	public String getUsername() {
		return username;
	}

}

package com.hotel.configurataion;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.CsrfDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

	@Bean
	 UserDetailsService userDetailsService() {
		UserDetails user = User.builder().username("user")
				.password(passwordEncoder().encode("password")).roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}

    @Bean
    PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @SuppressWarnings("removal")
	@Bean
     SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                                .requestMatchers("/index", "/registerform", "/loginform", "/user/**", "/**").permitAll()
                                .anyRequest().authenticated()
                )
//        .formLogin(form -> form
//            .loginPage("/login")
//            .defaultSuccessUrl("/")
//            .permitAll()
//        )
                .logout(logout -> logout
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/login?logout")
                                .permitAll()
                );
        
        
//        .authorizeHttpRequests(authz -> authz
//                .anyRequest().authenticated()
//            )
//            .formLogin(Customizer.withDefaults()) // Configures form login with default settings
//            .httpBasic(Customizer.withDefaults()); // Configures HTTP Basic authentication with default settings
        	
        return http.build();
    }
}
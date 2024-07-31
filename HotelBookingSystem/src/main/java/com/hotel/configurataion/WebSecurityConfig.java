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
	//Bean for decrypt/decipher password  
	@Bean
    PasswordEncoder passwordEncoder() {
	System.err.println("passwordEncoder is called");
    	return new BCryptPasswordEncoder();
	}
	
//	provide a security filter to handle incoming Http requests
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz																							// user to restricts based on role/without role.
                .requestMatchers("/", "/home", "/register_form","/register_process", "/login_form","/perform_login","/view/login.jsp","/view/index.jsp","/view/register.jsp","/view/**/*.jsp","/forgot").permitAll()				// Allowing home and form handler to access to anyone.
                .requestMatchers("/assets/**","/images/**","/css/**","/js/**","/fonts/**","/webfonts/**").permitAll()						// Allowing my assets and resources to access to anyone.
                .requestMatchers("/perform_logout").authenticated()																					// Only authenticated user can access the logout
                .anyRequest().authenticated()																								// Other handlers/resources to be authenticated.
            )
            .formLogin(form -> form												// Configures form-based authentication.
                .loginPage("/login_form")										// Custom login page URL. Spring Security will redirect to this page when authentication is required.
                	.loginProcessingUrl("/perform_login")							// Sets the URL to which the login form should be submitted. This is where Spring Security will process the login attempt.
                	.usernameParameter("userEmail")									// Configures the name of the username parameter in the login form.
                	.passwordParameter("userpassword")								// Sets the name of the password parameter in the login form to "userpassword".
                	.defaultSuccessUrl("/home", false)								// file available for more details in static folder with name of 'defaultSuccessUrl'
                	.failureUrl("/login_form?error=true")							// Defines where to redirect if the login fails, in this case back to the login form with an error parameter.
                .permitAll()													// Allows all users (authenticated or not) to access the login page and the login processing URL.
            )
            .logout(logout -> logout											// method begins the configuration of the logout functionality.
                .logoutUrl("/perform_logout")											// Specifies the URL that triggers the logout process. When a user sends a request to this URL, Spring Security will log them out. By default, this is a POST request for security reasons (to prevent CSRF attacks).
                .logoutSuccessUrl("/login_form?logout=true")					// Sets the URL where users are redirected after successfully logging out.In this case, it redirects to the login form with a parameter indicating a successful logout. This can be useful for displaying a "You have been logged out" message on the login page.
                .invalidateHttpSession(true)
                .clearAuthentication(true)										// The Authentication object in the SecurityContext is set to null.This ensures that all traces of the user's authentication are removed from the security context.
                .deleteCookies("JSESSIONID")									// This method is used to specify which cookies should be deleted when a user logs out. 'JSESSIONID' the default session cookie in Java web applications. Deleting it helps ensure that the server-side session is truly terminated. This prevents session fixation attacks and enhances security.
//                .permitAll()
                
            )
            .csrf(csrf -> csrf.disable());  // Only disable if necessary
        System.err.println("SecurityFilterChain is called");
        return http.build();
    }
}

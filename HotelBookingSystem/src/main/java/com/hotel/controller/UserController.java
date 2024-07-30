package com.hotel.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.entity.User;
import com.hotel.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private ModelAndView mav;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/register_form")
	public String showSignUpForm() {
		System.err.println("Register form is called");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()
				&& !(authentication.getPrincipal() instanceof String)) {
			return "redirect:/home";
		}
		return "register";
	}

	@PostMapping("/register_process")
	public String signUpUser(@ModelAttribute User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getUserEmail());
		System.out.println(user.getPassword());
		System.err.println("registerform is ran");
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()
				&& !(authentication.getPrincipal() instanceof String)) {
			return "redirect:/home";
		}
		userService.registerUser(user);
		return "redirect:/login_form";

//		mav.addObject("userToken", "936932132969");

	}

	@GetMapping("/login_form")
	public String showSignIn() {
		System.err.println("showSignIn method and /login_form handler");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()
				&& !(authentication.getPrincipal() instanceof String)) {
			return "redirect:/home";
		}
		return "login";
	}

	@PostMapping("/perform_login")
	public String signInUser(@ModelAttribute User user) {
		System.err.println("signInUser method and /perform_login handler");
		System.err.println(user.getUserEmail());
		System.err.println(user.getPassword());

		try {
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user.getUserEmail(),
					user.getPassword());
			Authentication authentication = authenticationManager.authenticate(authToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);

			userService.loadUserByUsername(user.getUserEmail());
			return "redirect:/home";
		} catch (AuthenticationException e) {
			return "redirect:/login_form?error=true";
		}

//		return "home";

	}

	@GetMapping("/")
	public String indexPage() {
		System.out.println("HomeController.indexPage()");
		return "index";
	}

	@GetMapping("/home")
	public String homePage() {
		System.out.println("HomeController.homePage()");
		return "index";
	}
	
	@GetMapping("/forgot")
	public String forgotPasswordPage() {
		return "forgot-password";
	}
	
//	logout
	
	@GetMapping("/perform_logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("/home");
    }
	
}
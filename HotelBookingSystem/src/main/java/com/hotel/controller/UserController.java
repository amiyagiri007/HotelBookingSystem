
package com.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.entity.User;
import com.hotel.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	/* @GetMapping("/")
	    public String showRegistrationForm() {
	        return "index";
	    }*/
	
	/*	@GetMapping("/registerform")
		public ModelAndView handleRegistration(@ModelAttribute User user) {
			System.out.println("UserController.handleRegistration()");
			System.out.println("Name: "+user.getUserName());
			return new ModelAndView("redirect:/");
		}*/
	
	
}

package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.entity.User;

@Controller
public class HomeController {
	@GetMapping("/")
	public String indexPage() {
		System.out.println("HomeController.indexPage()");
		return "index";
	}
	
	@GetMapping("/registerform")
	public ModelAndView handleRegistration(@ModelAttribute User user) {
		System.out.println("UserController.handleRegistration()");
		System.out.println("Name: "+user.getUsername());
		return new ModelAndView("redirect:/");
	}
	
}

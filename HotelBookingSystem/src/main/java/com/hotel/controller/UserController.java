package com.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.hotel.entity.User;
import com.hotel.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelAndView mav;
	
	@GetMapping("/")
	public String getIndexPage() {
		return "index";
	}
	@PostMapping("/registerform")
	public ModelAndView showSignUpForm(@ModelAttribute User user) throws Exception {
		
		System.out.println(user.getUsername());
		System.out.println(user.getUserEmail());
		
		try {
			userService.saveUser(user);
			mav.setViewName("about");
			return mav;
		}catch(ModelAndViewDefiningException mave) {
			mave.printStackTrace();
			throw mave;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
	}
	//for sign-up 
	public String showSignupForm(Model model) {
		model.addAttribute("user", new User());
		return "index";
	}
	
	
	@PostMapping("/form")
	public ModelAndView showSignUpForm() {
		mav.setViewName("about");
		System.err.println("form is ran");
		return mav;
		
	}
	
	
}





package com.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.entity.User;
import com.hotel.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private ModelAndView mav;
	
	@PostMapping("/registerform")
	public ModelAndView showSignUpForm(@ModelAttribute User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getUserEmail());
		System.out.println(user.getPassword());
		userService.saveUser(user);
		mav.addObject("userToken","936932132969");
		mav.setViewName("about");
		System.err.println("registerform is ran");
		return mav;
		
	}
	
	@PostMapping("/form")
	public ModelAndView showSignUpForm() {
		mav.setViewName("about");
		System.err.println("form is ran");
		return mav;
		
	}
}
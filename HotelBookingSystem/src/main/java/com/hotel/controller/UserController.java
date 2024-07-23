
package com.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;
=======
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> e1376339b397681ad23dcec53e1f09aa9ea1d394
import org.springframework.web.servlet.ModelAndView;

import com.hotel.entity.User;
import com.hotel.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
<<<<<<< HEAD
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
=======
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
>>>>>>> e1376339b397681ad23dcec53e1f09aa9ea1d394

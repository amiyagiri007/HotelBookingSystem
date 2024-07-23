package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String indexPage() {
		System.out.println("HomeController.indexPage()");
		return "index";
	}
	
	@PostMapping("/hello")
	public String helloPage() {
		System.out.println("HomeController.helloPage()");
		return "about";
	}
	
	@GetMapping("/zpage")
	public String ZPage() {
		System.out.println("HomeController.ZPage()");
		return "ztemp";
	}
	
}

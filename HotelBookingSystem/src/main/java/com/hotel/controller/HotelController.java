package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HotelController {
	
	@GetMapping("/index")
	public String indexPage() {
		System.out.println("HotelController.indexPage()");
		return "index.html";
	}
	@GetMapping("/hello")
	public String boilerPlate() {
		return "boilerPlate2";
	}

}

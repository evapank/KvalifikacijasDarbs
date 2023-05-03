package com.siite.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("")
	public String getDefault() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String getHomePage() {
	return "home";
	}

}

package com.siite.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import com.siite.demo.models.MyUser;
import com.siite.demo.services.IMyUserCRUDservice;

import jakarta.validation.Valid;
/*
@Controller
public class AuthorisationController {

	@Autowired
	private IMyUserCRUDservice userService;

	@GetMapping("/register")
	public String getRegister(WebRequest request, Model model) {
		
		MyUser user = new MyUser();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
		model.addAttribute("user", user);
		
		return "registration";
	}

	@PostMapping("/register")
	public String postRegister(@Valid MyUser user, BindingResult result) {
		
		if (result.hasErrors()) {
			return "registration";
		} else {
			userService.insertNewUser(user);
			return "userprofile/user-profile";
		}
	}

	@PostMapping("/home")
	public String getLogin(@Valid MyUser user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    System.out.println("lietotāja profils");
	    System.out.println(user);
		return "redirect:/user/{id}";

	}
	
}*/
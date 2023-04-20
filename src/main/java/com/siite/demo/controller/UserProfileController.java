package com.siite.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.siite.demo.models.MyUser;
import com.siite.demo.services.IMyUserCRUDservice;
import com.siite.demo.services.IMyWebsiteCRUDservice;

@Controller
public class UserProfileController {
	
	@Autowired
	private IMyUserCRUDservice userService;
	
	@Autowired
	private IMyWebsiteCRUDservice websiteService;
	
	@GetMapping("/user/{id}")
	public String getUserWebsites(Model model, MyUser user, @PathVariable(name = "id") int id) {
		try {
			model.addAttribute("user", userService.readUserById(id));
			model.addAttribute("website", websiteService.getUserWebsitesbyUserId(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "userprofile/user-profile";
	}

}

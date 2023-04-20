package com.siite.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.siite.demo.services.IMyUserCRUDservice;
import com.siite.demo.services.IMyWebsiteCRUDservice;

@Controller
public class UserProfileController {
	
	@Autowired
	private IMyUserCRUDservice userService;
	
	@Autowired
	private IMyWebsiteCRUDservice websiteService;
	
	public String getUserWebsites() {
		
		return "user-profile/user-profile";
	}

}

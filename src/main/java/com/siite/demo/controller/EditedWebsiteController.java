package com.siite.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.siite.demo.services.IMyWebsiteCRUDservice;

@Controller
public class EditedWebsiteController {
	
	@Autowired
	private IMyWebsiteCRUDservice websiteService;
	
	@GetMapping("/user/{userId}/website/delete/{websiteId}")
	public String getDeleteWebsite(Model model,@PathVariable(name = "userId") int userId,
			@PathVariable(name = "websiteId") int id) {
		model.addAttribute("website", websiteService.deleteWebsiteById(id));
		return "redirect:/user/{userId}";
	}

}

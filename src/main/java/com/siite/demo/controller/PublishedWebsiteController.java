package com.siite.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siite.demo.services.IMyWebsiteCRUDservice;

@Controller
@RequestMapping("/website/published")
public class PublishedWebsiteController {
	
	@Autowired
	private IMyWebsiteCRUDservice websiteService;
	
	@GetMapping("/{id}")
	public String getPublishedWebsite(Model model, @PathVariable(name = "id") int id) {
		if(websiteService.publishWebsiteById(id)) {
			return "website/website-published";
		}
		return "error";
	}

}

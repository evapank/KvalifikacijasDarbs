package com.siite.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siite.demo.models.MyWebsite;
import com.siite.demo.services.IMyWebsiteCRUDservice;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class EditedWebsiteController {
	
	@Autowired
	private IMyWebsiteCRUDservice websiteService;
	
	@GetMapping("/website/create")
	public String getCreateWebsite(Model model, MyWebsite website) {
		
		model.addAttribute("website", websiteService.insertNewWebsite(website));
		return "website/website-create";
	}
	
	@PostMapping("/website/create")
	public String postCreateWebsite(@Valid MyWebsite website, BindingResult result) {
		
		if(!result.hasErrors()) {
			return "website/website-create";
		} else {
			return "redirect:/{userId}/website/edit";
		}
	}
	
	@GetMapping("/website/edit/{websiteId}")
	public String getEditWebsite(Model model, MyWebsite website, @PathVariable(name = "websiteId") int websiteId) throws Exception {
		
		try {
			model.addAttribute("website", websiteService.readWebsiteById(websiteId));
			return "website/website-edit";
		} catch (Exception e) {
			throw new Exception("can't find website");
		}
	}
	
	@PostMapping("/website/edit/{websiteId}")
	public String postEditWebsite(MyWebsite website, @PathVariable(name = "websiteId") int websiteId, BindingResult result) throws Exception {
		
		if(!result.hasErrors()) {
			if(!websiteService.updateWebsiteById(websiteId, website)) {
				throw new Exception("can't update website");
			}
		}
		return "website/website-edit";
	}
	
	@GetMapping("/website/delete/{websiteId}")
	public String getDeleteWebsite(Model model,@PathVariable(name = "userId") int userId,
			@PathVariable(name = "websiteId") int websiteId) {
		
		model.addAttribute("website", websiteService.deleteWebsiteById(websiteId));
		return "redirect:/user/{userId}";
	}
	
	

}

package com.siite.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siite.demo.enums.TemplateEnum;
import com.siite.demo.models.MyWebsite;
import com.siite.demo.services.IMyWebsiteCRUDservice;

@Controller
@RequestMapping("/website/published")
public class PublishedWebsiteController {
	
	@Autowired
	private IMyWebsiteCRUDservice websiteService;
	
	private TemplateEnum template;
	
	@GetMapping("/{id}")
	public String getPublishedWebsite(Model model, @PathVariable(name = "id") int id) throws Exception {
		
		if(websiteService.publishWebsiteById(id)) {
			
			MyWebsite website = websiteService.readWebsiteById(id);
			model.addAttribute("website", website);
			
			template = website.getTemplate();
			
			switch(template) {
			case Light:
				return "website/templateEnums/layout-light";
			case Dark:
				return "website/templateEnums/layout-dark";
			case Green:
				return "website/templateEnums/layout-green";
			default:
				return "error";
			}
		}
		throw new Exception("can't find published website");
	}

}

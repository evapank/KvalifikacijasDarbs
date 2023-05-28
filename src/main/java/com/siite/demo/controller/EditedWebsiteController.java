package com.siite.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siite.demo.models.MyWebsite;
import com.siite.demo.services.IMyWebsiteCRUDservice;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/website")
public class EditedWebsiteController {
	
	@Autowired
	private IMyWebsiteCRUDservice websiteService;
	
	@GetMapping("/create")
	public String getCreateWebsite(Model model, MyWebsite website) {
		model.addAttribute("website", new MyWebsite());
		return "website/website-create";
	}
	
	@PostMapping("/save")
	public String postCreateWebsite(@Valid @ModelAttribute(value="website") MyWebsite website, BindingResult result){
		
		if(result.hasErrors()) {
			return "website/website-create";
		} else {
			websiteService.insertNewWebsite(website);
			int websiteId = website.getIdWeb();
			System.out.println("Insterted website " + websiteService.insertNewWebsite(website));
			System.out.println("CREATED WEBSITE ID: "+ websiteId);
			return "redirect:/website/edit/" + websiteId;
		}
	}
	
	@GetMapping("/edit/{id}")
	public String getEditWebsite(Model model, @PathVariable(name = "id") int id) throws Exception {
		
		try {
			model.addAttribute("website", websiteService.readWebsiteById(id));
			return "website/website-edit";
		} catch (Exception e) {
			throw new Exception("can't find website");
		}
	}
	
	@PostMapping("/edit/{id}")
	public String postEditWebsite(MyWebsite website, @PathVariable(name = "id") int id, BindingResult result) throws Exception {
		
		if(!result.hasErrors()) {
			if(!websiteService.updateWebsiteById(id, website)) {
				throw new Exception("can't update website");
			}
		}
		return "website/website-edit";
	}
	
	@GetMapping("/delete/{id}")
	public String getDeleteWebsite(Model model, @PathVariable(name = "id") int id) throws Exception {
		
		try {
			int ownerId = websiteService.getOwnerIdByWebsiteId(id);
			model.addAttribute("website", websiteService.deleteWebsiteById(id));
			return "redirect:/user/" + ownerId;
		} catch (Exception e) {
			throw new Exception("can't find owner");
		}
	}
	
	@GetMapping("/publish/{id}")
	public String getPublishWebsite(@PathVariable(name = "id") int id) throws Exception {
	
			if(websiteService.publishWebsiteById(id)) {
				return "redirect:/edit/" + id;
			} else {
				throw new Exception("can't publish website");
			}
	}
	
	@GetMapping("/unpublish/{id}")
	public String getUnpublishWebsite( @PathVariable(name = "id") int id) throws Exception{
		
		if(websiteService.unpublishWebsiteById(id)) {
			return "redirect:/edit/" + id;
		} else {
			throw new Exception("can't unpublish website");
		}
	}
	
}

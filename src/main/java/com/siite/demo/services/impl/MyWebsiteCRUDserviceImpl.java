package com.siite.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.siite.demo.models.MyWebsite;
import com.siite.demo.repos.IMyUserRepo;
import com.siite.demo.repos.IMyWebsiteRepo;
import com.siite.demo.services.IMyWebsiteCRUDservice;

public class MyWebsiteCRUDserviceImpl implements IMyWebsiteCRUDservice{
	
	@Autowired
	private IMyWebsiteRepo websiteRepo;
	
	@Autowired
	private IMyUserRepo userRepo;

	@Override
	public boolean insertNewWebsite(MyWebsite website) {
		if(websiteRepo.existsById(website.getIdWeb())) {
			return false;
		} else {
			websiteRepo.save(website);
			return true;
		}
	}

	@Override
	public boolean deleteWebsiteById(int websiteId) {
		if(websiteRepo.existsById(websiteId)) {
			MyWebsite result = websiteRepo.findByIdWeb(websiteId);
			websiteRepo.delete(result);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateWebsiteById(int websiteId, MyWebsite website) {
		
		MyWebsite result = new MyWebsite();
		
		if(websiteRepo.existsById(websiteId)) {
			
			result = websiteRepo.findByIdWeb(websiteId);
			
			result.setTitle(website.getTitle());
			result.setHeading(website.getHeading());
			result.setParagraph(website.getParagraph());
			result.setTemplate(website.getTemplate());
			result.setOwner(website.getOwner());
			
			websiteRepo.save(result);
			
			return true;
		}
		return false;
	}

	@Override
	public MyWebsite readWebsiteById(int websiteId) throws Exception {
		
		if(websiteRepo.existsById(websiteId)) {
			MyWebsite website = websiteRepo.findByIdWeb(websiteId);
			return website;
		}
		
		throw new Exception("Website doesn't exist");
	}
	
	

}
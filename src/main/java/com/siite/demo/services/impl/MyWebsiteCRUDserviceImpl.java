package com.siite.demo.services.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siite.demo.models.MyUser;
import com.siite.demo.models.MyWebsite;
import com.siite.demo.repos.IMyUserRepo;
import com.siite.demo.repos.IMyWebsiteRepo;
import com.siite.demo.services.IMyWebsiteCRUDservice;

@Service
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
			website.setPublished(false);
			
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
			result.setPublished(website.isPublished());
			
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
	
	@Override
	public ArrayList<MyWebsite> getUserWebsitesbyUserId(int userId){
		ArrayList<MyWebsite> userWebsites = new ArrayList<>();
		if (userRepo.existsById(userId)) {
			userWebsites =  websiteRepo.findByOwnerIdUser(userId);
		}
		return userWebsites;
	}

	@Override
	public int getOwnerIdByWebsiteId(int websiteId) throws Exception {
		
		if(websiteRepo.existsById(websiteId)) {
			MyWebsite website = websiteRepo.findByIdWeb(websiteId);
			MyUser owner = website.getOwner();
			
			return owner.getIdUser();
		}
		
		throw new Exception("website doesn't exist");
		
	}

	@Override
	public boolean publishWebsiteById(int websiteId) throws Exception {
		
		if(websiteRepo.existsById(websiteId)) {
			
			MyWebsite website = websiteRepo.findByIdWeb(websiteId);
			website.setPublished(true);
			
			websiteRepo.save(website);
			
			return true;
		}
		throw new Exception("website doesn't exist");
	}
	
	@Override
	public boolean unpublishWebsiteById(int websiteId) throws Exception{
		
		if(websiteRepo.existsById(websiteId)) {
			
			MyWebsite website = websiteRepo.findByIdWeb(websiteId);
			website.setPublished(false);
			
			websiteRepo.save(website);
			
			return true;
		}
		throw new Exception("website doesn't exist");
	}
	
	

}

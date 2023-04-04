package com.siite.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siite.demo.models.MyUser;
import com.siite.demo.models.MyWebsite;
import com.siite.demo.repos.IMyUserRepo;
import com.siite.demo.repos.IMyWebsiteRepo;
import com.siite.demo.services.IMyUserCRUDservice;

@Service
public class MyUserCRUDserviceImpl implements IMyUserCRUDservice {

	@Autowired
	private IMyUserRepo userRepo;

	@Autowired
	private IMyWebsiteRepo websiteRepo;

	@Override
	public boolean insertNewUser(MyUser user) {
		if (userRepo.existsByEmail(user.getEmail())) {
			return false;
		} else {
			userRepo.save(user);
			return true;
		}
	}

	@Override
	public boolean deleteUserById(int userId) {
		if (userRepo.existsById(userId)) {
			MyUser user = userRepo.findById(userId).get();
			ArrayList<MyWebsite> userWebsites = websiteRepo.findByOwnerIdUser(userId);
			
			for (MyWebsite website : userWebsites) {
				website.deleteOwner();
				websiteRepo.delete(website);
			}
			
			userRepo.deleteById(userId);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updateUserById(int userId, MyUser user) {
		
		MyUser result = new MyUser();
		
		if(userRepo.existsById(userId)) {
			result = userRepo.findById(userId).get();
			result.setUsername(user.getUsername());
			result.setEmail(user.getEmail());
			result.setPassword(user.getPassword());
			result.setAdmin(user.isAdmin());
			userRepo.save(result);
			return true;
		}
		return false;
	}

}

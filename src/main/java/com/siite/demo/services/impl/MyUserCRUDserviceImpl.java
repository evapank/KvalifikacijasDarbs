package com.siite.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siite.demo.models.MyUser;
import com.siite.demo.repos.IMyUserRepo;
import com.siite.demo.services.IMyUserCRUDservice;

@Service
public class MyUserCRUDserviceImpl implements IMyUserCRUDservice{
	
	@Autowired
	private IMyUserRepo userRepo;
	
	@Override
	public boolean insertNewUser(MyUser user) {
		if(userRepo.existsByEmail(user.getEmail())) {
			return false;
		} else {
			userRepo.save(user);
			return true;
		}
	}

}

package com.siite.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.siite.demo.models.MyUser;
import com.siite.demo.models.MyWebsite;
import com.siite.demo.repos.IMyUserRepo;
import com.siite.demo.repos.IMyWebsiteRepo;
import com.siite.demo.services.IMyUserCRUDservice;

@Service
public class MyUserCRUDserviceImpl implements IMyUserCRUDservice, UserDetailsService {

	@Autowired
	private IMyUserRepo userRepo;

	@Autowired
	private IMyWebsiteRepo websiteRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean insertNewUser(MyUser user) {
		if (userRepo.existsByEmail(user.getEmail())) {
			return false;
		} else {
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			userRepo.save(user);
			return true;
		}
	}

	@Override
	public boolean deleteUserById(int userId) {
		if (userRepo.existsById(userId)) {
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
			
			result = userRepo.findByIdUser(userId);
			
			result.setUsername(user.getUsername());
			result.setEmail(user.getEmail());
			result.setPassword(user.getPassword());
			result.setRole(user.getRole());
			
			userRepo.save(result);
			
			return true;
		}
		return false;
	}
	
	@Override
	public MyUser readUserById(int userId) throws Exception {
		
		if(userRepo.existsById(userId)) {
			MyUser user = userRepo.findByIdUser(userId);
			return user;
		}
		
		throw new Exception("User doesn't exist");
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return (UserDetails) userRepo.findByUsername(username).orElseThrow(
                ()-> new UsernameNotFoundException(
                        String.format("USER_NOT_FOUND", username)
                ));
	}

}

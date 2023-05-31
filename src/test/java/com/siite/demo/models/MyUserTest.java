package com.siite.demo.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.siite.demo.enums.RolesEnum;

class MyUserTest {
	
	MyUser userRight = new MyUser();
	MyWebsite website = new MyWebsite();
	
	ArrayList<MyWebsite> websiteList = new ArrayList<>();

	@Test
	void testSetter() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = encoder.encode("test123");
		
		websiteList.add(website);
		
		userRight.setPassword(password);
		userRight.setUsername("test");
		userRight.setEmail("email@email.com");
		userRight.setRole(RolesEnum.USER);
		userRight.setWebsites(websiteList);
		
		assertEquals(true, encoder.matches("test123", userRight.getPassword()));
		assertEquals("test", userRight.getUsername());
		assertEquals("email@email.com", userRight.getEmail());
		assertEquals(RolesEnum.USER, userRight.getRole());
		assertEquals(websiteList, userRight.getWebsites());
			
	}
	
	@Test
	void testArgsConstructor() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = encoder.encode("NEwPAssw123");
		
		MyUser newUser = new MyUser("UserName12", "gmail@inbox.lv", password, RolesEnum.ADMIN);
	
		assertEquals(true, encoder.matches("NEwPAssw123", newUser.getPassword()));
		assertEquals("UserName12", newUser.getUsername());
		assertEquals("gmail@inbox.lv", newUser.getEmail());
		assertEquals(RolesEnum.ADMIN, newUser.getRole());
	}

}

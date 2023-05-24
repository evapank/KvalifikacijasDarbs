package com.siite.demo.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class MyUserTest {
	
	MyUser userRight = new MyUser();

	@Test
	void test() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		
	}

}

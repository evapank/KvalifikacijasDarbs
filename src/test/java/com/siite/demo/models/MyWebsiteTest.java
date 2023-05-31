package com.siite.demo.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.siite.demo.enums.TemplateEnum;

class MyWebsiteTest {
	
	MyUser user = new MyUser();
	
	MyWebsite websiteRight = new MyWebsite("newTitle", "My web application", 
											"This is a paragraph.", TemplateEnum.Dark,
											false, user);

	@Test
	void testArgsContructor() {
		assertEquals("newTitle", websiteRight.getTitle());
		assertEquals("My web application", websiteRight.getHeading());
		assertEquals("This is a paragraph.", websiteRight.getParagraph());
		assertEquals(TemplateEnum.Dark, websiteRight.getTemplate());
		assertEquals(false, websiteRight.isPublished());
		assertEquals(user, websiteRight.getOwner());
	}
	
	@Test
	void testSetter() {
		MyWebsite newWebsite = new MyWebsite();
		
		newWebsite.setTitle("Testttt");
		newWebsite.setHeading("My Life 123");
		newWebsite.setParagraph("It's graphics interchange format!");
		newWebsite.setTemplate(TemplateEnum.Green);
		newWebsite.setPublished(true);
		newWebsite.setOwner(user);
		
		assertEquals("Testttt", newWebsite.getTitle());
		assertEquals("My Life 123", newWebsite.getHeading());
		assertEquals("It's graphics interchange format!", newWebsite.getParagraph());
		assertEquals(TemplateEnum.Green, newWebsite.getTemplate());
		assertEquals(true, newWebsite.isPublished());
		assertEquals(user, newWebsite.getOwner());
	}
	
	@Test
	void testDeleteOwner() {
		websiteRight.deleteOwner();
		
		assertEquals(null, websiteRight.getOwner());
	}

}

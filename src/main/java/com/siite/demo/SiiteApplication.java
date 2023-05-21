package com.siite.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.siite.demo.enums.RolesEnum;
import com.siite.demo.enums.TemplateEnum;
import com.siite.demo.models.MyUser;
import com.siite.demo.models.MyWebsite;
import com.siite.demo.repos.IMyUserRepo;
import com.siite.demo.repos.IMyWebsiteRepo;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SiiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiiteApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner (IMyWebsiteRepo websiteRepo, IMyUserRepo userRepo) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				MyUser user1 = new MyUser("admin", "email@email.com", "admin123", RolesEnum.ADMIN);
				userRepo.save(user1);
				
				MyWebsite web1 = new MyWebsite("title","heading", "paragraph", TemplateEnum.Green, false, user1);
				websiteRepo.save(web1);
				
			}
		};
	}

}

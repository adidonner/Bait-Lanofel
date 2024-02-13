package app.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import app.core.entities.Family;
import app.core.entities.Friend;
import app.core.entities.Media;


@Configuration
@ComponentScan
public class Config {

	@Bean
	@Scope("prototype")
	public Family family() {
		Family family = new Family();
		return family;
	}

	@Bean
	@Scope("prototype")
	public Friend friend() {
		Friend friend = new Friend();
		return friend;

	}
	
	@Bean
	@Scope("prototype")
	public Media media() {
		Media media = new Media();
		return media;
	}
//	@Bean
//	@Scope("prototype")
//	public User user() {
//		User user = new User();
//		return user;
//	}

}

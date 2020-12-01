package com.priyanjul.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.priyanjul.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// define bean for sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// define bean for cricket coach and inject dependency
	@Bean
	public Coach cricketCoach() {
		return new CricketCoach(sadFortuneService());
	}
}

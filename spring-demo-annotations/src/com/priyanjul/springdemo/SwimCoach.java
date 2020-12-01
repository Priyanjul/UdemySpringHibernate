package com.priyanjul.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;

	// define a default constructor
		public SwimCoach() {
			System.out.println(">> SwimCoach: inside default constructor");
		}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "20 mins of diving practice.";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

}

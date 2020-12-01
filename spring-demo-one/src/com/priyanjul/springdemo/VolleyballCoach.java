package com.priyanjul.springdemo;

public class VolleyballCoach implements Coach {

	// add new literal dependencies for injection
	private String emailAddress;
	private String team;
	
	private FortuneService fortuneService;
	
	// create a no-arg constructor
	public VolleyballCoach() {
		System.out.println("VolleyballCoach: inside no-arg constructor");
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("VolleyballCoach: inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("VolleyballCoach: inside setter method - setTeam");
		this.team = team;
	}

	// setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("VolleyballCoach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Beach practice for 30 mins";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

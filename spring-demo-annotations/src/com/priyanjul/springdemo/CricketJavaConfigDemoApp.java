package com.priyanjul.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CricketJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		CricketCoach theCoach = context.getBean("cricketCoach", CricketCoach.class);
		
		// call a method on bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// calling methods injected from properties file
		System.out.println("email: " + theCoach.getEmail());
		System.out.println("team: " + theCoach.getTeam());
		
		// close the context
		context.close();
	}

}

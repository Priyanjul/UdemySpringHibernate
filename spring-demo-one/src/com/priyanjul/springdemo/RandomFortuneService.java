package com.priyanjul.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	String fortunes[] = {"You'll have a great day!",
						"You'll be successfull!",
						"Enjoy your life!"};
	@Override
	public String getFortune() {
		Random rand = new Random();
		int num = rand.nextInt(3);
		return fortunes[num];
	}

}

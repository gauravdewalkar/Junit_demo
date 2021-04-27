package com.unittesting.java.AbstractFactory;

public class AbstractFactoryProducer {

	public static AbstractFactory getProfession(boolean trainee) {
		if (trainee)
		{
			return new TraineeProfessionFactory();
		}
		else
			return new ProfessionFactory();
	}
}

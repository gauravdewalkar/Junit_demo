package com.unittesting.java.AbstractFactory;

public class AbstractFactoryMain {

	public static void main(String[] args) {
	
		
		AbstractFactory abstractFactory = AbstractFactoryProducer.getProfession(true);
		
		Profession engg =abstractFactory.getProfession("Engineer");
		engg.printProfession();
		          
	}

} 

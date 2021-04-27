package com.unittesting.java.DesignPatterns;

public class ProfessionFactoryMainClass {

	public static void main(String[] args) {

		ProfessionFactory professionFactory = new ProfessionFactory();

		Profession p = professionFactory.getProfession("Engineer");
		p.printProfession();
		Profession p2 = professionFactory.getProfession("Doctor");
		p2.printProfession();
	}

}

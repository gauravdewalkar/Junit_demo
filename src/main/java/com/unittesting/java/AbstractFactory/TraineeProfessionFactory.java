package com.unittesting.java.AbstractFactory;

public class TraineeProfessionFactory extends AbstractFactory{

	public Profession getProfession(String professionName) {

		if (professionName == null)
			return null;

		if (professionName.equalsIgnoreCase("Doctor")) {
			return new TraineeDoctor();
		}

		if (professionName.equalsIgnoreCase("Engineer")) {
			return new TraineeEngineer();
		}
		return null;
	}
	
}

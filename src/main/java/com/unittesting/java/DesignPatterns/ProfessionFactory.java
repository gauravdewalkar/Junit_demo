package com.unittesting.java.DesignPatterns;

public class ProfessionFactory {

	public Profession getProfession(String professionName) {

		if (professionName == null)
			return null;

		if (professionName.equalsIgnoreCase("Doctor")) {
			return new Doctor();
		}

		if (professionName.equalsIgnoreCase("Engineer")) {
			return new Engineer();
		}
		return null;
	}

}

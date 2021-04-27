package com.unittesting.java.basicPrograms;

import java.util.Scanner;

public class Palandrome {

	public static void main(String[] args) {

		String inputString, reverse = "";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the string :");
		inputString = scanner.nextLine();

		for (int i = inputString.length() - 1; i >= 0; i--) {

			reverse = reverse + inputString.charAt(i);
		}

		if (reverse.equals(inputString))
			System.out.println("Is Palandrome");
		else
			System.out.println("Not Palandrome");

	}

}

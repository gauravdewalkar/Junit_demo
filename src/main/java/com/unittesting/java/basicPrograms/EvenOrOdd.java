package com.unittesting.java.basicPrograms;

public class EvenOrOdd {

	public static void main(String[] args) {

		isOddOrEven(15);
		isEvenOrOdd(76);
		
	}

	public static void isEvenOrOdd(int number) {

		int q = number / 2;

		if (q * 2 == number) {
			System.out.println(number + " : is an Even Number");

		} else {
			System.out.println(number + " : is an Odd Number");
		}

	}

	public static void isOddOrEven(int number) {

		if ((number & 1) == 0) {
			System.out.println("Using Bitwise : " + number + " : is an Even Number");

		} else {
			System.out.println("Using Bitwise :" + number + " : is an Odd Number");
		}

	}
}

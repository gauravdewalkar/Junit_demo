package com.unittesting.java.basicPrograms;

public class VowelsPresent {

	public static void main(String[] args) {

		
		System.out.println(checkVowels("yyyy xxxx zzzzz"));
		
		
		
		String s = "  abc  def\t";
		

	}

	public static Boolean checkVowels(String s) {

		return s.toLowerCase().matches(".*[aeiou].*");

	}
}

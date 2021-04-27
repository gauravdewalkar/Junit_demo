package com.unittesting.java.basicPrograms;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PrintDuplicateFromString {

	public static void main(String[] args) {
		printDuplicateCharacters("");
		printDuplicateCharacters(" ");
		printDuplicateCharacters("Java");
		printDuplicateCharacters("Naveeneen");

	}

	
	
	public static void printDuplicateCharacters(String word) {

		if (word == null || word == "" || word.length() == 1) {

			System.out.println("String is either empty or null");
		}

		char words[] = word.toCharArray();
		Map<Character, Integer> chMap = new HashMap<>();

		for (Character ch : words) {
			if (chMap.containsKey(ch)) {
				chMap.put(ch, chMap.get(ch) + 1);
			} else {
				chMap.put(ch, 1);
			}
		}
		// printing the map
		Set<Entry<Character, Integer>> entries = chMap.entrySet();
		for (Map.Entry<Character, Integer> entry : entries) {
			if (entry.getValue() > 1) {
				System.out.println("character :" + entry.getKey() + ":" + entry.getValue());
			}
		}

	}
	
	
	
				
			}
	


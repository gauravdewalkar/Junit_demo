package com.unittesting.java.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Demo {

	
	
	public static void main(String[] args) {

		List<String> strings = Arrays.asList("lalit", "aman", "ganesh", "nitin", "");
		System.out.println(strings);

		List<String> stringsUpper = strings.stream().
				filter(s -> !s.isEmpty()).
				filter(s -> s.startsWith("g")).
				map(String::toUpperCase).
				collect(Collectors.toList());

		System.out.println(stringsUpper);
		
		strings.stream().map(String::toUpperCase).sorted().forEach(System.out::println);
		
		
		Map<String,Integer> hmap  = new HashMap<>();
		hmap.put("shivam", 1);
		hmap.put("varun", 2);
		hmap.put("gaurav", 3);
		hmap.put("aman", 4);
		hmap.put("vishnu", 5);
		System.out.println("--------------------------");
		hmap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		
		System.out.println("--------------------------");
		
		hmap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

	}
}

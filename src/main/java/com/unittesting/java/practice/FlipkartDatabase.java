package com.unittesting.java.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlipkartDatabase {

	public static List<Customer> getCustomers() {

		return Stream
				.of(new Customer(1, "Varun", "varun@gmail.com", Arrays.asList("84644537546", "6454746538"),80000.0,"A"),
						new Customer(1, "Shivam", "Shivam@gmail.com", Arrays.asList("84644537546", "6454746538"),60000.9,"B"),
						new Customer(1, "Salam", "Salam@gmail.com", Arrays.asList("84644537546", "6454746538"),90000.6,"A"),
						new Customer(1, "Aman", "Aman@gmail.com", Arrays.asList("84644537546", "6454746538"),180000.4,"A")
						)
				.collect(Collectors.toList());
	}

}

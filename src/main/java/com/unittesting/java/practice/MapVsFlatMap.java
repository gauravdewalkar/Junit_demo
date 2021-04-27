package com.unittesting.java.practice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapVsFlatMap {

	public static void main(String[] args) {
		
		// get all the customers
		List<Customer> customers = FlipkartDatabase.getCustomers();
		
		
		//get all emails ( using map)
		List<String> emailIds = customers.stream().map(s-> s.getEmail()).collect(Collectors.toList());
	      System.out.println(emailIds);
	      
			//get all Phones ( using map)
	      List<List<String>> phoneNumbers =  customers.stream().map(s-> s.getPhonenumbers()).collect(Collectors.toList());
	      System.out.println(phoneNumbers);
	      
			//get all Phones ( using map)
	      List<String> numbers =  customers.stream().flatMap(s-> s.getPhonenumbers().stream()).collect(Collectors.toList());
	      System.out.println(numbers);
	      
	      
	      //get customer with grade A
	Double avgSalary = customers.stream().filter(e->e.getGrade().equalsIgnoreCase("A")).
	      map(i->i.getSalary()).mapToDouble(i->i).average().getAsDouble();
	 System.out.println(avgSalary);
	}
	

}

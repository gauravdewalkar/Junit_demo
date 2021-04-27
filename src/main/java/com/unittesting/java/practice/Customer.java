package com.unittesting.java.practice;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	private int id;
	private String name;
	private String email;
	private List<String> phonenumbers;
	private Double salary;
	private String grade;

}

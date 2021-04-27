package com.unittesting.java.basicPrograms;

public class FactorialRecursion {

	public static void main(String[] args) {
		
		System.out.println(factorial(5));
		System.out.println(factorial(10));
		System.out.println("--------------------------");

		System.out.println(fibonacci(9));


	}

	public static long factorial(long n) {
		return (n == 1) ? 1 : (n * factorial(n - 1));

	}
	
	
	public static int fibonacci(int n) {
		
		return (n<=1) ? n : fibonacci(n-1) + fibonacci(n-2);
	}
}

package com.unittesting.java.DesignPatterns;

public class MainClass {
	
	
	public static void main(String[] args) {
		
       
       
		LazySingelton lazy1 = LazySingelton.getInstance();
		lazy1.getHashcode();
	
	LazySingelton lazy2 = LazySingelton.getInstance();
	lazy2.getHashcode();
	
	DoubleCheckLazySingelton l3 = DoubleCheckLazySingelton.getInstance();
	l3.getHashcode();
	
	DoubleCheckLazySingelton l4 = DoubleCheckLazySingelton.getInstance();
	l4.getHashcode();
	
	
	LazyInnerClassSingelton lazy5 = LazyInnerClassSingelton.getInstance();
	LazyInnerClassSingelton lazy6 = LazyInnerClassSingelton.getInstance();
	System.out.println(lazy5.hashCode());
	System.out.println(lazy6.hashCode());
	}
	

	


}

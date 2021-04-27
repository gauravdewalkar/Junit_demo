package com.unittesting.java.DesignPatterns;

public class LazySingelton {

	private LazySingelton() {
	}

	private static LazySingelton instance;

	public static LazySingelton getInstance() {
		if (instance == null) {
			return instance=new LazySingelton();
		} else
			return instance;
	}

	public void getHashcode() {

		System.out.println("hashcode of the object = :" + instance.hashCode());
	}
}

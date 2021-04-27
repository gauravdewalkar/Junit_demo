package com.unittesting.java.DesignPatterns;

public class DoubleCheckLazySingelton {

	private DoubleCheckLazySingelton() {
	}

	private static DoubleCheckLazySingelton instance;

	public static DoubleCheckLazySingelton getInstance() {
		if (instance == null) {

			synchronized (DoubleCheckLazySingelton.class) {

				if (instance == null) {
					instance = new DoubleCheckLazySingelton();
				}
			}
		}
		return instance;
	}

	public void getHashcode() {

		System.out.println("hashcode of the object = :" + instance.hashCode());
	}
}

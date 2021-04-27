package com.unittesting.java.DesignPatterns;

public class EagerSingelton {

	private EagerSingelton() {
	}

	private static EagerSingelton instance = new EagerSingelton();

	public static EagerSingelton getInstance() {

		return instance;
	}

}

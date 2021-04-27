package com.unittesting.java.DesignPatterns;

public class LazyInnerClassSingelton {

	private LazyInnerClassSingelton() {
	}

	private static class SingeltonHelper {

		private static final LazyInnerClassSingelton instance = new LazyInnerClassSingelton();
	}

	public static LazyInnerClassSingelton getInstance() {
		return SingeltonHelper.instance;
	}
}

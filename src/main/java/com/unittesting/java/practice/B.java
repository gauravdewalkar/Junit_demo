package com.unittesting.java.practice;

public class B {

	public synchronized void demo2(A a) {

		System.out.println("Inside demo 2 method of class B");
		try {

			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

		System.out.println("Trying to call A's last method");
		a.last();
	}

	public  void last() {

		System.out.println("Executing demo 2 last method");
	}

}

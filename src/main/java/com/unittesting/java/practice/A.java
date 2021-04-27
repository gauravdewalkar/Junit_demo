package com.unittesting.java.practice;

public class A {

	public synchronized void demo1(B b) {

		System.out.println("Inside demo 1 method of class A");
		try {

			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

		System.out.println("Trying to call B's last method");
		b.last();
	}

	public  void last() {
		System.out.println("Executing demo 1 last method");

	}
}

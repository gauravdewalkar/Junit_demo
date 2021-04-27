package com.unittesting.java.practice;





public class Deadlock extends Thread {

	A a = new A();
	B b = new B();

	public void m1() {
		this.start();
		a.demo1(b);// this line is executed by Main thread
	}

	public void run() {

		b.demo2(a);// this line is executed by Child thread
	}

	public static void main(String args[]) {

		Deadlock t = new Deadlock();
		t.m1();

	}

}
package com.unittesting.java.practice;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashmapdemo {

	public static void main(String[] args) {
	 ConcurrentHashMap<Integer, String> chm = new ConcurrentHashMap<>();
	 chm.put(101, "aman");
	 chm.put(102, "Lalit");
	 chm.putIfAbsent(103, "Nitin");
	 chm.putIfAbsent(101, "prakash");
	 chm.remove(101, "prakash");
	 chm.replace(102, "Lalit", "Nikhil");
	 System.out.println(chm);
	}

}

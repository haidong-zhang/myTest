package com.haidong.entity;

public class SimpleService {
	public String getGreeting(String name) {
		return "��� " + name;
	}

	public int getPrice() {
		return new java.util.Random().nextInt(1000);
	}
}

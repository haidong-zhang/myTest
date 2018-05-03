package com.haidong.entity;

public class SubThread extends Thread{

	@Override
	public void run() {
		System.out.println(this.getName());
	}
	
}

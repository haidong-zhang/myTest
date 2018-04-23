package com.haidong.test;

import org.junit.Test;

public class TestRegrex {
	public static void main(String[] args) {
		System.out.println("waagwefwef".matches("^w[\\w]*"));
	}
	
	@Test
	public void test1(){
		String str = "/* 1 */";
		System.out.println(str.matches("/[\\u002A][\\s]*[\\S]*[\\s]*[\\u002A]/"));
//		System.out.println("*".matches("\\u002A"));
	}
}

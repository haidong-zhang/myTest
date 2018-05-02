package com.haidong.test;

import org.junit.Test;

public class TestInteger {
	@Test
	public void test1(){
		Integer f1 = 50, f2=50, f3=128, f4=128;
		System.out.println(f1==f2);//true
		System.out.println(f1);
		System.out.println(f3);
		System.out.println(f3==f4);//false 如果f3,f4是小于128的数，就是true
	}
	
	

}

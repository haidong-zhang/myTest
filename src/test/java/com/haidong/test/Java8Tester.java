package com.haidong.test;

import org.junit.Test;

public class Java8Tester {
	@Test
	public void test1(){
		Java8Tester tester = new Java8Tester();
		
		//类型声明
		MathOperation adddition = (int a,int b) -> a + b;
		
		//不用类型声明
		MathOperation subtraction = (a,b) -> a - b;
		
		//大括号中的返回语句
		MathOperation multiplication = (int a, int b) -> { return a * b; };
		
		
	}
	
	interface MathOperation {
	    int operation(int a, int b);
	 }
	  
	 interface GreetingService {
	    void sayMessage(String message);
	 }
	  
	 private int operate(int a, int b, MathOperation mathOperation){
	    return mathOperation.operation(a, b);
	 }
}


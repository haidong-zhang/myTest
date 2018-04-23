package com.haidong.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TestList {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String, String>();
		List<String> list = new ArrayList<String>();
		for (String string : map.values()) {
			System.out.println(string);
		}
	}
	
	@Test
	public void test2(){
		String str = null;
		LinkedList<String> abnormalList = new LinkedList<String>();
		abnormalList.add(str);
		System.out.println(abnormalList);
	}
}

package com.haidong.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.haidong.entity.Student;

public class Java8Test {
	@Test
	public void testStreamDistinct(){
		List<Student> students = new ArrayList<>();
		Student s1 = new Student(1,"С1");
		Student s3 = new Student(3,"С3");
		Student s11 = new Student(1,"С11");
		Student s4 = new Student(4,"С4");
		
		students.add(s1);
		students.add(s3);
		students.add(s11);
		students.add(s4);
		
		System.out.println(students);
		List<Integer> collect = students.stream().map(item->item.getId()).distinct().collect(Collectors.toList());
		System.out.println(collect);
		System.out.println("����");
//		students.stream().
	}
	
	@Test
	public void testStreamFilter(){
		List<String> nums = new ArrayList<>();
		nums.add("1");
		nums.add("2");
		nums.add("3");
		nums = nums.stream().filter(item -> {
			return true;
		}).collect(Collectors.toList());
		System.out.println(nums);
	}
	
	public boolean testUserNamePassword(String userName,String password){
		if(userName.length()==0 || password.length()==0){
			return false;
		}
		if(userName.equals(password)){
			return false;
		}
		return password.matches("^(?:(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[^A-Za-z0-9])).{6,18}$");
	}
	
	@Test
	public void testpassowrd(){
		System.out.println(testUserNamePassword("111","hd199931"));
	}
}

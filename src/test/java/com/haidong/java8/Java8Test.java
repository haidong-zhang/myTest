package com.haidong.java8;

import com.google.common.collect.Lists;
import com.haidong.entity.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
//		System.out.println(collect);
//		students.stream().
		collect.forEach(System.out::println);
	}
	
	@Test
	public void testStreamFilter(){
//		List<Integer> nums = new ArrayList<>();
//		nums.add(1);
//		nums.add(2);
//		nums.add(3);
//		nums.add(3);
//		nums.stream().filter(item ->  item != 3).count();

		List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6,1);
		nums = nums.stream().filter(num -> num != null).distinct().collect(Collectors.toList());
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

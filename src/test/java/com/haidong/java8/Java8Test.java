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
		
//		students.stream().
		
	}
}

package com.haidong.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	private String name;
	private String sex;
	private List<String> address;
	public String getName() {
		return name;
	}
	public Person(String name, String sex, List<String> address) {
		super();
		this.name = name;
		this.sex = sex;
		this.address = address;
	}
	public List<String> getAddress() {
		return address;
	}
	public void setAddress(List<String> address) {
		this.address = address;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Person(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
	}
	public Person() {
		super();
	}
	
}

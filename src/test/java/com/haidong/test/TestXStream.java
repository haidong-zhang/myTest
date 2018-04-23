package com.haidong.test;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Before;

import com.haidong.entity.Student;
import com.thoughtworks.xstream.XStream;

@SuppressWarnings("unchecked")
public class TestXStream {
	private XStream xstream = null;
	private ObjectOutputStream out = null;
	private ObjectInputStream in = null;
	
	private Student bean = null;
	
	@Before
	private void init(){
		xstream = new XStream();
		bean = new Student();
	}
}

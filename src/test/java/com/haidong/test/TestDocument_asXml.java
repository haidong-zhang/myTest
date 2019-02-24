package com.haidong.test;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class TestDocument_asXml {
	public static void main(String[] args) throws Exception {
		String str = "<req><name>Èý</name><gender>ÄÐ</gender></req>";
		Document document = DocumentHelper.parseText(str);
		Element root = document.getRootElement();
		root.addElement("age").setText("18");;
		String asXML = document.asXML();
		System.out.println(asXML);
	}
}

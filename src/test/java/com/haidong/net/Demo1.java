package com.haidong.net;

import java.net.InetAddress;

public class Demo1 {
	public static void main(String[] args) throws Exception{
		InetAddress localHost = InetAddress.getByName("www.baidu.com");
		System.out.println(localHost);
	}
}

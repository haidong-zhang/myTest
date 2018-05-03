package com.haidong.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketDemo {
	public static void main(String[] args) throws IOException {
		Socket client= new Socket("127.0.0.1", 8888);
		System.out.println(client);
		OutputStream outputStream = client.getOutputStream();
		outputStream.write("<heihie>���</heihie>".getBytes());
		 //��������д��ֹ����
		client.shutdownOutput();//������д��һ��������־
		InputStream inputStream = client.getInputStream();
		byte [] bytes = new byte[1024];
		int len;
		StringBuilder sb = new StringBuilder();
		while((len=inputStream.read(bytes))!=-1){
			sb.append(new String(bytes,0,len));
		}
		System.out.println(sb.toString());
		client.close();
	}
}

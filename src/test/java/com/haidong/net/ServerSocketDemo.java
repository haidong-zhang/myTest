package com.haidong.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);
		try {
			while(true){
			Socket accept = server.accept();
			InputStream inputStream = accept.getInputStream();
			InputStreamReader reader = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(reader);
			String info=null;
			StringBuilder sb = new StringBuilder();
			while((info=br.readLine())!=null){
				sb.append(info);
			}
			System.out.println(sb.toString());
			OutputStream outputStream = accept.getOutputStream();
			outputStream.write("<��ð�>���</��ð�>".getBytes());
			accept.shutdownOutput();//���ֽ���һ����β��ʶ
			}
		} catch (Exception e) {
			e.printStackTrace();
			server.close();
		}
	}
}

package com.haidong.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;

public class TestWeiXin {
	public static Logger  log = Logger.getLogger(TestWeiXin.class);
	public static void postForm(String url, File file, String formId)throws IOException {
//		HttpPost httpPost = new HttpPost(url);
		log.info("httpPost url:" + url);
		log.info("httpPost file:" + file);
		
		BufferedReader reader = null;
		try {
			URL openUrl = new URL(url);

			HttpURLConnection con = (HttpURLConnection) openUrl.openConnection();
			con.setRequestMethod("POST"); // ��Post��ʽ�ύ����Ĭ��get��ʽ
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setUseCaches(false); // post��ʽ����ʹ�û���
			// ��������ͷ��Ϣ
			con.setRequestProperty("Connection", "Keep-Alive");
			con.setRequestProperty("Charset", "UTF-8");
			// ���ñ߽�
			String BOUNDARY = "----------" + System.currentTimeMillis();
			con.setRequestProperty("Content-Type","multipart/form-data; boundary="+ BOUNDARY);
			// ����������Ϣ
			// ��һ���֣�
			StringBuilder sb = new StringBuilder();
			sb.append("--"); // �����������
			sb.append(BOUNDARY);
			sb.append("\r\n");
			sb.append("Content-Disposition: form-data;name=\""+formId+"\";filename=\""
					+ file.getName() + "\" \r\n");
			sb.append("Content-Type:application/octet-stream\r\n\r\n");

			byte[] head = sb.toString().getBytes("utf-8");

			// ��������
			OutputStream out = new DataOutputStream(con.getOutputStream());
			// �����ͷ
			out.write(head);
			// �ļ����Ĳ���
			// ���ļ������ļ��ķ�ʽ ���뵽url��
			DataInputStream in = new DataInputStream(new FileInputStream(file));
			int bytes = 0;
			byte[] bufferOut = new byte[1024];
			while ((bytes = in.read(bufferOut)) != -1) {
				out.write(bufferOut, 0, bytes);
			}

			in.close();
			// ��β����
			byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// ����������ݷָ���
			out.write(foot);
			out.flush();
			out.close();
			StringBuffer buffer = new StringBuffer();

			// ����BufferedReader����������ȡURL����Ӧ
			reader = new BufferedReader(new InputStreamReader(con
			.getInputStream()));
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			System.out.println(line);
			
		} catch (IOException e) {
			System.out.println("����POST ����������쳣��" + e);
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}

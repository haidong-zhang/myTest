package com.haidong.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class TestWebService {
//	static String wsdl = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";
	static String wsdl = "http://171.221.250.178:8021/Kingdee.asmx";
	public static void main(String[] args) throws Exception{
		StringBuffer param = new StringBuffer();
		param.append("<soapenv:Envelope xmlns:soap"
				+ "env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://WebXml.com.cn/\">");
		param.append("<soapenv:Header/>");
		param.append("<soapenv:Body>");
		param.append("<web:getSupportCity>");
		param.append("<web:byProvinceName></web:byProvinceName>");
		param.append("</web:getSupportCity>");
		param.append("</soapenv:Body>");
		param.append("</soapenv:Envelope>");
		String request = request(param.toString());
		System.out.println(request);
	}
	
	public static String request(String requestContent) throws Exception {		
		String result = null;		
		URL url = new URL(wsdl);
		HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
		//连接超时设为30秒，读取数据超时设为60秒
		httpUrlConn.setConnectTimeout(30000);
		httpUrlConn.setReadTimeout(60000);
		httpUrlConn.setDoOutput(true);
		httpUrlConn.setDoInput(true);
		httpUrlConn.setUseCaches(false);
		httpUrlConn.setRequestProperty("Content-type","text/xml");
		// 设定请求的方法为"POST"，默认是GET
		httpUrlConn.setRequestMethod("POST");
		InputStream inputStream = null;
		OutputStream outputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		try {
			if (null != requestContent) {
				outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(requestContent.getBytes("UTF-8"));				
			}
			// 将返回的输入流转换成字符串
			inputStream = httpUrlConn.getInputStream();
			StringBuffer buffer = new StringBuffer();
			inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {				
				buffer.append(str);
			}			
			result = buffer.toString();
		} catch (Exception e) {			
			throw e;
		} finally {
			try {
				if(bufferedReader != null){
					bufferedReader.close();
					bufferedReader = null;
				}
				if(inputStreamReader!=null){
					inputStreamReader.close();
					inputStreamReader = null;
				}
				if (inputStream != null) {
					inputStream.close();
					inputStream = null;
				}
				if (outputStream !=null){
					outputStream.close();
					outputStream = null;
				}
				httpUrlConn.disconnect();
			} catch (Exception e) {
			}
		}
		//logger.error("接口调用返回值："+result);
		return result;
	}
	
	
}

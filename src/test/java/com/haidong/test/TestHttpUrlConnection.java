//package com.haidong.test;
//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import org.junit.Test;
//
//import com.haidong.webService.HttpRequestService;
//
//public class TestHttpUrlConnection {
//	@Test
//	public void test1()throws Exception{
//		HttpRequestService request = new HttpRequestService("http://171.221.250.178:8021/Kingdee.asmx");
//		System.out.println(request.request(""));
//	}
//	
//	
//	@Test
//	public void request() throws Exception {	
//		
//		String result = null;		
//		URL url = new URL("http://202.200.36.99:10112/interface-service-v3/gateway?service=support.pageQueryOrder");
//		HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
//		httpUrlConn.setConnectTimeout(20000);
//		
//		httpUrlConn.setDoOutput(true);
//		httpUrlConn.setDoInput(true);
//		httpUrlConn.setUseCaches(false);
//		
//		httpUrlConn.setRequestProperty("Content-type","text/xml;charset=UTF-8");
//		httpUrlConn.setRequestProperty("Connection","Keep-Alive");
//		// 设定请求的方法为"POST"，默认是GET
//		httpUrlConn.setRequestMethod("POST");
//		InputStream inputStream = null;
//		OutputStream outputStream = null;
//		InputStreamReader inputStreamReader = null;
//		BufferedReader bufferedReader = null;
//		
//		outputStream = httpUrlConn.getOutputStream();
//		String content = "<req><tradeDate>2017-11-08</tradeDate><productType></productType><pageSize>5000</pageSize><pageNo>1</pageNo><payMode>98</payMode></req>";
//		outputStream.write(content.getBytes("UTF-8"));
//		long before = 0;
//		try {
//			// 将返回的输入流转换成字符串
//			before = System.currentTimeMillis();
//			inputStream = httpUrlConn.getInputStream();			
//			httpUrlConn.setReadTimeout(180*1000);
//			//httpUrlConn.setChunkedStreamingMode(2*1024);
//			System.out.println(inputStream.toString());
//			StringBuffer buffer = new StringBuffer();
//			inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
//			bufferedReader = new BufferedReader(inputStreamReader);
//			String str = null;
//			while ((str = bufferedReader.readLine()) != null) {				
//				buffer.append(str);
//			}			
//			result = buffer.toString();
//		} catch (Exception e) {			
//			throw e;
//		} finally {
//			long later = System.currentTimeMillis();
//			long time = later-before;
//			System.out.println("请求耗时："+time+"ms");
//			try {
//				if(bufferedReader != null){
//					bufferedReader.close();
//					bufferedReader = null;
//				}
//				if(inputStreamReader!=null){
//					inputStreamReader.close();
//					inputStreamReader = null;
//				}
//				if (inputStream != null) {
//					inputStream.close();
//					inputStream = null;
//				}
//				if (outputStream !=null){
//					outputStream.close();
//					outputStream = null;
//				}
//				httpUrlConn.disconnect();
//			} catch (Exception e) {
//			}
//		}
//		//logger.error("接口调用返回值："+result);
//		System.out.println(result);
//	}
//}

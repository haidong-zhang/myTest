//package com.haidong.webService;
//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import org.apache.log4j.Logger;
//
//public class HttpRequestService {
//	
//	private static Logger logger=Logger.getLogger(HttpRequestService.class);
//	
//	private int connectTimeout;
//	private int readTimeout;
//	
//	private String wsdlAddress;
//
//	public HttpRequestService(String wsdl){
//		wsdlAddress=wsdl;
//		connectTimeout = 30000;
//		readTimeout = 60000;		
//	}
//	
//	
//
//	public static HttpRequestService getInstance(String wsdl){
//		return new HttpRequestService(wsdl);
//	}
//
//	
//	/**
//	 * 接口调用
//	 * @param requestContent
//	 * @return
//	 * @throws Exception
//	 */
//	public String request(String content) throws Exception {		
//		String result = null;		
//		URL url = new URL(wsdlAddress);
//		logger.error("接口地址："+wsdlAddress);
//		HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
//		//连接超时设为30秒，读取数据超时设为60秒
//		httpUrlConn.setConnectTimeout(connectTimeout);
//		httpUrlConn.setReadTimeout(readTimeout);
//		httpUrlConn.setDoOutput(true);
//		httpUrlConn.setDoInput(true);
//		httpUrlConn.setUseCaches(false);
//		httpUrlConn.setRequestProperty("Content-type","text/xml;charset=UTF-8");
//		// 设定请求的方法为"POST"，默认是GET
//		httpUrlConn.setRequestMethod("POST");
//		InputStream inputStream = null;
//		OutputStream outputStream = null;
//		InputStreamReader inputStreamReader = null;
//		BufferedReader bufferedReader = null;
//		outputStream = httpUrlConn.getOutputStream();
//		outputStream.write(content.getBytes("UTF-8"));
//		try {
//			// 将返回的输入流转换成字符串
//			inputStream = httpUrlConn.getInputStream();
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
//				logger.error("流关闭异常", e);
//			}
//		}
//		//logger.error("接口调用返回值："+result);
//		return result;
//	}
//}

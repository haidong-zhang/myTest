//package com.haidong.http;
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.security.GeneralSecurityException;
//import java.security.cert.CertificateException;
//import java.security.cert.X509Certificate;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLException;
//import javax.net.ssl.SSLSession;
//import javax.net.ssl.SSLSocket;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.HttpStatus;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.conn.ssl.SSLContextBuilder;
//import org.apache.http.conn.ssl.TrustStrategy;
//import org.apache.http.conn.ssl.X509HostnameVerifier;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//import org.apache.log4j.Logger;
//
//import net.sf.json.JSONObject;
//  
///** 
// * HTTP ���󹤾��� 
// */  
//public class HttpClientUtils {  
//	private static Logger logger = Logger.getLogger(HttpClientUtils.class);
//    private static PoolingHttpClientConnectionManager connMgr;  
//    private static RequestConfig requestConfig;  
//    private static final int MAX_TIMEOUT = 7000;  
//  
//    static {  
//        // �������ӳ�  
//        connMgr = new PoolingHttpClientConnectionManager();  
//        // �������ӳش�С  
//        connMgr.setMaxTotal(100);  
//        connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());  
//  
//        RequestConfig.Builder configBuilder = RequestConfig.custom();  
//        // �������ӳ�ʱ  
//        configBuilder.setConnectTimeout(MAX_TIMEOUT);  
//        // ���ö�ȡ��ʱ  
//        configBuilder.setSocketTimeout(MAX_TIMEOUT);  
//        // ���ô����ӳػ�ȡ����ʵ���ĳ�ʱ  
//        configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);  
//        // ���ύ����֮ǰ ���������Ƿ����  
//        configBuilder.setStaleConnectionCheckEnabled(true);  
//        requestConfig = configBuilder.build();  
//    }  
//    /** 
//     * ���� GET ����HTTP����K-V��ʽ 
//     * @param url 
//     * @param params 
//     * @return 
//     * @throws Exception 
//     */  
//    public static JSONObject doGet(String url, Map<String, Object> params) throws Exception {  
//        String apiUrl = url;  
//        StringBuffer param = new StringBuffer();  
//        int i = 0;
//        for (String key : params.keySet()) {  
//            if (i == 0)  
//                param.append("?");  
//            else  
//                param.append("&");  
//            param.append(key).append("=").append(params.get(key));  
//            i++;  
//        }  
//        apiUrl += param;  
////        System.out.println("����ĵ�ַ��"+apiUrl);
//        logger.info("����ĵ�ַ��"+apiUrl);
//        String result = null;  
////        HttpClient httpclient = new DefaultHttpClient();  
//        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
//        long before = 0;
//        long later = 0;
//        try {  
//        	//��Ҫ��һЩ�����ַ�ת��
//            HttpGet httpGet = new HttpGet(apiUrl.replace("<", "%3C").replace(">", "%3E").replace("|", "%7C").replaceAll("\\s", ""));
//            //��Ҫ����ʹ��json����
//            httpGet.setHeader("Content-Type", "application/json;charset=UTF-8");
//            //��ȡtoken����Ҫ�������֤������ͷ
//            if(apiUrl.contains("grant_type=client_credentials")||apiUrl.contains("grant_type=refresh_token")){
////            	httpGet.setHeader("Authorization","Basic OTkxMTJjZmQ5NjNkMjUxZDM0ZjhhYWYyMzRkNjgzNTg=");
//            	httpGet.setHeader("Authorization","Basic YjE4NGFhOTgwZjY3ODFjY2U3ODM2NjYzMTg3MGZlY2E=");
//            }
//            before = System.currentTimeMillis();
//            HttpResponse response = httpclient.execute(httpGet); 
//            later = System.currentTimeMillis();
//            
//            int statusCode = response.getStatusLine().getStatusCode();  
//  
//            System.out.println("ִ��״̬�� : " + statusCode);  
//  
//            HttpEntity entity = response.getEntity(); 
//            if (entity != null) {  
////                InputStream instream = entity.getContent();  
//                result = EntityUtils.toString(entity, "UTF-8");  
////                result = IOUtils.toString(instream, "UTF-8");  
//            }  
//        } catch (IOException e) { 
//        	logger.error("���������쳣��", e);
////        	e.printStackTrace();
//        }finally{
////        	System.out.println("http�����ʱ��"+(later-before)+"ms");
//        	logger.info("http�����ʱ��"+(later-before)+"ms");
//        }
//        JSONObject jsonObject = JSONObject.fromObject(result);;
//        //�����ӡ��data��������ݻ������ǩ���\,����ԭ�����������ó�����������������
////        System.out.println("http��������"+jsonObject.toString());
//        logger.info("http��������"+jsonObject.toString());
//        return jsonObject;  
//    }  
//  
//    /** 
//     * ���� POST ����HTTP���������������� 
//     * @param apiUrl 
//     * @return 
//     */  
//    public static String doPost(String apiUrl) {  
//        return doPost(apiUrl, new HashMap<String, Object>());  
//    }  
//  
//    /** 
//     * ���� POST ����HTTP����K-V��ʽ 
//     * @param apiUrl API�ӿ�URL 
//     * @param params ����map 
//     * @return 
//     */  
//    public static String doPost(String apiUrl, Map<String, Object> params) {  
//        CloseableHttpClient httpClient = HttpClients.createDefault();  
//        String httpStr = null;  
//        HttpPost httpPost = new HttpPost(apiUrl);  
//        CloseableHttpResponse response = null;  
//  
//        try {  
//            httpPost.setConfig(requestConfig);  
//            List<NameValuePair> pairList = new ArrayList<>(params.size());  
//            for (Map.Entry<String, Object> entry : params.entrySet()) {  
//                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry  
//                        .getValue().toString());  
//                pairList.add(pair);  
//            }  
//            httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("UTF-8")));  
//            response = httpClient.execute(httpPost);  
//            System.out.println(response.toString());  
//            HttpEntity entity = response.getEntity();  
//            httpStr = EntityUtils.toString(entity, "UTF-8");  
//        } catch (IOException e) {  
//            e.printStackTrace();  
//        } finally {  
//            if (response != null) {  
//                try {  
//                    EntityUtils.consume(response.getEntity());  
//                } catch (IOException e) {  
//                    e.printStackTrace();  
//                }  
//            }  
//        }  
//        return httpStr;  
//    }  
//  
//    /** 
//     * ���� POST ����HTTP����XML��ʽ 
//     * @param apiUrl 
//     * @param xml xml���� 
//     * @return 
//     */  
//    public static String doPost(String apiUrl, Object xml) {  
//        CloseableHttpClient httpClient = HttpClients.createDefault();  
//        String httpStr = null;  
//        HttpPost httpPost = new HttpPost(apiUrl);  
//        CloseableHttpResponse response = null;  
//  
//        try {  
//            httpPost.setConfig(requestConfig);  
//            StringEntity stringEntity = new StringEntity(xml.toString(),"UTF-8");//���������������  
//            stringEntity.setContentEncoding("UTF-8");  
//            stringEntity.setContentType("application/xml");  
//            httpPost.setEntity(stringEntity);  
//            response = httpClient.execute(httpPost);  
//            HttpEntity entity = response.getEntity();  
//            System.out.println(response.getStatusLine().getStatusCode());  
//            httpStr = EntityUtils.toString(entity, "UTF-8");  
//        } catch (IOException e) {  
//            e.printStackTrace();  
//        } finally {  
//            if (response != null) {  
//                try {  
//                    EntityUtils.consume(response.getEntity());  
//                } catch (IOException e) {  
//                    e.printStackTrace();  
//                }  
//            }  
//        }  
//        return httpStr;  
//    }  
//  
//    /** 
//     * ���� SSL POST ����HTTPS����K-V��ʽ 
//     * @param apiUrl API�ӿ�URL 
//     * @param params ����map 
//     * @return 
//     */  
//    public static String doPostSSL(String apiUrl, Map<String, Object> params) {  
//        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();  
//        HttpPost httpPost = new HttpPost(apiUrl);  
//        CloseableHttpResponse response = null;  
//        String httpStr = null;  
//  
//        try {  
//            httpPost.setConfig(requestConfig);  
//            List<NameValuePair> pairList = new ArrayList<NameValuePair>(params.size());  
//            for (Map.Entry<String, Object> entry : params.entrySet()) {  
//                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry  
//                        .getValue().toString());  
//                pairList.add(pair);  
//            }  
//            httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("utf-8")));  
//            response = httpClient.execute(httpPost);  
//            int statusCode = response.getStatusLine().getStatusCode();  
//            if (statusCode != HttpStatus.SC_OK) {  
//                return null;  
//            }  
//            HttpEntity entity = response.getEntity();  
//            if (entity == null) {  
//                return null;  
//            }  
//            httpStr = EntityUtils.toString(entity, "utf-8");  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        } finally {  
//            if (response != null) {  
//                try {  
//                    EntityUtils.consume(response.getEntity());  
//                } catch (IOException e) {  
//                    e.printStackTrace();  
//                }  
//            }  
//        }  
//        return httpStr;  
//    }  
//  
//    /** 
//     * ���� SSL POST ����HTTPS����JSON��ʽ 
//     * @param apiUrl API�ӿ�URL 
//     * @param json JSON���� 
//     * @return 
//     */  
//    public static String doPostSSL(String apiUrl, Object json) {  
//        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();  
//        HttpPost httpPost = new HttpPost(apiUrl);  
//        CloseableHttpResponse response = null;  
//        String httpStr = null;  
//  
//        try {  
//            httpPost.setConfig(requestConfig);  
//            StringEntity stringEntity = new StringEntity(json.toString(),"UTF-8");//���������������  
//            stringEntity.setContentEncoding("UTF-8");  
//            stringEntity.setContentType("application/json");  
//            httpPost.setEntity(stringEntity);  
//            response = httpClient.execute(httpPost);  
//            int statusCode = response.getStatusLine().getStatusCode();  
//            if (statusCode != HttpStatus.SC_OK) {  
//                return null;  
//            }  
//            HttpEntity entity = response.getEntity();  
//            if (entity == null) {  
//                return null;  
//            }  
//            httpStr = EntityUtils.toString(entity, "utf-8");  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        } finally {  
//            if (response != null) {  
//                try {  
//                    EntityUtils.consume(response.getEntity());  
//                } catch (IOException e) {  
//                    e.printStackTrace();  
//                }  
//            }  
//        }  
//        return httpStr;  
//    }  
//  
//    /** 
//     * ����SSL��ȫ���� 
//     * 
//     * @return 
//     */  
//    private static SSLConnectionSocketFactory createSSLConnSocketFactory() {  
//        SSLConnectionSocketFactory sslsf = null;  
//        try {  
//            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {  
//  
//                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {  
//                    return true;  
//                }  
//            }).build();  
//            sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {  
//  
//                @Override  
//                public boolean verify(String arg0, SSLSession arg1) {  
//                    return true;  
//                }  
//  
//                @Override  
//                public void verify(String host, SSLSocket ssl) throws IOException {  
//                }  
//  
//                @Override  
//                public void verify(String host, X509Certificate cert) throws SSLException {  
//                }  
//  
//                @Override  
//                public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {  
//                }  
//            });  
//        } catch (GeneralSecurityException e) {  
//            e.printStackTrace();  
//        }  
//        return sslsf;  
//    }  
//  
//  
//    /** 
//     * ���Է��� 
//     * @param args 
//     */  
//    public static void main(String[] args) throws Exception {  
//  
//    }  
//}
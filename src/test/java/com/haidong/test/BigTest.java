package com.haidong.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

import com.haidong.database.DBUtil;
import com.haidong.entity.Person;
import com.haidong.entity.Student;
import com.haidong.entity.SubThread;
import com.ibm.icu.text.DecimalFormat;

public class BigTest extends Thread{
	/**
	 * ����beanUtil
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Test
	public void testBeanUtil() throws IllegalAccessException, InvocationTargetException{
		List<String> list = new ArrayList<String>();
		list.add("cc");
		list.add("bb");
		list.add("aa");
		list.add("bb");
		Person p = new Person("����","��",list);
		Student s = new Student();
		BeanUtils.copyProperties(s, p);
		System.out.println(s);
	}
	
	/**
	 * ���Զ��߳�
	 */
	@Test
	public void testThread(){
		SubThread th1 = new SubThread();
		th1.setName("�߳�1");
		System.out.println(getName());
		th1.start();
	}
	/*public static void main(String[] args) {
		Thread bt = Thread.currentThread();
		System.out.println(bt.getName());
	}*/
	/**
	 * ��������
	 * @throws ParseException
	 */
	@Test
	public void testAge() throws ParseException{
		Calendar cal = Calendar.getInstance();  
		Date birthDay = parse("440224199311290274");
        int yearNow = cal.get(Calendar.YEAR);  
        int monthNow = cal.get(Calendar.MONTH);  
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);  
        cal.setTime(birthDay);  
  
        int yearBirth = cal.get(Calendar.YEAR);  
        int monthBirth = cal.get(Calendar.MONTH);  
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);  
  
        int age = yearNow - yearBirth;  
  
        if (monthNow <= monthBirth) {  
            if (monthNow == monthBirth) {  
                if (dayOfMonthNow < dayOfMonthBirth) age--;  
            }else{  
                age--;  
            }  
        }  
		System.out.println(age+"��");
	}
	
	public  Date parse(String idCardNo) throws ParseException {  
		String birthdayStr = idCardNo.substring(6,14);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");  
        return sdf.parse(birthdayStr);  
    } 
	
	@Test
	public void testContinue(){
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("");
		list.add("2");
		list.add("3");
		for (String string : list) {
			if(!StringUtils.isNotBlank(string)){
				continue;
			}
			System.out.println(string);
		}
	}
	
	@Test
	public void testFile() throws Exception{
		URI uri = new URI("http://images.mhealth100.com/upload/image/00005/weixin/0000620160714112057.jpg");
		File file = new File(uri);
		System.out.println(file.getPath());
//		System.out.println(file.getName());
//		String prefix = file.getPath().substring(0,(file.getPath().indexOf(".")+1));
//		System.out.println(prefix);
//		boolean renameTo = file.renameTo(new File(prefix+"png"));
		
//		System.out.println(file.getPath());
//		File f1 = new File("C:\\Users\\xy_ha\\Desktop\\11.jpg");
//		boolean renameTo = f1.renameTo(f2);
//		System.out.println(renameTo);
		
//		System.out.println(f2.exists());
//		new FileInputStream(file);
	}
	
	@Test
	public void testFileInputStream()throws Exception{
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\xy_ha\\Desktop\\22.png"));
		int bytes = fis.available();
		System.out.println(bytes);
		fis.close();
	}
	
	@Test
	public void testDouble (){
//		Double d1 = 0.0;
//		Double d2 = 5.0000;
//		Double d3 = 1.9000;
//		System.out.println((d1+d2+d3));
		String d1 = "963.02";
		String d2 = "810.00";
		double returnPay = Double.parseDouble(d2);
		DecimalFormat df = new DecimalFormat("#.##");
//	    BigDecimal bd1 = new BigDecimal("963.02");
//	    BigDecimal bd2 = new BigDecimal("810.00");
//	    bd1.
	    
		System.out.println(df.format(Double.parseDouble(d1)-returnPay));
	}
	
	@Test
	public void testNewLine(){
		System.out.print("���\r\n");
		System.out.print("�Һ�");
		System.out.print("��Һ�");
	}
	
	/**
	 * ����json
	 */
	@Test
	public void testJson(){
		Map<String,String> infoMap= new HashMap<String,String>();
		infoMap.put("touser", "open");
		String jsonString = JSONObject.fromObject(infoMap).toString();
		System.out.println(jsonString);
	}
	
	/**
	 * ����byte
	 */
	@Test
	public void testByte(){
		System.out.println((byte)0x0B);
	}
	
	/**
	 * ʯ��������ҽԺ��鱨�����xml
	 * @throws Exception
	 */
	 @Test
	 public void testParseXml() throws Exception{
		 FileInputStream fis = new FileInputStream("F:\\kingdee\\ҽԺ\\a_ʯ��������ҽԺ\\1010\\jiancha.xml");
		 BufferedReader br = new BufferedReader(new InputStreamReader(fis,"utf-8"));
		 String str = null;
		 StringBuilder builder = new StringBuilder();
		 while((str=br.readLine())!=null){
			 builder.append(str);
		 }
		 br.close();
		 Document ele = DocumentHelper.parseText(builder.toString());
//		 String xpath = "//Compend[@Name='������Ϣ']";
//		 Element ele = (Element)doc.selectSingleNode(xpath);
//		 Node ele = doc.selectSingleNode(xpath);
		 String xpath = "//Element[@Name='����']";
		 Element element = (Element)ele.selectSingleNode(xpath);
		 System.out.println(element.getText());
		 
		 xpath = "//Element[@Name='�Ա�']";
		 element = (Element)ele.selectSingleNode(xpath);
		 System.out.println(element.getText());
		 
		 xpath = "//Element[@Name='����']";
		 element = (Element)ele.selectSingleNode(xpath);
		 System.out.println(element.getText());
		 
		 xpath = "//Element[@Name='����']";
		 element = (Element)ele.selectSingleNode(xpath);
		 System.out.println(element.getText());
		 
		 
	 }
	 @Test
	 public void testMap(){
		 Map<String,String> map = new HashMap<String, String>();
		 map.put("1", "2");
		 map.put("1", "2");
		 System.out.println(map);
	 }
	 
	 /**
	  * uuid
	  */
	 @Test
	 public  void generateUuid() {
	 		UUID id = UUID.randomUUID();
	 		String[] array = id.toString().split("-");
	 		StringBuffer sb = new StringBuffer();
	 		for (String str : array) {
	 			sb.append(str.toUpperCase());
	 		}
	 		System.out.println(sb.toString()); 
	 	}
	 /**
	  * ��̬
	  */
	 @Test
	 public  void testSelectValueNull() throws Exception{
		 Connection conn = DBUtil.getConn();
		 System.out.println(conn);
		 String name = null;
		PreparedStatement prepareStatement = conn.prepareStatement("select * from notice where name is null");
		ResultSet executeQuery = prepareStatement.executeQuery();
		System.out.println(executeQuery.next());
	 }
	 @Test
	 public  void testStringLowerCaseWithChinese() {
		 String s = "东";
		 System.out.println(s.toLowerCase());
	 }
}

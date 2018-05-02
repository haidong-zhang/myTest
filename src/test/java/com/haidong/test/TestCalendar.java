package com.haidong.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class TestCalendar {
	/**
	 * 获取指定日期的上下午值
	 * @param date
	 * @return
	 */
	public static String getNoon(Date date){
		if(date==null){
			return "";
		}
		GregorianCalendar ca = new GregorianCalendar();		
		ca.setTimeInMillis(date.getTime());
		int res=ca.get(GregorianCalendar.AM_PM);
		System.out.println(res);
		String noon="";
		if(res==0){
			noon = "上午";
		}else if(res==1){
			noon = "下午";
		}
		return noon;
	}
	
	public static void main(String[] args) {
		 Calendar calendar = Calendar.getInstance();
		 System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
//		 System.out.println(getNoon(new Date(2017, 11, 23, 9, 34, 0)));
		 System.out.println(getNoon(new Date()));
//		System.out.println(Calendar.getInstance().add(Calendar.day, amount););
	}
	

	@Test
	public void test1()throws Exception{
		String str = "2017-08-30 11:53:00.0";
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
		System.out.println(date);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		System.out.println(sqlDate);
	}
	
	@Test
	public void test2(){
		GregorianCalendar ca = new GregorianCalendar();	
		System.out.println(ca.get(Calendar.AM_PM));
	}
	
	@Test
	public void testDateFormat(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sf.format(null);
	}
	
	@Test
	public void testJudgeTime() throws Exception{
		Calendar today = Calendar.getInstance();
		
		String beginString = new SimpleDateFormat("yyyyMMdd").format(new Date());
		
		Date beginTime = new SimpleDateFormat("yyyyMMddHHmmss").parse(beginString+"170000");
		
		
		Calendar beganDate = Calendar.getInstance();
		beganDate.setTime(beginTime);
		
		System.out.println(beganDate.getTime());
		
		Calendar endDate = Calendar.getInstance();
		endDate.setTime(beginTime);
		endDate.add(Calendar.MINUTE,70);
		System.out.println(endDate.getTime());
		
		int compareTo1 = today.compareTo(beganDate);
		int compareTo2 = today.compareTo(endDate);
		System.out.println(compareTo1>0 && compareTo2<0);
		
	}
	
	@Test
	public void testCalendarGetMethod(){
		 Calendar calendar = Calendar.getInstance();
		 System.out.println("月中的日："+calendar.get(Calendar.DAY_OF_MONTH));
		 System.out.println("周中的日："+calendar.get(Calendar.DAY_OF_WEEK));
		 System.out.println("年中的日："+calendar.get(Calendar.DAY_OF_YEAR));
		 //下面两者之间有什么区别？
		 System.out.println("月中周中的日："+calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		 System.out.println("月中的周："+calendar.get(Calendar.WEEK_OF_MONTH));
	}
}

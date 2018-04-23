package com.haidong.test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author zhd
 *
 */
public class TestSqlServer {
	public static void main(String[] srg) {  
	     //加载JDBC驱动  
	   String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
	    //连接服务器和数据库sample  
	   String dbURL = "jdbc:sqlserver://192.168.0.37\\csserver;DatabaseName=gcris2";  
	   //192.168.0.37\\csserver;DatabaseName=gcris2
	   String userName = "pingt";   //默认用户名  
	   String userPwd = "pingt";   //密码  
	 
	   Connection dbConn;  
	   try {  
	   Class.forName(driverName);  
	   dbConn = DriverManager.getConnection(dbURL, userName, userPwd);  
	   System.out.println("Connection Successful!");   //如果连接成功 控制台输出
	   } catch (Exception e) {  
	   e.printStackTrace();  
	   }  
	}  
	} 


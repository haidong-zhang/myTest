package com.haidong.test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author zhd
 *
 */
public class TestSqlServer {
	public static void main(String[] srg) {  
	     //����JDBC����  
	   String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
	    //���ӷ����������ݿ�sample  
	   String dbURL = "jdbc:sqlserver://192.168.0.37\\csserver;DatabaseName=gcris2";  
	   //192.168.0.37\\csserver;DatabaseName=gcris2
	   String userName = "pingt";   //Ĭ���û���  
	   String userPwd = "pingt";   //����  
	 
	   Connection dbConn;  
	   try {  
	   Class.forName(driverName);  
	   dbConn = DriverManager.getConnection(dbURL, userName, userPwd);  
	   System.out.println("Connection Successful!");   //������ӳɹ� ����̨���
	   } catch (Exception e) {  
	   e.printStackTrace();  
	   }  
	}  
	} 


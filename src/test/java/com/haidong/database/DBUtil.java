package com.haidong.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Statement;

public class DBUtil {
	private static Connection conn = null;  
    private static Properties pro = new Properties();  
    //加载驱动,使用静态块，只需要加载一次  
    static {  
        try {  
            /** 
             * 加载配置文件的两种方法，任选一种都可以 
             */  
            //pro.load(DBUtil.class.getResourceAsStream("/DBUtil.properties"));  
            pro.load(DBUtil.class.getClassLoader().getResourceAsStream("DBUtil.properties"));  
            String DRIVER = pro.getProperty("DRIVER");  
            Class.forName(DRIVER);            
        } catch (IOException e) {  
              
            e.printStackTrace();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
          
    }  
    //获取Connection连接对象的方法,使用static方便之后在其他类中调用  
    public static Connection getConn() {  
        try {  
            conn = DriverManager.getConnection(  
                    pro.getProperty("URL"),  
                    pro.getProperty("USER"),  
                    pro.getProperty("PWD"));  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return conn;  
    }  
    //关闭资源的方法  
    public  static void close(ResultSet rs,Statement ps,Connection conn) {  
        if(rs!=null) {  
            try {  
                rs.close();  
            } catch (SQLException e) {        
                e.printStackTrace();  
            }             
        }  
        if(ps!=null) {  
            try {  
                ps.close();  
            } catch (SQLException e) {        
                e.printStackTrace();  
            }             
        }  
        if(conn!=null) {  
            try {  
                conn.close();  
            } catch (SQLException e) {        
                e.printStackTrace();  
            }             
        }         
    }  
}

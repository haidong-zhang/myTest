package com.haidong.database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;
import com.mysql.jdbc.Statement;

public class DBUtil {
	private static Connection conn = null;  
    private static Properties pro = new Properties();  
    //��������,ʹ�þ�̬�飬ֻ��Ҫ����һ��  
    static {  
        try {  
            /** 
             * ���������ļ������ַ�������ѡһ�ֶ����� 
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
    //��ȡConnection���Ӷ���ķ���,ʹ��static����֮�����������е���  
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
    //�ر���Դ�ķ���  
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
    
    public static BoneCPDataSource getDataSource() throws FileNotFoundException, IOException, SQLException
	{

		BoneCPConfig config = new BoneCPConfig();

		config.setPoolName("pool");
		config.setJdbcUrl("jdbc:postgresql://192.168.12.128:5432/postgres?charSet=UTF-8");
		config.setUsername("postgres");
		config.setPassword("123456");
		config.setMinConnectionsPerPartition(0);
		config.setMaxConnectionsPerPartition(2);

		// Default Setting
		config.setPartitionCount(1);
		// config.setStatementsCacheSize(50);

		config.setConnectionTimeoutInMs(30 * 1000);
		config.setConnectionTestStatement("select 1");
		config.setIdleConnectionTestPeriodInMinutes(2);

		//		config.setIdleMaxAgeInSeconds(15);
		//		config.setMaxConnectionAgeInSeconds(30);
		config.setAcquireIncrement(1);

		// config.setTransactionRecoveryEnabled(true);
		config.setQueryExecuteTimeLimitInMs(1 * 60 * 1000);

		BoneCPDataSource ds = new BoneCPDataSource(config);
//		ds.getConnection().close();
		ds.getConnection();

	    System.out.println(config.getAcquireRetryDelayInMs() + "************************");

		return ds;
	}
}

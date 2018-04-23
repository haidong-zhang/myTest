package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlDbUtil {
	 /** 
     * ���ݿ����ӵ�ַ 
     */  
    private static String url ;  
    /** 
     * �û��� 
     */  
    private static String userName ;  
    /** 
     * ���� 
     */  
    private static String password;  
       
    private static String driver;  
   
    /** 
     * װ������ 
     */  
    static {  
        url="jdbc:mysql://127.0.0.1:3306/shimian_test"; 
        userName="root";  
        password="root";  
        driver="org.gjt.mm.mysql.Driver";  
        try {  
            Class.forName(driver);  
        } catch (ClassNotFoundException e) {  
            throw new ExceptionInInitializerError(e);  
        }  
    } 
    
    /** 
     * �������ݿ����� 
     *  
     * @return 
     * @throws SQLException 
     */  
    public static Connection getConnection() throws SQLException {  
        Connection conn = null;  
        conn = DriverManager.getConnection(url, userName, password);  
        return conn;  
    }  
   
    /** 
     * �ͷ����� 
     * @param conn 
     */  
    private static void freeConnection(Connection conn) {  
        try {  
            conn.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
   
    /** 
     * �ͷ�statement 
     * @param statement 
     */  
    private static void freeStatement(Statement statement) {  
        try {  
            statement.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
   
    /** 
     * �ͷ�resultset 
     * @param rs 
     */  
    private static void freeResultSet(ResultSet rs) {  
        try {  
            rs.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
   
    /** 
     * �ͷ���Դ 
     *  
     * @param conn 
     * @param statement 
     * @param rs 
     */  
    public static void free(Connection conn, Statement statement, ResultSet rs) {  
        if (rs != null) {  
            freeResultSet(rs);  
        }  
        if (statement != null) {  
            freeStatement(statement);  
        }  
        if (conn != null) {  
            freeConnection(conn);  
        }  
    }  
   
}

package com.haidong.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConn();
		System.out.println(conn);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from don");
		while(rs.next()){
			System.out.println(rs.getString("id"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getInt("oo"));
		}
	}
}

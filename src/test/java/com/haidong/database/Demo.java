package com.haidong.database;

import java.sql.Connection;

public class Demo {
	public static void main(String[] args) {
		Connection conn = DBUtil.getConn();
		System.out.println(conn);
	}
}

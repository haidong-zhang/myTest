package com.haidong.database;

import java.sql.Connection;
import java.sql.Statement;
import java.util.UUID;

import utils.MySqlDbUtil;


public class ImportData {
	public static void main(String[] args) throws Exception{
		Connection conn = MySqlDbUtil.getConnection();
		
//		String sql = "select FREG_ID from weixin_data";
		Statement stat = conn.createStatement();
//		ResultSet result = stat.executeQuery();
//		int i = 0;
//		while(result.next()){
//			i++;
//		}
		for(int i =1;i<=22388;i++){
			String sql = "update p_mobile_bindingcard_temp set FBINDING_ID ='"+generateUuid()+"' where fid = "+i;
			stat.executeUpdate(sql);
		}
//		result.close();
		stat.close();
		conn.close();
//		System.out.println(conn);
	}
	
	 public static String generateUuid() {
	 		UUID id = UUID.randomUUID();
	 		String[] array = id.toString().split("-");
	 		StringBuffer sb = new StringBuffer();
	 		for (String str : array) {
	 			sb.append(str.toUpperCase());
	 		}
	 		return sb.toString();
	 	}
}

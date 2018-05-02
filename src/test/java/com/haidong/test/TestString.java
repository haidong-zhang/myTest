package com.haidong.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class TestString {
	public static String convert2KangMeiAddress(String address){
		String province = address.substring(0, address.indexOf("省")+1);
		String city = address.substring(address.indexOf("省")+1, address.indexOf("市")+1);
		String area = address.substring(address.indexOf("市")+1, address.indexOf("区")+1);
		String specificAddress = address.substring(address.indexOf("区")+1);
		return province+","+city+","+area+","+specificAddress;
	}
	
	
	@Test
	public void test1(){
		String tt = "<Request><Request>";
		int indexOf = tt.indexOf("<Request>kk");
		System.out.println(indexOf);
	}
	
	@Test
	public void testSplit(){
//		String config = "struts-default.xml,struts-plugin.xml,struts.xml";
//		String[] split = config.split("\\s*[,]\\s*");
//		for (String string : split) {
//			System.out.println(string);
//		}
		
		String str = "O17091400001|O17091400002|O17091400003";
		for(String s:str.split("\\|")){
			System.out.println(s);
		}
	}
	
	@Test
	public void testReplace(){
//		String str = "/upload/oo/";
//		System.out.println(str.replace("/", "\\"));
		String address = "广东省,深圳市,罗湖区,解放路3015号 深圳市中医院一门诊（门诊代煎窗口）";
		System.out.println(address.replaceAll("[,]", ""));
	}
	
	@Test
	public void testRegex(){
		String str = "<  a>a b cccid</a >";
		//不行
		str = str.replaceAll("[\\s&&[^\r\n]]*( :[\r\n][\\s&&[^\r\n]]*)+", "");
		System.out.println(str);
	}
	
	@Test
	public void testMap(){
		Map<String,String> map = new HashMap<String, String>();
		map.put("29", "1");
//		String put = map.put("292v", "2");
		System.out.println(map);
	}
	/**
	 * 测试String和StringBuilder的值传递或者引用传递
	 */
	@Test
	public void testValueDelivery(){
		String s1 = "hello";
		String s2 = "world";
		System.out.println(s1+"..."+s2);
		change(s1,s2);
		System.out.println(s1+"..."+s2);
		
		String s3 = new String("hello");
		String s4 = new String("world");
		change(s3,s4);
		System.out.println(s3+"..."+s4);
		
		StringBuilder sb1 = new StringBuilder("hello");
		StringBuilder sb2 = new StringBuilder("world");
		System.out.println(sb1+"..."+sb2);
		change(sb1,sb2);
		System.out.println(sb1+"..."+sb2);
	}
	
	public void change(String s1,String s2){
		s1 = s2;
		s2 = s1+s2;
	}
	
	public void change(StringBuilder sb1,StringBuilder sb2){
		sb1 = sb2;
		sb2.append(sb1);
	}
	
	@Test
	public void henan(){
		StringBuilder sql = new StringBuilder();
		sql.append(" select pr.forder_id,pr.fhospital_id,pr.fdept_id,pr.fdoctor_id,   ");
		sql.append(" pr.freg_date,pr.ftime_flag,pr.fstart_time,pr.fend_time, pr.fstatus,  ");
		sql.append(" pr.fopen_id ,pr.ffee,pr.ftreat_fee,pd.ftrade_no,   ");
		sql.append(" pd.fpay_type,pr.fdept_name, pr.fdoctor_name, pr.fhospital_name,pr.fpatient_card_no,pd.ftrade_finishdate, ");
		sql.append(" pr.fschedule_id ,pr.fqueue_sn, pr.FCLINIC_SEQ, pr.FHIS_ORDER_ID,pr.FSHIFT_NAME   ");
		sql.append(" from OP.P_MOBILE_APPOINTREGISTER pr  ");
		sql.append(" left join OP.P_MOBILE_PRODUCT_ORDER pd on pr.forder_id=pd.forder_id  ");
		sql.append(" where pr.fhospital_id = '100370001' ");
		sql.append(" and (pr.fstatus = '10' or pr.fstatus = '11' or ( pr.fstatus = '0' and pd.fstatus = 1 ))");
		sql.append(" and pr.fdept_id = 1993 ");
		sql.append(" and pr.fdoctor_id = 1570 ");
		sql.append(" and pr.ftime_flag =  ");
		sql.append(" and pr.freg_date between 2017-10-24 00:00:00 and 2017-10-30 23:59:00");
		System.out.println(sql.toString());

	}
	
	@Test
	public void hql(){
		String str = "from com.kingdeehit.mobile.pat.ipd.domain.PMobileAppointRegister pr and pr.status = 14 and pr.tenantId = ? and pr.cancelDate between ? and ?";
		System.out.println(str.charAt(69));
		
	}
}

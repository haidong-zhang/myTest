//package com.haidong.nativePlaceTrans;
//
//import java.io.FileInputStream;
//import java.util.List;
//
//import net.sf.json.JSONObject;
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.bson.Document;
//import org.bson.conversions.Bson;
//
//import com.kingdeehit.mobile.his.utils.MongoDBHelper;
//import com.mongodb.client.model.Filters;
//
//public class readExcel {
//	MongoDBHelper smdbh = new MongoDBHelper("channel_place_info");
//
//	public void readExcelMethod(String filePath) throws Exception {
//		String value = "";
//		HSSFWorkbook wookbook = new HSSFWorkbook(new FileInputStream(filePath));
//		HSSFSheet sheet = wookbook.getSheetAt(0);
//		int rows = sheet.getPhysicalNumberOfRows();// hang
//		int max_cells = 0;// ��
//		// ��ȡ����У���ʵ���з���������м��п�ֵ�Ļ�����ô������ֵ�ĵط���ֹͣ�ˡ�����������Ҫȡ�������
//		for (int i = 0; i < rows; i++) {
//			HSSFRow row = sheet.getRow(i);
//			if (row != null) {
//				int cells = row.getPhysicalNumberOfCells();
//				if (max_cells < cells) {
//					max_cells = cells;
//				}
//			}
//		}
//		for (int i = 1; i < rows; i++) {
//			HSSFRow row = sheet.getRow(i);
//			if (row != null) {
//				// ������
//				for (int j = 0; j < max_cells; j++) {
//					HSSFCell cell = row.getCell(j);
//					if (cell == null) {
//						value += "NULL,";
//					}
//					if (cell != null) { // �����Ϊ��������ֵ
//						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//					}
//					value = value + cell.getStringCellValue() + ",";
//				}
//			}
//		}
//		String[] k = value.split(",");
//		for (int i = 0; i < k.length - 1; i += 2) {
//			IDCard idc = new IDCard();
//			idc.set_id(com.kingdeehit.mobile.utils.StringUtil.generateUuid());
//			idc.setCard(k[i]);
//			idc.setNativeplace(k[i + 1]);
//			JSONObject json = JSONObject.fromObject(idc);
//			Document doc = Document.parse(json.toString());
//			smdbh.insert(doc);
//		}
//
//	}
//
//	public String selectCard(String card) {
//		Bson bson = Filters.and(Filters.eq("card", card));
//		List<Document> list = smdbh.query(bson);
//		IDCard idc2 = null;
//		for (Document doc : list) {
//			String json = doc.toJson();
//			JSONObject jsono = JSONObject.fromObject(json);
//			idc2  =  (IDCard) JSONObject.toBean(jsono, IDCard.class);
//		}
//		return idc2.getNativeplace();
//	
//
//	}
//
//	public static void main(String[] args) throws Exception {
//		readExcel re = new readExcel();
//		re.readExcelMethod("d:\\���֤����ǰ6λ���������뼮���Ӧ��.xls");
//		System.out.println(re.selectCard("131025"));
//	}
//}
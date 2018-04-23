package com.haidong.http;

import java.io.FileOutputStream;

import Decoder.BASE64Decoder;

public class TestDownloadBillFile {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		String doPost = HttpClientUtils.doPost("http://test3.mhealth100.com/open-api/gateway.do?service=bill.getOriginalBillInfo&version=3.0&tenantId=00363", "<req><tenantId>00363</tenantId><platformId>1</platformId><transTime>2017-12-24</transTime></req>");
		byte[] decodeBuffer = new BASE64Decoder().decodeBuffer(doPost);
		new FileOutputStream("h:/alipay.zip").write(decodeBuffer);
	}
}

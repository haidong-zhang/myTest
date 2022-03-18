package com.haidong.test;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.*;

public class TestPdfWord {

    public static void main(String[] args) throws Exception{
        String s = FileUtils.readWord("C:\\Users\\hxsdd-25\\Desktop\\SPI-MS-2000使用模拟采集配置说明.docx");
//        System.out.println(s);

        String pdfFileText = FileUtils.getPdfFileText("C:\\Users\\hxsdd-25\\Downloads\\nacos.pdf");
        System.out.println(pdfFileText);
    }


    static class FileUtils {
        /**
         * 判断文件是否存在
         *
         * @Title: isExcite
         * @param @param filePath
         * @param @return
         * @return boolean 返回类型
         * @throws
         */
        public static boolean isExcite(String filePath) {
            File file = new File(filePath);
            // 如果文件夹不存在则创建
            if (!file.exists() && !file.isDirectory()) {
                return false;
            } else {
                return true;
            }
        }

        /**
         *
         * @Title: getPdfFileText
         * @Description: 获取指定位置pdf的文件内容
         * @param @param fileName
         * @param @return
         * @param @throws IOException
         * @return String 返回类型
         * @throws
         */
        public static String getPdfFileText(String fileName) throws IOException {
            PdfReader reader = new PdfReader(fileName);
            PdfReaderContentParser parser = new PdfReaderContentParser(reader);
            StringBuffer buff = new StringBuffer();
            TextExtractionStrategy strategy;
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                strategy = parser.processContent(i,
                        new SimpleTextExtractionStrategy());
                buff.append(strategy.getResultantText());
            }
            return buff.toString();
        }

        public static String readWord(String path) {
            String buffer = "";
            try {
                if (path.endsWith(".doc")) {
                    InputStream is = new FileInputStream(new File(path));
                    WordExtractor ex = new WordExtractor(is);
                    buffer = ex.getText();
                    is.close();
                } else if (path.endsWith("docx")) {
                    OPCPackage opcPackage = POIXMLDocument.openPackage(path);
                    POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
                    buffer = extractor.getText();
                } else {
                    System.out.println("此文件不是word文件！");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return buffer;
        }

        /**
         * 替换文件内容
         * @Title: replaceContentToFile
         * @param @param path  文件路径
         * @param @param str   要替换的内容
         * @param @param con   替换称的内容
         * @return void 返回类型
         * @throws
         */
        public static void replaceContentToFile(String path, String str, String con) {
            try {
                if (isExcite(path)) {
                    FileReader read = new FileReader(path);
                    BufferedReader br = new BufferedReader(read);
                    StringBuilder content = new StringBuilder();
                    while (br.ready() != false) {
                        content.append(br.readLine());
                        content.append("\r\n");
                    }
                    int dex = content.indexOf(str);
                    if (dex != -1) {
                        System.out.println("找到标记!");
                    } else {
                        System.out.println("指定标记不存在!");
                    }
                    content.replace(dex, dex, con);
                    br.close();
                    read.close();
                    FileOutputStream fs = new FileOutputStream(path);
                    fs.write(content.toString().getBytes());
                    fs.close();
                } else {
                    System.out.println("文件不存在!");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }




}

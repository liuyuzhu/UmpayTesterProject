package com.umpaytester.payment.order;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FKB2BZipCreateTool {
	static SimpleDateFormat df = new SimpleDateFormat("yyMMdd");//设置日期格式
	static String name="KJPLFK70510005"+df.format(new Date()).toString();
//	static String name="KJFK"+df.format(new Date()).toString()+1111;
	
	static 	String path="E:\\b2b\\";//生成文件存放路径
	static 	String mbPath="E:\\b2B模板\\KJPLFK705100051712113001.xlsx";//xlsx文件模板存放路径
	public static void main(String[] args) {
		 ArrayList list = new ArrayList();
		 list=getB2bExcel(2000,10);
		 for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
  public static ArrayList getB2bExcel(int i ,int k) {
	  ArrayList list = new ArrayList();
	  String order=path+name;
		
		for (int j = 0; j < k; j++) {
			try {
				changeExcel(path+name+i);
				list.add(path+name+i);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		return list;
  }
	
	 
	 public static 	void changeExcel(String fileToBeWrite) throws FileNotFoundException, IOException{
		        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(
		        		mbPath));
		        FileOutputStream out = null;
		        try {
		            out = new FileOutputStream(fileToBeWrite);
//		            System.out.println(fileToBeWrite);
		            workbook.write(out);
		        } catch (IOException e) {
		            e.printStackTrace();
		        } finally {
		            try {
		                out.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		   

	 
	 
	}  
}
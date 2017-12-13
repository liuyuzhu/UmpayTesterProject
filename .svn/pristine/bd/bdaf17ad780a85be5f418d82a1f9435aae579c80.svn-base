package com.umpaytester.payment.order;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FKB2BExcelCreateTool {
	static SimpleDateFormat df = new SimpleDateFormat("yyMMdd");//设置日期格式
	static String name="KJPLFK70510005"+df.format(new Date()).toString();
//	static String name="KJFK"+df.format(new Date()).toString()+1111;
	
	static 	String path="E:\\b2b\\";//生成文件存放路径
	static 	String mbPath="E:\\b2b模板\\KJPLFK705100051712113001.xlsx";//xlsx文件模板存放路径
	public static void main(String[] args) {
		 ArrayList list = new ArrayList();
//		 list=getB2bExcel(2000,10);
		 for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			System.out.println(name);
		}
	}
	
  public static String getB2bExcel() {
//	  ArrayList list = new ArrayList();
	  String order=path+name+getFourRandom().toString()+".xlsx";
		
//		for (int j = 0; j < k; j++) {
//			try {
//				changeExcel(path+name+i+".xlsx");
//				list.add(path+name+i+".xlsx");
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			i++;
//		}
		return order;
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
	 /**
	     * 产生4位随机数(0000-9999)
	     * @return 4位随机数
	     */
	    public static String getFourRandom(){
	        Random random = new Random();
	        String fourRandom = random.nextInt(10000) + "";
	        int randLength = fourRandom.length();
	        if(randLength<4){
	          for(int i=1; i<=4-randLength; i++)
	              fourRandom = "0" + fourRandom  ;
	      }
	        return fourRandom;
	    }
}
package com.umpaytester.payment.order;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FKB2cZipCreateTool {
	static SimpleDateFormat df = new SimpleDateFormat("yyMMdd");//设置日期格式
	static String name="KJFK"+df.format(new Date()).toString();
//	static String name="KJFK"+df.format(new Date()).toString()+1111;
	
	static 	String path="E:\\b2c\\";//生成文件存放路径
	static 	String mbPath="E:\\b2c模板\\b2c模板.xlsx";//xlsx文件模板存放路径
	
	
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
		
		
		//后四位以1000开头，每次执行生成j+n个文件；
		int j =4200;
		int n = 27;
		int x=0;
		//生成文件存放路径  "E:"+File.separatorChar+"b2c"+File.separatorChar  等同于 E:/b2c/
	
		
		String[] txcode= {"01121990","01122030","02223022","02223023","03222024","03223010","03223021","03223022","03223023","03223029","04223010","04223021","04223022","04223023","04223029","05227010","06223010","06223021","06223022","06223023","06223029","07222012","07222022","07222032","08227020","08231030","09228025"};
		
		for (int i = j; i < j+n; i++) {
			FKB2cZipCreateTool.createFile(name+i,txcode[x]);
			x++;
			deleteFile(path+name+i+".txt");
			deleteFile(path+name+i+".xlsx");
			Thread.sleep(1000);
			
		}
		
	}
	
	
	
	 public static boolean deleteFile(String fileName) {
	        File file = new File(fileName);
	        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
	        if (file.exists() && file.isFile()) {
	            if (file.delete()) {
	                System.out.println("删除单个文件" + fileName + "成功！");
	                return true;
	            } else {
	                System.out.println("删除单个文件" + fileName + "失败！");
	                return false;
	            }
	        } else {
	            System.out.println("删除单个文件失败：" + fileName + "不存在！");
	            return false;
	        }

	 }


//	 public static void main(String args[]) {  
	public static void createFile(String name,String txcode) throws FileNotFoundException, IOException {
//		String moban="‪E:\\b2c模板.xlsx";
		 String xlsx = path+name+".xlsx";
		 String txt = path+name+".txt";
		 
		 changeExcel( xlsx,name,txcode);

		  

	        String A = "01121990";
	        String B = "JPY";
	        //生成txt文件
	        String content="70510005|"+txcode+"|"+txcode.charAt(1)+"|KJ0161219317096012345678901210|"+B+"|11000|88000|20170815|102501|20170815||Aptamil奶粉一段Aptamil a1|张博坤|420621199001255114|123456789012345678901234567901|187-1012-9807|N|18710129800|187trade4|UMF1234567890|100|100|100|70510005|GZ|100\r\n" + 
	        		"70510005|"+txcode+"|"+txcode.charAt(1)+"|KJ0161219317096012345678901210|"+B+"|9000|72000|20170815|102501|20170815||Aptamil奶粉一段Aptamil a2|莫巧明|51052119850508797X|123456789012345678901234567901|187-1012-9807|N\r\n" + 
	        		"70510005|"+txcode+"|"+txcode.charAt(1)+"|KJ0161219317096012345678901210|"+B+"|10000|80000|20170815|102501|20170815||Aptamil奶粉一段Aptamil a3|莫巧明|51052119850508797X|123456789012345678901234567901|187-1012-9807|N|||||||||";
	        try {

				BufferedWriter bw = new BufferedWriter(new FileWriter(txt));
				bw.write(content);
				bw.close();
			       File[] srcfile={new File(txt),new File(xlsx)};
			        File zipfile = new File(path+name+".zip");
			        zipFiles(srcfile,zipfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
			    // add this section
			}
	       
	          //压缩文件为压缩包    
	        
	} 
	        
	      
	        
	 
	        
	        
	        
	    
	 
	 public static void zipFiles(File[] srcfile,File zipfile){
		    byte[] buf=new byte[1024];
		    try {
		      //ZipOutputStream类：完成文件或文件夹的压缩
		      ZipOutputStream out=new ZipOutputStream(new FileOutputStream(zipfile));
		      for(int i=0;i<srcfile.length;i++){
		        FileInputStream in=new FileInputStream(srcfile[i]);
		        out.putNextEntry(new ZipEntry(srcfile[i].getName()));
		        int len;
		        while((len=in.read(buf))>0){
		          out.write(buf,0,len);
		        }
		        out.closeEntry();
		        in.close();
		      }
		      out.close();
		      System.out.println("压缩完成.");
		    } catch (Exception e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		  }

	 
	 
	 
	 public static 	void changeExcel(String fileToBeWrite,String order ,String txcode) throws FileNotFoundException, IOException{
		    String fileToBeRead = mbPath; // excel位置
//		    String fileToBeWrite = "E:\\b2c模板1.xlsx"; // excel位置

		        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(
		                fileToBeRead));
		        
		        XSSFSheet sheet = workbook.getSheetAt(0);
		        XSSFRow row=sheet.getRow(2);
		        XSSFCell cell = row.getCell(0);
		        XSSFCell cell3 = row.getCell(2);
		        cell.setCellValue(order);
		        cell3.setCellValue(txcode);

		       
		        FileOutputStream out = null;
		        try {
		            out = new FileOutputStream(fileToBeWrite);
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
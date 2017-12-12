package com.umpaytester.cbewebrest.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.umpaytester.utils.log.Logger;



public class SJHUtil {
    static Logger log=Logger.getLogger(SJHUtil.class);  

	public static String currency="USD";
	public static String batchDate=new SimpleDateFormat("yyyyMMdd").format(new Date());
	public	static String batchNo="SKJ"+new SimpleDateFormat("yyyyMMddssSSS").format(new Date());
	public	static String fileName =  "RFXS_70510002_"+batchDate+"_"+currency+"_"+batchNo+".txt";
//	public	static String fileName =  "RFXS_70510002_20171113_USD_SKJ2017111341131.txt";
	public	static String filePath="D:\\cbeweb_resttest\\txt\\"+fileName;

	public static void createTxt() {

	  //生成txt文件
    String content="70510002|"+batchNo+"|"+batchDate+"|5|10|"+currency+"|\r\n" + 
    		"Payment order start\r\n" + 
    		"7051000217101301|1|667869716|BOC|中国银行北京文慧园支行|青岛凯荣科技有限公司|21050110503500006393711|哈哈|15110189088|"+currency+"|12.00||01122030||\r\n" + 
    		"7051000217101302|1|667869716|BOC|中国银行北京文慧园支行|青岛凯荣科技有限公司|21050110503500006393711|哈哈|15110189088|"+currency+"|12.00||01122030||\r\n" + 
    		"7051000217101303|0|440902198608270069|CCB|张莹|6217003110014723421|18219340978|"+currency+"|12.00||01122030||\r\n" + 
    		"7051000217101304|0|440902198608270069|CCB|张莹|6217003110014723421|18219340978|"+currency+"|12.00||01122030||\r\n" + 
    		"7051000217101305|0|440902198608270069|CCB|张莹|6217003110014723421|18219340978|"+currency+"|12.00||01122030||123456789\r\n" + 
    		"Payment order end\r\n" + 
    		"Order detail start\r\n" + 
    		"7051000217101301|17101301|20170525||||"+currency+"|100.00|E182 x1|1\r\n" + 
    		"7051000217101301|17101302|20170525||||"+currency+"|200.00|E182 x1|1\r\n" + 
    		"7051000217101302|17101303|20170525||||"+currency+"|300.00|E182 x1|1\r\n" + 
    		"7051000217101302|17101304|20170525||||"+currency+"|400.00|E182 x1|1\r\n" + 
    		"7051000217101303|17101305|20170525|204125|20170525|204206|"+currency+"|500.00|Baby Shampoo|1\r\n" + 
    		"7051000217101303|17101306|20170525|204125|20170525|204206|"+currency+"|600.00|Baby Shampoo|1\r\n" + 
    		"7051000217101304|17101307|20170525|204125|20170525|204206|"+currency+"|700.00|Baby Shampoo|1\r\n" + 
    		"7051000217101304|17101308|20170525|204125|20170525|204206|"+currency+"|800.00|Baby Shampoo|1\r\n" + 
    		"7051000217101305|17101309|20160718|204125|20160202|204206|"+currency+"|500.00|Baby Shampoo|1\r\n" + 
    		"7051000217101305|17101310|20160718|204125|20160202|204206|"+currency+"|900.00|Baby Shampoo|1\r\n" + 
    		"Order detail end";

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("开始生成文件："+fileName);
		log.info("生成文件存放路径："+filePath);
	
		
	}
	/**
	 * 
	 * @param ip  ftp机器ip
	 * @param ipPath  ftp机器文件存放路径
	 * @param filePath  本地文件路径
	 * @param fileName  文件名称
	 */
	
	
	 public void upLoad(String ip,String ipPath,String filePath,String fileName) {
		  try {
		   FileInputStream in = new FileInputStream(new File(filePath));
		   boolean flag = FtpUtil.uploadFile(ip,  ipPath, fileName, in);
		  
		   log.info(""+flag);
		  } catch (FileNotFoundException e) {
		   e.printStackTrace();
		  }
		 }
		 
	 
	 
	
	public static void main(String[] args) {
		createTxt();
	}
}



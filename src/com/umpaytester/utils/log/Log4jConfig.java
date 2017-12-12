package com.umpaytester.utils.log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import com.umpaytester.utils.PropsUtil;

public class Log4jConfig {  
    private static boolean isReload = true; 
    public  void load() throws IOException {
    	
    	String propsName="log4j.properties";

        String filePath = this.getClass().getResource("/").getPath().toString()+"config/"+propsName;

        File file=new File(filePath);    
        if(!file.exists())    
        {    
           System.out.println(filePath+"改路径下不存在文件"+propsName);
           System.out.println("更换路径，重新检查");
  		   filePath= PropsUtil.class.getResource("/").getPath().substring(0, PropsUtil.class.getResource("/").getPath().indexOf("WEB-INF"))+File.separator +"config"+File.separator;
  		 System.out.println("该方法是web读取出的路径："+filePath);
  		      
  		 File fp=new File(filePath);    
         if(!file.exists())    
           {  
        	 System.out.println(filePath+"改路径下也不存在文件"+propsName);
           }

        }
    	
    	
    	
    	
    	
    	
    	
    	
    	
//    	 String path = Log4jConfig.class.getClass().getResource("/")  
//                 .getPath()
//                 + "config/log4j.properties";
//                 PropsUtil pu = new PropsUtil();
//          String path=       pu.getPropsFilePath("log4j.properties");
                 
//    	 
//         String path="config/log4j.properties";   
//         System.out.println("log4j configfile path=" + path);  
         PropertyConfigurator.configureAndWatch(filePath,1000);    
    	
//    	FileInputStream inputStream=null;        
//    	ClassLoader cl = Log4jConfig.class.getClassLoader();        
//    	if  (cl !=  null ) {        
//    	         inputStream = (FileInputStream) cl.getResourceAsStream( "config/log4j.properties" );        
//    	}  else {        
//    	       inputStream = (FileInputStream) ClassLoader.getSystemResourceAsStream( "config/log4j.properties" );        
//    	}        
//    	System.out.println(inputStream);
//
//		
//	     PropertyConfigurator.configure(inputStream);
//	     inputStream.close();


    	
    	
    	
    	
    	
    	
    	
//    	
//    	
//     Properties props = new Properties();
//        try {
//			props.load(Log4jConfig.class.getClassLoader().getResourceAsStream("log4j.properties"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}//从输入流中读取属性列表
//         PropertyConfigurator.configure(props);
//  	  
    }  
   
    private static void reload() throws IOException {  
        if (isReload) {  
        	Log4jConfig lj = new Log4jConfig();
        	lj.load();  
        }  
        isReload = false;  
    }  
   
    public void setReload(boolean flag) {  
        isReload = flag;  
    }  
   
    
    /**
     * 初始化log4j配置信息
     * @throws Exception
     */
    public static void initLog4j() throws Exception{
    
           Properties props = new Properties();

    	   props = new Properties();
	        InputStream in = null;
	        
	   //    　<!--第一种，通过类加载器进行获取properties文件流-->
          in = Log4jConfig.class.getClassLoader().getResourceAsStream("config/log4j.properties");

           props.load(in);//从输入流中读取属性列表
           PropertyConfigurator.configure(props);
      
      
    	   in.close();
       
    

    
}
    
    public static void main(String[] args) throws IOException {
    	System.out.println(Log4jConfig.class.getClass().getResource("/")  
                .getPath().replaceAll("/build/classes", "/WebContent")  
                + "config/log4j.properties");
	}
}
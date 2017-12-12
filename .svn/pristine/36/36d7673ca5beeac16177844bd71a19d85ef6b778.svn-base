package com.umpaytester.spayrest.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class ReadFile {

	public static String getRealPath(String fileName){
		
		String basePath=System.getProperty("user.dir");
		String realPath=basePath+"src/config/"+fileName;
		return realPath.replace("\\", "/");
	}
	
	
	
	public static Properties readPropertise(String fileName) throws IOException {
		Properties pro = new Properties();
		InputStream in = Object. class .getResourceAsStream("/src/config/"+fileName);
	    pro.load(in);
		in.close();
		
		return pro;

	}
	
	public static void main(String[] args) throws IOException {
		ReadFile rf= new ReadFile();
		
        Properties prop=ReadFile.readPropertise("config.properties");
        String RunEnvironment=prop.getProperty("RunEnvironment");
         System.out.println(RunEnvironment);
//         
//         
//         String fileName = "config.properties";
//
//         
//             Properties prop = new Properties(); 
////             InputStream in = Object.class.getResourceAsStream(fileName);  
//             InputStream in = this.getClass().getClassLoader().getResourceAsStream(fileName);
//
//
//             try { 
//                 prop.load(in); 
//                String  param1 = prop.getProperty("RunEnvironment").trim(); 
//             } catch (IOException e) { 
//                 e.printStackTrace(); 
//              
//         } 
		
	
         }
	}


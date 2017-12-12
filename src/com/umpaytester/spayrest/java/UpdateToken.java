package com.umpaytester.spayrest.java;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import com.umpaytester.spayrest.bean.GetSpayRestToken;
import com.umpaytester.utils.PropsUtil; 

public class UpdateToken {
	public static void main(String[] args) throws IOException {
//		String token = GetSpayRestToken.getToken();
		String token = "111111111111";
		String filename = "token.properties";
//		System.out.println(token);
			}
   public static void updateToken(String filename,String token) throws IOException {
        PropsUtil pu = new PropsUtil();
//        Properties props = pu.getENVProperties(filename);
//        props.setProperty("token", token);
        
        
        Properties props=pu.getENVProperties(filename);
        String path = pu.envFilePath.replaceAll("build/classes", "src")+filename;
        props.load(new BufferedInputStream(new FileInputStream(path)));
        OutputStream fos = new FileOutputStream(path);  
        System.out.println(path);
        props.setProperty("token", "111111111111");
        props.store(fos,token);
        fos.close();
      

   }
   
}
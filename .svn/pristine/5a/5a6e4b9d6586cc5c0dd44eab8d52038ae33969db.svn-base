package com.yuzhuliu.tesseract;

import java.io.File;  
import java.io.IOException;  

/**
 *作者：刘玉柱
 *日期：2017年11月26日
 *时间：上午5:12:04
 *该类的功能:
**/

public class TestOcr {
	/** 
     * @param args 
     */  
    public static void main(String[] args) {  
        //输入图片地址  
//        String path = "D:\\eclipse-workspace\\UmpayTesterProject\\src\\com\\yuzhuliu\\tesseract\\1.png";     
        String path = "http://10.10.178.35:8080/spEnterprise/confirm.img?";     
//        String path = "http://vip.k780.com:88/?app=img.set_authcode";     
        try {     
            String valCode = new OCR().recognizeText(new File(path), "png");//jpg是图片格式     
            System.out.println(valCode);     
        } catch (IOException e) {     
            e.printStackTrace();     
        } catch (Exception e) {  
            e.printStackTrace();  
        }      
    }  
  
}  



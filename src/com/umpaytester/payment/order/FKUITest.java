package com.umpaytester.payment.order;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.umpaytester.utils.log.Logger;

/**
 *作者：刘玉柱
 *日期：2017年12月11日
 *时间：上午9:29:17
 *该类的功能:
**/

public class FKUITest {
	static Logger log=Logger.getLogger(FKUITest.class);  
    static String ip="10.10.178.35";
    static WebDriver driver;
//    static WebElement element;
    static String  type="b2bapply"; //b2capply
    public static void main(String[] args) {
    	String batchpath="‪E:"+File.separator+File.separator+"b2c"+File.separator+File.separator+"KJFK1712084200.zip";
//    	String batchno="KJFK1712084200"	;
  	  ArrayList list = new ArrayList();

  	list=FKB2BZipCreateTool.getB2bExcel(2000,1);
  	System.out.println(list.get(0).toString());
  	   loginB2b(list.get(0).toString());
	}
    
    private static void loginB2b(String batchpath) {
		
		  log.info("开始登陆企业版");
			String fireFoxPath = "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
			String url = "http://"+ip+":8080/spEnterprise/";
			System.setProperty("webdriver.firefox.bin", fireFoxPath);
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			driver.manage().window().maximize();// 最大化浏览器窗口
			driver.navigate().to(url);
			driver.findElement(By.id("merId")).sendKeys("70510005");// 输入账户
			driver.findElement(By.id("mediaId")).sendKeys("admin");// 输入用户
			driver.findElement(By.id("password")).sendKeys("654941");// 输入密码
			driver.findElement(By.id("code")).sendKeys("1234");// 输入密码
			driver.findElement(By.id("login")).click();
			driver.findElement(By.id("nav357")).click();
			driver.findElement(By.id("b2bapply")).click();
			driver.findElement(By.className("bluebtnb")).click();
//			driver.findElement(By.id("batchFile")).click();
//			driver.findElement(By.id(&quot;batchFile&quot;)).sendKeys(&quot;E:\\b2c\\KJFK1712114203.zip&quot;);

			log.info(batchpath);
			  driver.findElement(By.id("batchFile")).sendKeys(batchpath);
			  driver.findElement(By.id("tijiao")).click();
////			driver.findElement(By.cssSelector("#uploadFIle")).sendKeys(batchpath);
//			driver.findElement(By.id("batchNo")).sendKeys(batchno);// 获取验证码元素
//			log.info(batchno);
//
//			driver.findElement(By.id("btnSubmit")).click();
//			driver.findElement(By.id("batchFile")).sendKeys(batchpath);

	}

}



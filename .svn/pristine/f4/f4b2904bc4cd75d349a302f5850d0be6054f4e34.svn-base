package com.umpaytester.payment.order;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.umpaytester.utils.log.Logger;

/**
 *作者：刘玉柱
 *日期：2017年12月11日
 *时间：上午9:29:17
 *该类的功能:
**/

public class FKB2BUITest {
	static Logger log=Logger.getLogger(FKB2BUITest.class);  
    static String ip="10.10.178.35";
    static WebDriver driver;
//    static WebElement element;
    static String  type="b2bapply"; //b2capply
    public static void main(String[] args) {
  	   loginB2b();
//  	   shenhe();
	}
    
    private static void loginB2b() {
		
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

			FKB2BExcelCreateTool excel= new FKB2BExcelCreateTool()	;
			String batchpath=excel.getB2bExcel();
			log.info(batchpath);
			driver.findElement(By.id("ehdel_upload_text")).sendKeys(batchpath);
			driver.findElement(By.id("batchFile")).sendKeys(batchpath);
			driver.findElement(By.id("tijiao")).click();
			driver.switchTo().frame("myId");
//			dr.findElement(By.id("div1"));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			driver.findElement(By.id("queren")).click();
//			driver.findElement(By.className("bluebtn2")).click();
			driver.switchTo().frame("myId");
			
           
//			.click();
//			Actions action = new Actions(driver);
//			for (int i = 0; i < 9; i++) {
//				action.sendKeys(Keys.TAB);
//				log.info("tab键次数："+i);
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			driver.switchTo() ;bluebtn2
//			driver.findElement(By.xpath("//*[@id=\"myId\"]")).click();
           log.info("上传文件成功");
//           driver.close();
//           driver.quit();
	}
    public static void shenhe() {

//    	String IEPath="C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe";
//        System.setProperty("webdriver.ie.driver", "D:\\eclipse-workspace\\UmpayTesterProject\\src\\config\\IEDriverServer.exe");
//        DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
//        dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//        dc.setCapability("ignoreProtectedModeSettings", true);
//        
//		  WebDriver iedriver = new InternetExplorerDriver(dc);
		String fireFoxPath = "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
		System.setProperty("webdriver.firefox.bin", fireFoxPath);
		 WebDriver iedriver = new FirefoxDriver();
		  iedriver.manage().window().maximize();
		  
//		  iedriver.get("http://www.baidu.com");
		  iedriver.get("http://10.10.178.34:8899/CBE_Service/");
//		iedriver.navigate().to("http://10.10.178.34:8899/CBE_Service/");
		iedriver.findElement(By.id("loginname")).sendKeys("zhangbokun");
		iedriver.findElement(By.id("password")).sendKeys("123456");
		iedriver.findElement(By.id("butLogin")).click();
		Alert alert = iedriver.switchTo().alert();
		alert.accept();
     iedriver.findElement(By.id("SubM3_100_700")).click();
     iedriver.findElement(By.id("SubM3_100_700_200")).click();
     iedriver.switchTo().frame("mainIframe");
     iedriver.findElement(By.id("search")).click();
     try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
    
    
    
    

}



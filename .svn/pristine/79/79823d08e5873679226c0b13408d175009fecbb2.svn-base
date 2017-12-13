package com.yuzhuliu.tesseract;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.WrapsDriver;

import com.umpaytester.utils.log.Logger;

/**
 *作者：刘玉柱
 *日期：2017年12月11日
 *时间：上午9:58:23
 *该类的功能:
**/

public class DownIMG {
	static Logger log=Logger.getLogger(DownIMG.class);  
    static String ip="10.10.178.35";
    static WebDriver driver;
    static WebElement element;
    public static void main(String[] args) {
		
    	login();
//    	getImgFileByScreenshot(element,driver);
	}
private static void login() {
		
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
//			element =driver.findElement(By.id("confirmCode"));// 获取验证码元素
	}

	/**
	*@param WebElement 要截取的验证码
	*@param driver 当前浏览器
	*return 验证码图片
	*/
	public static File getImgFileByScreenshot(WebElement element, WebDriver driver){    
	  if (element == null) throw new NullPointerException("图片元素失败");    
	  WrapsDriver wrapsDriver = (WrapsDriver) element;    //截取整个页面    
	  File scrFile = ((TakesScreenshot)wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);    
	  try {        
	    BufferedImage img = ImageIO.read(scrFile);        
	    int screenshotWidth = img.getWidth();        
	    Dimension dimension = driver.manage().window().getSize();        
	    //获取浏览器尺寸与截图的尺寸
	    double scale = (double) dimension.getWidth() / screenshotWidth;        
	    int eleWidth = element.getSize().getWidth();        
	    int eleHeight = element.getSize().getHeight();        
	    Point point = element.getLocation();        
	    int subImgX = (int)(point.getX() / scale); //获得元素的坐标
	    int subImgY = (int)(point.getY() / scale);        
	    int subImgWight = (int)(eleWidth / scale); //获取元素的宽高
	    int subImgHeight = (int)(eleHeight / scale); 
	    //精准的截取元素图片，
	    BufferedImage dest = img.getSubimage(subImgX, subImgY, subImgWight, subImgHeight);        
	    ImageIO.write(dest, "png", scrFile);    
	  } catch (Exception e) {        
	    e.printStackTrace();    
	  }    
	  return scrFile;
	}



}



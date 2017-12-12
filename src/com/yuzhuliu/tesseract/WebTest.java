package com.yuzhuliu.tesseract;
 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
 
import javax.imageio.ImageIO;
 
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import com.entrym.crawler.util.verifyCode.Captcha;
import com.entrym.crawler.util.verifyCode.DamaUtil;
import com.entrym.domain.SogouInfo;
import com.entrym.domain.Wxinfo;
import com.entrym.util.ConfigUtil;
import com.entrym.util.DateUtil;
import com.entrym.util.HttpUtils;
import com.google.gson.Gson;
import com.vdurmont.emoji.EmojiParser;
 
public class WebTest {
     
    private static final String GET_TITLE="/titles/getxiaoshuo";
        private static final String PATH=new File("config/config.properties").getAbsolutePath();
    private static final String CHROME_HOME=new File("config/chromedriver.exe").getAbsolutePath();
    private static final String CHROME_HOME_LINUX=new File("config/chromedriver").getAbsolutePath();
    private static final String BASEURL=ConfigUtil.reads(PATH, "baseurl");
     
    public static void main(String[] args) throws IOException {
                 
            WebDriver driver=null;
//          System.setProperty("webdriver.gecko.driver", FIREFOX_HOME);
                System.out.println(PATH);
            String osname=System.getProperty("os.name").toLowerCase();
            if(osname.indexOf("linux")>=0){
                System.setProperty("webdriver.chrome.driver", CHROME_HOME_LINUX);
//              driver = new MarionetteDriver();
            }else{
                System.setProperty("webdriver.chrome.driver", CHROME_HOME);
//              driver = new MarionetteDriver();
            }
                 
            driver=new ChromeDriver();
            driver.get("http://weixin.sogou.com/antispider/?from=%2fweixin%3Ftype%3d2%26query%3dz+%26ie%3dutf8%26s_from%3dinput%26_sug_%3dy%26_sug_type_%3d");
            WebElement ele = driver.findElement(By.id("seccodeImage"));
 
            // Get entire page screenshot
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            BufferedImage  fullImg = ImageIO.read(screenshot);
 
            // Get the location of element on the page
            Point point = ele.getLocation();
 
            // Get width and height of the element
            int eleWidth = ele.getSize().getWidth();
            int eleHeight = ele.getSize().getHeight();
 
            // Crop the entire page screenshot to get only element screenshot
            BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
                eleWidth, eleHeight);
            ImageIO.write(eleScreenshot, "png", screenshot);
 
            // Copy the element screenshot to disk
            File screenshotLocation = new File("D:/captcha/test.png");
            FileUtils.copyFile(screenshot, screenshotLocation);
            WebElement classelement = driver.findElement(By.className("p2"));
            String errorText=classelement.getText();
            System.out.println("输出的内容是"+classelement.getText());
            if(errorText.indexOf("用户您好，您的访问过于频繁，为确认本次访问为正常用户行为")>=0){
                System.out.println("*********************");
                DamaUtil util=new DamaUtil();
                    System.out.println("===================");
                    String code="";           //验证码
                    Captcha captcha=new Captcha();
                    captcha.setFilePath("test.png");
                    code = DamaUtil.getCaptchaResult(captcha);
                    System.out.println("打码处理出来的验证码是"+code);
                    WebElement elementsumbit = driver.findElement(By.id("seccodeInput"));
                    // 输入关键字
                    elementsumbit.sendKeys(code);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    // 提交 input 所在的  form
                    elementsumbit.submit();
                    System.out.println("成功");
                   
            }
                 
        }
}
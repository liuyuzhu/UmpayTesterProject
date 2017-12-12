package com.umpaytester.spay.test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.umpaytester.utils.GetSms;
import com.umpaytester.utils.db.QueryDB;
import com.umpaytester.utils.log.Logger;
import com.umpaytester.utils.ssh.GetSmsBySSH;

/**
 *作者：刘玉柱
 *日期：2017年11月14日
 *时间：下午2:57:14
 *该类的功能:
**/

public class DebitCardCbApplyPayShortcutUI {
	static Logger log=Logger.getLogger(DebitCardCbApplyPayShortcutUI.class);  

	public static  HashMap<String , String>  test(String url,String orderid) {
		HashMap map = new HashMap();
		String host=null;
		String sms = null;
		String trace=null;
		String res="下单异常，请重新提交"	;
		String fireFoxPath = "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
		WebDriver driver;

		System.setProperty("webdriver.firefox.bin", fireFoxPath);

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();// 最大化浏览器窗口
		driver.get(url);
		// System.out.println(":test:1");

		driver.navigate().to(url);
		log.info("对跳转页面进行验证");
		
		String page = driver.getPageSource();
		if(page.contains("订单状态不正确")) {
			log.info("订单状态不正确，跳转页面初出错");
			res="订单状态不正确";
			map.put("订单状态：", res);
			driver.quit();
			driver.close();
		}
		driver.findElement(By.id("mobileIdText")).sendKeys("18710129807");
		map.put("upay输入手机号", "18710129807");

		driver.findElement(By.id("login_sms_btn")).click();
		
			 host=url.substring(url.indexOf("ttp://")+6,url.lastIndexOf(":80") );
				map.put("upay所在机器", host);

			log.info("查询地址为："+host);
			QueryDB qd = new QueryDB();
			 trace=qd.queryTraceByOrderId(orderid);
				map.put("订单trace号", trace);

			log.info("根据trace号"+trace+"开始查询验证码");
			GetSmsBySSH getSmsSSH= new GetSmsBySSH();
			
			try {
				Thread.sleep(5000);
				sms=getSmsSSH.getSmsByShell(trace, host);
				map.put("upay登录验证码", sms);

				log.info("获取到的验证码为："+sms);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.info("获取验证码失败,请重新提交下单数据");
				res="获取验证码失败,请重新提交下单数据";
				driver.quit();
			}

	
		driver.findElement(By.id("verifyCode")).sendKeys(sms);
		
		driver.findElement(By.className("loginNextPay")).click();  
		
		driver.findElement(By.id("bankcard1")).click();
		driver.findElement(By.id("birthday")).sendKeys("19900125");
		driver.findElement(By.id("btn")).click();
		String pbgSms="";
		
		try {
			Thread.sleep(3000);
			GetSms getPbgSms = new GetSms();
			 pbgSms=getPbgSms.querySmsByOrderId(orderid);
				map.put("Pbg登录验证码", pbgSms);

		} catch (Exception e) {
			// TODO Auto-generated catch block
		log.info(driver.findElement(By.id("msgVerifyErr")).getTagName());
		log.info("60s后尝试重新获取：点击重新获取" );
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			driver.findElement(By.id("btn")).click();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			log.info(driver.findElement(By.id("msgVerifyErr")).getText());
			log.info("重新获取验证码失败");
		}
		
			
			log.info("查库获取pbg验证码失败，更换为查看日志获取方式");
			
			try {
				GetSmsBySSH getPbgSms= new GetSmsBySSH();
				pbgSms=getPbgSms.getPbgSmsByShell(trace, host);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				log.info("查日志获取pbg验证码失败");
				res="日志查询pbg验证码失败，请重新提交下单数据";
				driver.quit();
				driver.close();
				}
			log.info("成功查询到pbg验证码："+pbgSms);
			
		}
		driver.findElement(By.id("verifyCodeV")).sendKeys(pbgSms);

		driver.findElement(By.id("fastComfirmPayBtn")).click();
		
		if(driver.findElement(By.className("successico")) != null ) {
			log.info(driver.findElement(By.className("successico")).toString() );
			
			map.put("订单号", orderid);
			GetSms query = new GetSms();

			map.put("数据库订单状态",query.queryOrderState(orderid));

      
    	driver.quit();
		}
		
		
		
		
		
		
		
		return map;
		
		
		
	}

}



package com.umpaytester.timer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.mail.MessagingException;

import com.umpaytester.listener.ListenerTest;
import com.umpaytester.spayrest.test.TesRestAll;
import com.umpaytester.spayrest.util.SendMailForMany;
import com.umpaytester.utils.PropsUtil;
import com.umpaytester.utils.log.Logger;
import com.umpaytester.utils.log.TestLog;

/*作者：刘玉柱
 *日期：2017年11月9日
 *时间：下午9:32:56
 *该类的功能:
**/

public class SpayrestTestTimer extends Thread {
    static Logger log=Logger.getLogger(SpayrestTestTimer.class);  

	int time=9999000;
	public void run() {
		while (!this.isInterrupted()) {
			// 线程未中断执行循环
			
           log.info("定时器"+this.getName()+"开始执行:执行频率为30分钟/次");
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	 
//			TestLog testlog = new TestLog();
//			testlog.main(null);

			
//			PropsUtil.main(null);
			
			
			TesRestAll rest = new TesRestAll();
			HashMap<String, Boolean> restResult = null;
			try {
				restResult = rest.test();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
            String restContext=restResult.toString();
//            String context="test";
            if(restContext.contains("false")) {
//			SendMail send = new SendMail();
            	SendMailForMany send = new SendMailForMany();
				try {
					log.info("存在不成功的验证，开始邮件通知相关联系人");
					send.sendMail("接口下单异常，请及时排查！"+restContext,"UAT-REST服务验证(出现即为问题,半小时探测一次):"+ formatter.format(currentTime));
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }else {
            	log.info("本次验证全部通过，无需通知");
            }

			try {

				Thread.sleep(time); // 每隔2000ms执行一次
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// ------------------ 开始执行 ---------------------------
		}

	}
	public static void main(String[] args) {
		SpayrestTestTimer test = new SpayrestTestTimer();
		test.run();
	}
}
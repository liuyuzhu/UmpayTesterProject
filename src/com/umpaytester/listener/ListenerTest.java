package com.umpaytester.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.umpaytester.timer.TimerTest;
import com.umpaytester.utils.log.Logger;
import com.umpaytester.utils.log.TestLog;

/*作者：刘玉柱
 *日期：2017年11月9日
 *时间：下午9:32:38
 *该类的功能:
**/

public class ListenerTest implements ServletContextListener{
    static Logger log=Logger.getLogger(ListenerTest.class);  


	private TimerTest myThread;

	public void contextDestroyed(ServletContextEvent e) {
		if (myThread != null && myThread.isInterrupted()) {
			myThread.interrupt();
			log.info("线程中断");
		}
	}

	public void contextInitialized(ServletContextEvent e) {
		String str = null;
		if (str == null && myThread == null) {
			myThread = new TimerTest();
			myThread.start(); // servlet 上下文初始化时启动 socket
			log.info("线程启动");
		}
	}
}


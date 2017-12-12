package com.umpaytester.timer;

import com.umpaytester.utils.log.TestLog;

/*作者：刘玉柱
 *日期：2017年11月9日
 *时间：下午9:32:56
 *该类的功能:
**/

public class TimerTest extends Thread {
	int time=1000;
	public void run() {
		while (!this.isInterrupted()) {// 线程未中断执行循环


			TestLog testlog = new TestLog();
			testlog.main(null);

			//定时
			try {

				Thread.sleep(time); // 每隔2000ms执行一次
//				Thread.sleep(2000); // 每隔2000ms执行一次
				break;

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// ------------------ 开始执行 ---------------------------
		}

	}
	public static void main(String[] args) {
		TimerTest test = new TimerTest();
		test.run();
	}
}
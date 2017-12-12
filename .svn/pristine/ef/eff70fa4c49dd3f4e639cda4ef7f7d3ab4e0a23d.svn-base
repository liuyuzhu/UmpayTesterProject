package com.umpaytester.spay.test;

import java.io.UnsupportedEncodingException;


/**
 * @author yuzhuliu:
 * @version 创建时间：2017年9月26日 下午11:58:21
 * 类说明
 */

public class ThreadTest {
	
	public static int threadCount=5;//启动线程数量
	public static int threadExcuteCount=1000000;//每个线程执行任务次数，没有数量的时候设置为999999999默认无穷大
	public static int average; //每个任务执行的平均耗时
	public static float tps; //瞬时tps 
	public static int allhits=threadCount*threadExcuteCount; //总执行任务数量
	
	
    public static void main(String[] args) {
    	
    	
    	for (int i = 0; i <threadCount; i++) {
    		Thread th=	new Thread(new Runnable1());
    		th.setName("测试线程"+i);
    		th.start();
		}
    }
} 
class Runnable1 implements Runnable{
    public void run() {
     	
        for (int i = 0; i < 4000; i++) {
        	
             	long startTime=System.currentTimeMillis();//记录开始时间
             	cb_sms_req_shortcut test = new cb_sms_req_shortcut();
             	try {
					test.Test_cb_sms_req_shortcut();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//             	cbPreAuthDirect  test = new cbPreAuthDirect();
//             	try {
//                 	test.main(null);
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
             	long endTime=System.currentTimeMillis();//记录结束时间
             	float excTime=(float)(endTime-startTime);
             	ThreadTest.tps=(float)ThreadTest.threadCount*(1000/excTime);
             	
             	System.out.println(Thread.currentThread().getName()+"||当前线程执行次数："+i+"||耗时为：||"+excTime+"||TPS=||"+ThreadTest.tps+"||执行结果："+test.flag);
             	System.out.println("");
             }
    
        }
    
    
}
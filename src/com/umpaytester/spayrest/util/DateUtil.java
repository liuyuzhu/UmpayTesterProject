package com.umpaytester.spayrest.util;

import java.util.Calendar;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author yuzhuliu:
 * @version ����ʱ�䣺2017��9��4�� ����10:12:49
 * ��˵��
 */
public class DateUtil {
//	static Logger log=LogManager.getLogger(DateUtil.class.getName());  

	public static String  getTimeByCalendar(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);//��ȡ���
        int month=cal.get(Calendar.MONTH)+1;//��ȡ�·�
        int day=cal.get(Calendar.DATE);//��ȡ��
        int hour=cal.get(Calendar.HOUR);//Сʱ
        int minute=cal.get(Calendar.MINUTE);//��           
        int second=cal.get(Calendar.SECOND);//��
        int WeekOfYear = cal.get(Calendar.DAY_OF_WEEK);//һ�ܵĵڼ���
        String date =year+"��"+month+"��"+day+"��"+hour+"ʱ"+minute+"��"+second+"������"+WeekOfYear;
//        log.info(date);
		return date;
    }
	public static String  getTimeByCalendarAdd6h(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);//��ȡ���
        int month=cal.get(Calendar.MONTH)+1;//��ȡ�·�
        int day=cal.get(Calendar.DATE);//��ȡ��
        int hour=cal.get(Calendar.HOUR)+6;//Сʱ
        int minute=cal.get(Calendar.MINUTE);//��           
        int second=cal.get(Calendar.SECOND);//��
        int WeekOfYear = cal.get(Calendar.DAY_OF_WEEK);//һ�ܵĵڼ���
        String date =year+"��"+month+"��"+day+"��"+hour+"ʱ"+minute+"��"+second+"������"+WeekOfYear;
//        log.info(date);
		return date;
    }

}

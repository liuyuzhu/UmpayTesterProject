//:object/ThinkInJavaTestDoc.java
package com.yuzhuliu.study;

import java.util.Date;
import java.util.Random;

import com.umpaytester.utils.log.Logger;

/**
 *作者：刘玉柱
 *日期：2017年11月13日
 *时间：下午2:41:11
 *该类的功能:
**/

public class ThinkInJavaTestDoc {
    static Logger log=Logger.getLogger(ThinkInJavaTestDoc.class);  

	/** Entrv point to class & application
	 * 
	 */
	public static void main(String[] args) {
		log.info("Hello"+(new Date()));
		int i =100;
		log.info("1"+ --i+--i);
		log.info("1"+ i-- + i--);
        Random rand = new Random(47);
        for (int j = 0; j < 6; j++) {
			int c  = rand.nextInt(26)+'a';
			log.info((char) c + ","+c+":");
			switch(c) {
			case 'a':
			case 'c':
			case 'e':
			case 'i':
			case 'o':
			case 'u': log.info("sometimes bad");
			default:log.info("default");
			}
		}
		
	}

} /* Output:(55% match)
  Hello.is   
  *///:~



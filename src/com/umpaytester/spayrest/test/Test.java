package com.umpaytester.spayrest.test;

import java.io.IOException;

/*作者：刘玉柱
 *日期：2017年11月10日
 *时间：下午5:08:13
 *该类的功能:
**/

public class Test {

	public static void main(String[] args) {
		Test_B2C_ServerToServer_AlipayScan test = new Test_B2C_ServerToServer_AlipayScan();
		try {
			test.test();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



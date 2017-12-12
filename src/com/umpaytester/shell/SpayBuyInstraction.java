package com.umpaytester.shell;

import com.umpaytester.utils.ssh.EXEShell;

/**
 *作者：刘玉柱
 *日期：2017年12月11日
 *时间：下午4:06:54
 *该类的功能:生成购汇指令  以36机器为主,38.49用作ftp中间服务器
**/

public class SpayBuyInstraction {
	public static void main(String[] args) {
		createInstraction();
	}
	
	public static void createInstraction() {
		String ip="10.10.178.36";
	    String cmd=""; 
		//登录178.36执行还原明细文件生成命令
		EXEShell.runDistanceShellN(cmd, "mpsp", "mpsp4321", ip);
		
		
	}

}



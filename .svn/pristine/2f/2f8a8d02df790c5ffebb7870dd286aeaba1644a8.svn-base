package com.umpaytester.cbewebrest.test;
import java.util.HashMap;
import java.util.Map;

import com.umpaytester.cbewebrest.CbewebRestBaseTest;
import com.umpaytester.cbewebrest.util.SJHUtil;
import com.umpaytester.utils.OrcaleDBUtil;
import  com.umpaytester.utils.log.Logger;
/**作者：刘玉柱
 *日期：2017年11月13日
 *时间：上午10:06:03
 *该类的功能:测试批次信息查询接口
**/

public class TestBatchesQuery {
	static Logger log=Logger.getLogger(TestBatchesQuery.class);  
   public static void main(String[] args) {
	String batchNo ="SKJ2017111456593";
		String sql="select * from cbe_batchtask where BATCHNO='"+ batchNo+"'";
		String state = OrcaleDBUtil.exeSql(batchNo);
		if(!(state==null)) {
			if(state == "3") {
				log.info(batchNo+"狀態為：失敗");
			}
			if(state == "-99") {
				log.info(batchNo+"狀態為：成功");
			}if(state == "2") { 
				log.info(batchNo+"狀態為：成功");
			}
		}
}
        
}

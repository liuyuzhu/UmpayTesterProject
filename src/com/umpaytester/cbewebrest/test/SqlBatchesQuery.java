package com.umpaytester.cbewebrest.test;
import java.util.HashMap;
import java.util.Map;

import com.umpaytester.cbewebrest.CbewebRestBaseTest;
import com.umpaytester.cbewebrest.util.SJHUtil;
import  com.umpaytester.utils.log.Logger;
/**作者：刘玉柱
 *日期：2017年11月13日
 *时间：上午10:06:03
 *该类的功能:测试批次信息查询接口
**/

public class SqlBatchesQuery {
	static Logger log=Logger.getLogger(SqlBatchesQuery.class);  
   // //批次上传接口上传成功后返回的id
	public static String  TestBatchesQuery(String id) throws Exception {
		String ResMsg = TestBatches.testBatches();
        if(ResMsg.contains("ret_code\":\"0000")) {
    	String	idTemp = ResMsg.substring(ResMsg.indexOf("batches/")+8,ResMsg.indexOf("batches/")+70);
    		id=idTemp.substring(0, idTemp.lastIndexOf("\","));
			log.info("批次上传接口上传成功后返回的id："+id);
		}
		 log.info("----------- 收结汇上传文件批次信息查询接口测试开始--------");
		 
//		id="RB_KNFUUMRQGE3TCMJRGM2DCMJTGF6DEMBRG4YTCMJTGIYDCNZRGEYTGSA";
		 Map<String, Object> m = new HashMap<String, Object>();
		String QueryResMsg=CbewebRestBaseTest.httpGet( "70510002", "http://10.10.178.36:8071/cbeweb_rest/receipt/batches/"+id);
		if(QueryResMsg.contains("ret_code\":\"0000")) {
			 log.info("收结汇批次信息查询接口测试成功");
		}else {
			 log.info("收结汇批次信息查询接口测试失败");
		}
  
		
		
		
		return QueryResMsg;
		

	}
	public static void main(String[] args) {
		try {
			TestBatchesQuery("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        
        
}

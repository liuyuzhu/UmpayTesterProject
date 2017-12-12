package com.umpaytester.cbewebrest.test;
import java.util.HashMap;
import java.util.Map;

import com.umpaytester.cbewebrest.CbewebRestBaseTest;
import com.umpaytester.cbewebrest.util.SJHUtil;
import  com.umpaytester.utils.log.Logger;
/**作者：刘玉柱
 *日期：2017年11月13日
 *时间：上午10:06:03
 *该类的功能:确认付款接口
**/

public class TestBatchesInstructionQuery {
	static Logger log=Logger.getLogger(TestBatchesInstructionQuery.class);  
   // //批次上传接口上传成功后返回的id
	public static String  TestBatchesQuery(String id) throws Exception {
		
		String pay_orderid="7051000217101303";
		id="RB_KNFUUMRQGE3TCMJRGQ2TMNJZGN6DEMBRG4YTCMJUGIYDCNZRGEYTINY";
		String ResMsg=CbewebRestBaseTest.httpGet("70510002", "http://10.10.178.36:8071/cbeweb_rest/receipt/batches/"+id+"/payment/"+pay_orderid);
	
		return ResMsg;
		

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

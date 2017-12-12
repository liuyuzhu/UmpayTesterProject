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

public class TestBatchesInstruction {
	static Logger log=Logger.getLogger(TestBatchesInstruction.class);  
   // //批次上传接口上传成功后返回的id
	public static String  TestBatchesQuery(String id) throws Exception {
		
		Map<String, Object> m = new HashMap<String, Object>();
		Map<String, Object> receipt_amount = new HashMap<String, Object>();
		receipt_amount.put("total", 36);
		receipt_amount.put("currency", "USD");
		
		Map<String, Object> receipt_fee = new HashMap<String, Object>();
		receipt_fee.put("total", 0);
		receipt_fee.put("currency", "USD");
		m.put("receipt_rows", 3);
		m.put("receipt_amount", receipt_amount);
		m.put("receipt_fee", receipt_fee);
		id="RB_KNFUUMRQGE3TCMJRGQ2TMNJZGN6DEMBRG4YTCMJUGIYDCNZRGEYTINY";
		String ResMsg=CbewebRestBaseTest.httpPost(m, "70510002", "http://10.10.178.36:8071/cbeweb_rest/receipt/batches/"+id+"/instruction");
	
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

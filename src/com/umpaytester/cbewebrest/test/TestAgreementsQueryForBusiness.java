package com.umpaytester.cbewebrest.test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.umpaytester.cbewebrest.CbewebRestBaseTest;
import com.umpaytester.cbewebrest.util.RSAUtil;
import com.umpaytester.cbewebrest.util.SJHUtil;
import com.umpaytester.utils.DBUtil;
import com.umpaytester.utils.OrcaleDBUtil;
import  com.umpaytester.utils.log.Logger;

/**
   作者：刘玉柱
 *日期：2017年11月13日
 *时间：上午10:06:03
 *该类的功能:协议号注册查询  对公业务
**/


public class TestAgreementsQueryForBusiness {
	static Logger log=Logger.getLogger(TestAgreementsQueryForBusiness.class);  
    static String agreement = new SimpleDateFormat("yyyyMMddssSSS").format(new Date());
	public static String testAgreementsQuery() throws Exception {
        log.info("----------- 收结汇协议号注册接口对公业务测试开始--------");
		
	  
		Map<String, Object> m = new HashMap<String, Object>();
//		m.put("notify_url", "3");  //  1必填校验通过
		//對私
		Map<String, String> mm = new HashMap<String, String>();
		mm.put("agreement_no",agreement );
		mm.put("account_holder_company_number",agreement+12);
		mm.put("account_holder_company_name","魏超");
		mm.put("company_contact_name","魏超");
		mm.put("company_contact_email","liuyuzhu@umpay.com");
		mm.put("account_bank_branch_name","CITIC");
		mm.put("telephone","13056599956");
		mm.put("account_number",RSAUtil.getStringByRSA("6217710703095380"));
		mm.put("account_bin","CITIC");
		mm.put("account_holder_personal_number",RSAUtil.getStringByRSA("150404199308070250"));
		mm.put("account_holder_personal_name","魏超");
		mm.put("agreement_type","FORBUSINESS");

//		m.put("batch", mm);
	
		String ResMsg=CbewebRestBaseTest.httpPost(mm, "70510002", "http://10.10.178.36:8071/cbeweb_rest/receipt/agreements");
		
		String id =ResMsg.substring(ResMsg.indexOf("id\":\"")+5, ResMsg.indexOf("id\":\"")+20);
		 id =id.substring(0, id.lastIndexOf("\","));
		log.info("协议号注册生成的id："+id);
        log.info("----------- 收结汇协议号注册接口对公业务测试开始--------");

		String queryResMsg=CbewebRestBaseTest.httpGet("70510002", "http://10.10.178.36:8071/cbeweb_rest/receipt/agreements/"+id);

//		String sql="select * from cbe_batchtask where BATCHNO='"+ sjh.batchNo+"'";
//		String state = OrcaleDBUtil.exeSql(sjh.batchNo);
//		if(!(state==null)) {
//			if(state == "3") {
//				log.info(sjh.batchNo+"狀態為：失敗");
//			}
//			if(state == "-99") {
//				log.info(sjh.batchNo+"狀態為：成功");
//			}else {  
//				log.info(sjh.batchNo+"狀態為：yicha");
//			}
//		}
		
		return ResMsg;

	}
	public static void main(String[] args) {
		try {
			testAgreementsQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        
        
}

package com.umpaytester.cbewebrest.test;
import java.util.HashMap;
import java.util.Map;

import com.umpaytester.cbewebrest.CbewebRestBaseTest;
import com.umpaytester.cbewebrest.util.SJHUtil;
import com.umpaytester.utils.DBUtil;
import com.umpaytester.utils.OrcaleDBUtil;
import  com.umpaytester.utils.log.Logger;

/**
   作者：刘玉柱
 *日期：2017年11月13日
 *时间：上午10:06:03
 *该类的功能:测试文件上传通知接口
**/


public class TestBatches {
	static Logger log=Logger.getLogger(TestBatches.class);  
	static String ResMsg=null;

	public static String testBatches() throws Exception {
		
			//DepositMigrate  output_dir  ".build"
		
        log.info("           - 收结汇上传文件测试开始--------");
		//文件自动生成
		SJHUtil sjh= new SJHUtil();
		sjh.createTxt();
		
        //上传txt文件
		String ip="10.10.178.36";
//		String ip="10.10.77.89";
//		String ipPath="/usr/mpsp/data/ftp/merchant/70510002";
		String ipPath="/usr/mpsp/data/ftp/merchant/70510002";
		
		
		sjh.upLoad(ip, ipPath, sjh.filePath, sjh.fileName);
		sjh.upLoad("10.10.38.49", ipPath, sjh.filePath, sjh.fileName);
		
//
	
		
		//文件
//	  String batch_no = null;
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("notify_url", "3");  //  1必填校验通过
		Map<String, String> mm = new HashMap<String, String>();
		mm.put("batch_date",sjh.batchDate );//  1必填校验通过 
		mm.put("batch_no", sjh.batchNo);  //  1必填校验通过 
//		mm.put("batch_no", "SKJ2017111341131");  //  1必填校验通过 
		mm.put("file_name",sjh.fileName);//  1必填校验通过
		mm.put("file_path","/");  //  1必填校验通过 
		mm.put("currency", sjh.currency);//  1必填校验通过
		m.put("batch", mm);
		 ResMsg=CbewebRestBaseTest.httpPost(m, "70510002", "http://10.10.178.36:8071/cbeweb_rest/receipt/batches");
		
		
//		String sql="select * from cbe_batchtask where BATCHNO='"+ sjh.batchNo+"'";
		String state = OrcaleDBUtil.exeSql(sjh.batchNo);
		if(!(state==null)) {
			if(state.equals("3")) {
				log.info(sjh.batchNo+"狀態為：失敗");
			}
			if(state.equals("-99")) {
				log.info(sjh.batchNo+"狀態為：成功");
			}if(state.equals("2")) {  
				log.info(sjh.batchNo+"狀態為：为空   ");
			}
		}
		return ResMsg;
		
	}
	public static void main(String[] args) {
		try {
			testBatches();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        
        
}

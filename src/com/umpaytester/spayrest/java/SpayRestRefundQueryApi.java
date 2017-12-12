package com.umpaytester.spayrest.java;

import java.util.ArrayList;
import java.util.List;

import com.umf.api.payments.Amount;
import com.umf.api.payments.BankCard;
import com.umf.api.payments.Order;
import com.umf.api.payments.Payer;
import com.umf.api.payments.PayerInfo;
import com.umf.api.payments.Payment;
import com.umf.api.payments.QrCodeScan;
import com.umf.api.payments.Refund;
import com.umf.api.payments.RiskInfo;
import com.umf.api.payments.SubOrder;
import com.umf.api.payments.WechatInApp;
import com.umf.api.payments.WechatInAppWeb;
import com.umf.api.payments.enums.CitizenIdType;
import com.umf.api.payments.enums.InterfaceType;
import com.umf.api.payments.enums.PaymentMethod;
import com.umf.base.ReqUMF;
import com.umf.base.rest.APIContext;
import com.umpaytester.spayrest.bean.SpayRestBean;
import com.umpaytester.utils.log.Logger;

/**
 *作者：刘玉柱
 *日期：2017年11月21日
 *时间：下午8:42:58
 *该类的功能:
**/

public class SpayRestRefundQueryApi {
	static Logger log=Logger.getLogger(SpayRestRefundQueryApi.class);  
	   public static  String result = ""	;

	public  static String refundQuery (SpayRestBean bean) {
		bean.setUrl(bean.refundQueryUrl);
		log.info(bean.getPayment_method());

		APIContext apiContext = APIContext(bean);
		

		try {
			result="";
			result= ReqUMF.get(apiContext);	
			log.info(result);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("退费查询失败"+e);
		}
		// TODO Auto-generated method stub
		
//		log.info(result);
		return result;
		
	}
	
	
	
	
	
public static APIContext APIContext(SpayRestBean bean)  {
		
	    APIContext apiContextBase = new APIContext();

		apiContextBase.setClientId(bean.getClientId());
		apiContextBase.setClientSecret(bean.getClientSecret());
		apiContextBase.setOauthUrl(bean.getOauth_url());
		
		apiContextBase.setToken(bean.token);
		apiContextBase.setCrtPath(bean.crtPath);
		apiContextBase.setP8Path(bean.p8Path);
		apiContextBase.setUMFp8Path(bean.UMFp8Path);
//		apiContextBase.setType("POST");
		apiContextBase.setUrl(bean.getUrl());
		apiContextBase.setRSACharset("GBK");
//		log.info("+++++");
		return apiContextBase;
		
		}
	
	
	


}



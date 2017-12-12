package com.umpaytester.spayrest.bean;

import java.io.IOException;

import org.seleniumhq.jetty7.util.log.Log;

import com.umpaytester.spayrest.test.GetClientToken;
import com.umpaytester.utils.PropsUtil;
import com.umpaytester.utils.log.Logger;

/**
 *作者：刘玉柱
 *日期：2017年11月21日
 *时间：下午6:33:03
 *该类的功能:
**/

public class SpayRestBean {
    static Logger log=Logger.getLogger(SpayRestBean.class); 
    public static String url;
	public static String ID="";
	public static String id=url+ID;
	public static String orderResult="";
	public static String varifyResult="";
	public static String payConfirmResult="";
	public static String queryResult="";
	public static String refundResult="";
	public static String refundQueryResult="";
	public static String declareResult="";

	public static String varifyUrl=url+ID+"/verify";
	public static String payConfirmUrl=url+ID+"/execute";
	public static String queryUrl=url+ID;
	public static String refundUrl="";
	public static String refundQueryUrl="";
	public static String declareUrl=url+ID+"/apply_to_customs";
	public static String varifyCode="";
    
    
    String notify_url;
    String ret_url;
    String mer_check_date;
    String pay_elements;
    String settle_date;
    String execute_success_time;
    String is_from_US;
	String mer_id;//商户号
	String gate_id;
	String last_four_cardid;
	String usr_pay_agreement_id;
	String usr_busi_agreement_id;
	String qr_code_url;
	String open_id;

	String	oauth_url;	//token验证地址  oauthUrl
	public String	UMFp8Path;	//联动公钥
	public String	p8Path;	//商户私钥
	public String	crtPath;	//联动加密
	String	query_url;	//查询地址
	String	refund_url;	//退费地址
	String	exe_url;	//支付地址
	String	verify_url;	//短信地址
	String	RSACharset;	//加密编码格式
	String	clientSecret;	//客户端密码
	String	clientId;	//客户端id
	public String	token;	//token
	String	refundNo;	//退费单号
	String	refundAmount;	//退费金额
	String	total_cny;	//总金额
	String	exchange_rate;	//汇率
	String	org_amount;	//原订单金额
	String	mer_reference_id;	//订单号
	String	mer_date;	//订单日期
	String	subamount1;	//金额
	String	amount;	//金额
	String	order_summary;	//订单明细
	String	expire_time;	//超时时间
	String	user_ip;	//用户ip
	String	mer_sub_reference_id;	//子单号
	String	trans_code;	//货物编码
	String	is_customs;	//是否报关
	String	invoice_id;	//商户在联动唯一标识
	String	mer_item_id;	//货物单号
	String	type;	//货物类型
	String	name;	//持卡人名字
	String	quantity;	//
	String	description;	//商品描述
	String	payment_method;	//支付类型
	String	bank_code;	//银行编码
	String	interface_type;	//接口类型
	String	external_customer_id;	//
	String	qr_code_scan;	//
	String	payer_agreement;	//
	String	phone;	//手机号
	String	number;	//银行卡号
	String	citizen_id_number;	//身份证号码
	String	citizen_id_type;	//证件类型
	String	payer_name;	//付款人
	String	valid_date;	//银行卡有效期
	String	cvv2;	//cvv2
	String	state;	//银行卡状态
	String	verify_code;	//短信验证码
	String	trans_type;	//
	String	receiver_name;	//收货人
	String	receiver_moblie_id;	//收货人手机号
	String	shipping_address;	//收货地址
	String	registration_email;	//注册邮件地址
	String	registration_moblie_id;	//注册手机号
	String	identify_card_number;	//身份证号码
	String	device_identification;	//
	String	device_type;	//
	String	registration_time;	//注册时间
	String	user_agent;	//
	String	success_transactions_number;	//
	String	goods_type;	//货物类型
	String	real_name;	//真实姓名
	String	business_type;	//业务种类
	String	currency;	//币种
	
	public static String getID() {
		return ID;
	}
	public static void setID(String iD) {
		ID = iD;
	}
	public static String getId() {
		return id;
	}
	public static void setId(String id) {
		SpayRestBean.id = id;
	}
	public static String getOrderResult() {
		return orderResult;
	}
	public static void setOrderResult(String orderResult) {
		SpayRestBean.orderResult = orderResult;
	}
	public static String getVarifyResult() {
		return varifyResult;
	}
	public static void setVarifyResult(String varifyResult) {
		SpayRestBean.varifyResult = varifyResult;
	}
	public static String getPayConfirmResult() {
		return payConfirmResult;
	}
	public static void setPayConfirmResult(String payConfirmResult) {
		SpayRestBean.payConfirmResult = payConfirmResult;
	}
	public static String getQueryResult() {
		return queryResult;
	}
	public static void setQueryResult(String queryResult) {
		SpayRestBean.queryResult = queryResult;
	}
	public static String getRefundResult() {
		return refundResult;
	}
	public static void setRefundResult(String refundResult) {
		SpayRestBean.refundResult = refundResult;
	}
	public static String getRefundQueryResult() {
		return refundQueryResult;
	}
	public static void setRefundQueryResult(String refundQueryResult) {
		SpayRestBean.refundQueryResult = refundQueryResult;
	}
	public static String getDeclareResult() {
		return declareResult;
	}
	public static void setDeclareResult(String declareResult) {
		SpayRestBean.declareResult = declareResult;
	}
	public static String getVarifyUrl() {
		return varifyUrl;
	}
	public static void setVarifyUrl(String varifyUrl) {
		SpayRestBean.varifyUrl = varifyUrl;
	}
	public static String getPayConfirmUrl() {
		return payConfirmUrl;
	}
	public static void setPayConfirmUrl(String payConfirmUrl) {
		SpayRestBean.payConfirmUrl = payConfirmUrl;
	}
	public static String getQueryUrl() {
		return queryUrl;
	}
	public static void setQueryUrl(String queryUrl) {
		SpayRestBean.queryUrl = queryUrl;
	}
	public static String getRefundUrl() {
		return refundUrl;
	}
	public static void setRefundUrl(String refundUrl) {
		SpayRestBean.refundUrl = refundUrl;
	}
	public static String getRefundQueryUrl() {
		return refundQueryUrl;
	}
	public static void setRefundQueryUrl(String refundQueryUrl) {
		SpayRestBean.refundQueryUrl = refundQueryUrl;
	}
	public static String getDeclareUrl() {
		return declareUrl;
	}
	public static void setDeclareUrl(String declareUrl) {
		SpayRestBean.declareUrl = declareUrl;
	}
	public static String getVarifyCode() {
		return varifyCode;
	}
	public static void setVarifyCode(String varifyCode) {
		SpayRestBean.varifyCode = varifyCode;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSubamount1() {
		return subamount1;
	}
	public void setSubamount1(String subamount1) {
		this.subamount1 = subamount1;
	}
	public String getMer_id() {
		return mer_id;
	}
	public void setMer_id(String mer_id) {
		this.mer_id = mer_id;
	}
	
	public String getUMFp8Path() {
		return UMFp8Path;
	}
	public void setUMFp8Path(String uMFp8Path) {
		UMFp8Path = uMFp8Path;
	}
	
	
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public String getRet_url() {
		return ret_url;
	}
	public void setRet_url(String ret_url) {
		this.ret_url = ret_url;
	}
	public String getMer_check_date() {
		return mer_check_date;
	}
	public void setMer_check_date(String mer_check_date) {
		this.mer_check_date = mer_check_date;
	}
	public String getPay_elements() {
		return pay_elements;
	}
	public void setPay_elements(String pay_elements) {
		this.pay_elements = pay_elements;
	}
	public String getSettle_date() {
		return settle_date;
	}
	public void setSettle_date(String settle_date) {
		this.settle_date = settle_date;
	}
	public String getExecute_success_time() {
		return execute_success_time;
	}
	public void setExecute_success_time(String execute_success_time) {
		this.execute_success_time = execute_success_time;
	}
	public String getIs_from_US() {
		return is_from_US;
	}
	public void setIs_from_US(String is_from_US) {
		this.is_from_US = is_from_US;
	}
	public String getGate_id() {
		return gate_id;
	}
	public void setGate_id(String gate_id) {
		this.gate_id = gate_id;
	}
	public String getLast_four_cardid() {
		return last_four_cardid;
	}
	public void setLast_four_cardid(String last_four_cardid) {
		this.last_four_cardid = last_four_cardid;
	}
	public String getUsr_pay_agreement_id() {
		return usr_pay_agreement_id;
	}
	public void setUsr_pay_agreement_id(String usr_pay_agreement_id) {
		this.usr_pay_agreement_id = usr_pay_agreement_id;
	}
	public String getUsr_busi_agreement_id() {
		return usr_busi_agreement_id;
	}
	public void setUsr_busi_agreement_id(String usr_busi_agreement_id) {
		this.usr_busi_agreement_id = usr_busi_agreement_id;
	}
	public String getQr_code_url() {
		return qr_code_url;
	}
	public void setQr_code_url(String qr_code_url) {
		this.qr_code_url = qr_code_url;
	}
	public String getOpen_id() {
		return open_id;
	}
	public void setOpen_id(String open_id) {
		this.open_id = open_id;
	}
	public String getOauth_url() {
		return oauth_url;
	}
	public void setOauth_url(String oauth_url) {
		this.oauth_url = oauth_url;
	}
	public String getP8Path() {
		return p8Path;
	}
	public void setP8Path(String p8Path) {
		this.p8Path = p8Path;
	}
	public String getCrtPath() {
		return crtPath;
	}
	public void setCrtPath(String crtPath) {
		this.crtPath = crtPath;
	}
	public String getQuery_url() {
		return query_url;
	}
	public void setQuery_url(String query_url) {
		this.query_url = query_url;
	}
	public String getRefund_url() {
		return refund_url;
	}
	public void setRefund_url(String refund_url) {
		this.refund_url = refund_url;
	}
	public String getExe_url() {
		return exe_url;
	}
	public void setExe_url(String exe_url) {
		this.exe_url = exe_url;
	}
	public String getVerify_url() {
		return verify_url;
	}
	public void setVerify_url(String verify_url) {
		this.verify_url = verify_url;
	}
	public String getRSACharset() {
		return RSACharset;
	}
	public void setRSACharset(String rSACharset) {
		RSACharset = rSACharset;
	}
	
	
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRefundNo() {
		return refundNo;
	}
	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}
	public String getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}
	public String getTotal_cny() {
		return total_cny;
	}
	public void setTotal_cny(String total_cny) {
		this.total_cny = total_cny;
	}
	public String getExchange_rate() {
		return exchange_rate;
	}
	public void setExchange_rate(String exchange_rate) {
		this.exchange_rate = exchange_rate;
	}
	public String getOrg_amount() {
		return org_amount;
	}
	public void setOrg_amount(String org_amount) {
		this.org_amount = org_amount;
	}
	public String getMer_reference_id() {
		return mer_reference_id;
	}
	public void setMer_reference_id(String mer_reference_id) {
		this.mer_reference_id = mer_reference_id;
	}
	public String getMer_date() {
		return mer_date;
	}
	public void setMer_date(String mer_date) {
		this.mer_date = mer_date;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getOrder_summary() {
		return order_summary;
	}
	public void setOrder_summary(String order_summary) {
		this.order_summary = order_summary;
	}
	public String getExpire_time() {
		return expire_time;
	}
	public void setExpire_time(String expire_time) {
		this.expire_time = expire_time;
	}
	public String getUser_ip() {
		return user_ip;
	}
	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	public String getMer_sub_reference_id() {
		return mer_sub_reference_id;
	}
	public void setMer_sub_reference_id(String mer_sub_reference_id) {
		this.mer_sub_reference_id = mer_sub_reference_id;
	}
	public String getTrans_code() {
		return trans_code;
	}
	public void setTrans_code(String trans_code) {
		this.trans_code = trans_code;
	}
	public String getIs_customs() {
		return is_customs;
	}
	public void setIs_customs(String is_customs) {
		this.is_customs = is_customs;
	}
	public String getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(String invoice_id) {
		this.invoice_id = invoice_id;
	}
	public String getMer_item_id() {
		return mer_item_id;
	}
	public void setMer_item_id(String mer_item_id) {
		this.mer_item_id = mer_item_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getBank_code() {
		return bank_code;
	}
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}
	public String getInterface_type() {
		return interface_type;
	}
	public void setInterface_type(String interface_type) {
		this.interface_type = interface_type;
	}
	public String getExternal_customer_id() {
		return external_customer_id;
	}
	public void setExternal_customer_id(String external_customer_id) {
		this.external_customer_id = external_customer_id;
	}
	public String getQr_code_scan() {
		return qr_code_scan;
	}
	public void setQr_code_scan(String qr_code_scan) {
		this.qr_code_scan = qr_code_scan;
	}
	public String getPayer_agreement() {
		return payer_agreement;
	}
	public void setPayer_agreement(String payer_agreement) {
		this.payer_agreement = payer_agreement;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCitizen_id_number() {
		return citizen_id_number;
	}
	public void setCitizen_id_number(String citizen_id_number) {
		this.citizen_id_number = citizen_id_number;
	}
	public String getCitizen_id_type() {
		return citizen_id_type;
	}
	public void setCitizen_id_type(String citizen_id_type) {
		this.citizen_id_type = citizen_id_type;
	}
	public String getPayer_name() {
		return payer_name;
	}
	public void setPayer_name(String payer_name) {
		this.payer_name = payer_name;
	}
	public String getValid_date() {
		return valid_date;
	}
	public void setValid_date(String valid_date) {
		this.valid_date = valid_date;
	}
	public String getCvv2() {
		return cvv2;
	}
	public void setCvv2(String cvv2) {
		this.cvv2 = cvv2;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getVerify_code() {
		return verify_code;
	}
	public void setVerify_code(String verify_code) {
		this.verify_code = verify_code;
	}
	public String getTrans_type() {
		return trans_type;
	}
	public void setTrans_type(String trans_type) {
		this.trans_type = trans_type;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getReceiver_moblie_id() {
		return receiver_moblie_id;
	}
	public void setReceiver_moblie_id(String receiver_moblie_id) {
		this.receiver_moblie_id = receiver_moblie_id;
	}
	public String getShipping_address() {
		return shipping_address;
	}
	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}
	public String getRegistration_email() {
		return registration_email;
	}
	public void setRegistration_email(String registration_email) {
		this.registration_email = registration_email;
	}
	public String getRegistration_moblie_id() {
		return registration_moblie_id;
	}
	public void setRegistration_moblie_id(String registration_moblie_id) {
		this.registration_moblie_id = registration_moblie_id;
	}
	public String getIdentify_card_number() {
		return identify_card_number;
	}
	public void setIdentify_card_number(String identify_card_number) {
		this.identify_card_number = identify_card_number;
	}
	public String getDevice_identification() {
		return device_identification;
	}
	public void setDevice_identification(String device_identification) {
		this.device_identification = device_identification;
	}
	public String getDevice_type() {
		return device_type;
	}
	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	public String getRegistration_time() {
		return registration_time;
	}
	public void setRegistration_time(String registration_time) {
		this.registration_time = registration_time;
	}
	public String getUser_agent() {
		return user_agent;
	}
	public void setUser_agent(String user_agent) {
		this.user_agent = user_agent;
	}
	public String getSuccess_transactions_number() {
		return success_transactions_number;
	}
	public void setSuccess_transactions_number(String success_transactions_number) {
		this.success_transactions_number = success_transactions_number;
	}
	public String getGoods_type() {
		return goods_type;
	}
	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getBusiness_type() {
		return business_type;
	}
	public void setBusiness_type(String business_type) {
		this.business_type = business_type;
	}

	
	public  void  init() {

		PropsUtil pu = new PropsUtil();
	p8Path=pu.getPropsFilePath("testSpay.key.p8");
	UMFp8Path=pu.getPropsFilePath("testUmpay.key.p8");
	crtPath=pu.getPropsFilePath("testUmpay.cert.crt");
    GetClientToken getToken= new GetClientToken();
    try {
		token = getToken.getToke1();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		log.info("获取token失败");
	}
    
	
	}
	public static void main(String[] args) {
		SpayRestBean spayRestBean = new SpayRestBean();
		spayRestBean.init();
		log.info(spayRestBean.token);
	}

}



package com.umpaytester.spayrest.util;

public class GetURL {
	
	public static  String getSmsUrl(String response) {
		return response.substring(response.indexOf("sms_verify\",\"method\":\"GET\",\"href\":\"")+35, response.lastIndexOf("\"}]}")).toString();
	}
	public static  String getPayUrl(String response) {
		return response.substring(response.indexOf("{\"ref\":\"self\",\"method\":\"GET\",\"href\":\"")+37, response.lastIndexOf("\"},{\"ref\":\"sms_verify\"")).toString();
	}
	public static  String getRefundUrl(String response) {
		return response.substring(response.indexOf("{\"ref\":\"self\",\"method\":\"GET\",\"href\":\"")+37, response.lastIndexOf("\"},{\"ref\":\"sms_verify\"")).toString();
	}
	
	
	public static void main(String[] args) {
		String response="{\"meta\":{\"ret_msg\":\"successful transaction\",\"ret_code\":\"0000\"},\"payment\":{\"pay_elements\":\"\",\"risk_info\":{\"trans_type\":\"02\"},\"id\":\"PAY_GI3TCMBRHEYTKMJVGM4TQNBWGQZDAMJXGEYDCOON\",\"state\":\"WAIT_BUYER_PAY\",\"notify_url\":\"http://10.10.178.34:8081/spaytest/notify0000V4.jsp\",\"payer\":{\"bank_code\":\"CITIC\",\"business_type\":\"B2C\",\"interface_type\":\"SERVER_TO_SERVER\",\"payment_method\":\"DEBIT_CARD\",\"payer_info\":{\"bank_card\":{\"number\":\"\",\"cvv2\":\"\",\"valid_date\":\"\",\"citizen_id_number\":\"\",\"phone\":\"\",\"citizen_id_type\":\"IDENTITY_CARD\",\"payer_name\":\"\"},\"payer_agreement\":{\"usr_busi_agreement_id\":\"\",\"usr_pay_agreement_id\":\"\"}}},\"ret_url\":\"http://10.10.178.34:8081/spaytest/notify0000V4.jsp\",\"is_from_US\":\"Y\",\"order\":{\"amount\":{\"total\":\"200.04\",\"currency\":\"CNY\"},\"sub_orders\":[{\"mer_sub_reference_id\":\"10191226212\",\"trans_code\":\"01121990\",\"amount\":{\"total\":\"100.02\",\"currency\":\"CNY\"},\"is_customs\":\"true\",\"items\":[{\"amount\":{\"total\":\"50.02\",\"currency\":\"CNY\"},\"quantity\":\"2\",\"mer_item_id\":\"10191226221\",\"name\":\"banana\",\"description\":\"banana\",\"type\":\"FOOD\"},{\"amount\":{\"total\":\"50.00\",\"currency\":\"CNY\"},\"quantity\":\"3\",\"mer_item_id\":\"10191226222\",\"name\":\"yifu\",\"description\":\"yifu\",\"type\":\"ELECTRONIC\"}]},{\"mer_sub_reference_id\":\"10191226211\",\"trans_code\":\"03223010\",\"amount\":{\"total\":\"100.02\",\"currency\":\"CNY\"}}],\"mer_date\":\"20171019\",\"expire_time\":\"360\",\"mer_reference_id\":\"2017101912262\",\"order_summary\":\"maimaimai\"}},\"links\":[{\"ref\":\"self\",\"method\":\"GET\",\"href\":\"http://10.10.179.36:8071/spay_rest/payments/payment/PAY_GI3TCMBRHEYTKMJVGM4TQNBWGQZDAMJXGEYDCOON\"},{\"ref\":\"sms_verify\",\"method\":\"GET\",\"href\":\"http://10.10.179.36:8071/spay_rest/payments/payment/PAY_GI3TCMBRHEYTKMJVGM4TQNBWGQZDAMJXGEYDCOON/verify\"}]}\r\n" + 
				"";
		String getSmsUrl = getSmsUrl(response);
		String getPayUrl = getPayUrl(response);
		String getRefundUrl = getPayUrl(response);
		System.out.println(getPayUrl);
		System.out.println(getSmsUrl);
		System.out.println(getRefundUrl);
		
	}
}

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.*" %>   
<%@ page import="java.util.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
	<style>				
			.PaymentMethod{                    	
				width: 200%; 
				height: 100%;
				border:5px solid blue;
				padding:5px;
				background-color:transparent;
			
			}
						.env{                    	
				width: 200%; 
				height: 100%;
				border:10px solid blue;
				padding:5px;
			
			}
						
						.trans_code{                    	
				width: 200%; 
				height: 100%;
				border:10px solid blue;
				padding:5px;
			
			}
			
			.div select{
				width:200px;
			}
			
			.div select option{
				width:150px;
				height:30px;
			}
			

		</style>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		
		<title>SpayRestAPI</title>
	</head>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	String date = format.format(new Date());
	String orderId=date+(Math.round(Math.random()*800000)+100000)+"";
	%>
	<body >
<script type="text/javascript">
	function test(){
		var a = document.getElementById("env").value;
		document.getElementById("ret_url").value = a + "spaytest/notify0000V4.jsp";
		document.getElementById("notify_url").value = a + "spaytest/notify0000V4.jsp";
		document.getElementById("url").value = a + "spay_rest/payments/payment";
		document.getElementById("oauth_url").value = a + "spay_rest/oauth/authorize";
	
	}
	function check(){
		var a = document.getElementById("payment_method").value;
		if(a =="NOT_APPLICABLE"){
			document.getElementById("InterfaceType").value = "SERVER_TO_WEB";
		}else{
			document.getElementById("InterfaceType").value = "SERVER_TO_SERVER";
		}
		
	}
</script>
		<form name="orderApi" method="post" action="/UmpayTesterProject/SpayRestOrderApiServlet">
			<input type=hidden name="type" value="RSA" />
			<input type="hidden" name="charset" value="UTF-8" />	  
			<input type=hidden name="res_format" value="HTML" />
			<input type=hidden name="version" value="4.0" />

			<input type=hidden name="type" value="POST" />
			<input type=hidden name="RSACharset" value="GBK" />
	
					<table style="100%">
			<tr>
			<td  >环境选择<label style="color: red">*</label></td>
					<td style="height: 30px;" valign="middle">
					<div class = "env">
					<select   id="env" name="env" onchange="test()" style="width: 45%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;">
                                                <option value="http://10.10.178.34:8071/" >http://10.10.178.34</option>
                                                <option value="http://10.10.178.35:8071/" >http://10.10.178.35</option>
                                                <option value="http://10.10.178.36:8071/" selected="selected" >http://10.10.178.36</option>
					                            <!--	<option value="http://10.10.178.93:8081" >http://10.10.178.93:8081</option>-->
					</select></div></td>
					
							<td>PaymentMethod<label style="color: red">*</label></td>
					<td style="height: 30px;" valign="middle">
					<div class = "payment_method">
					   <select  onchange="check()"  name="payment_method" id="payment_method" style="width: 45%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;">
                        <option  value="CREDIT_CARD" selected="selected"  >信用卡CREDIT_CARD</option>
						<option  value="DEBIT_CARD"   >借记卡</option>
						<option   value="WECHAT_SCAN" >微信主扫</option>
						<option  value="ALIPAY_SCAN" >支付宝主扫</option>
						<option  value="WECHAT_IN_APP" >微信APP支付</option>
						<option  value="WECHAT_WEB" >微信公众号支付</option>
			     <!--  	<option  value="NOT_APPLICABLE" >NOT_APPLICABLE</option>-->	
					</select>
					</div></td>
					<td>币      种<label style="color: red">*</label></td>
					<td style="height: 30px;" valign="middle">
					<div class = "PaymentMethod">
					   <select    name="currency" id="currency" style="width: 45%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;">
			<option value="USD" selected="selected">美元</option>
			<option value="CNY" >人民币</option>
			<option value="EUR">欧元</option>
			<option value="HKD">港币</option>
			<option value="JPY">日元</option>
			<option value="GBP">英镑</option>
			<option value="AUD">澳大利亚元</option>
			<option value="CAD">加元</option>
			<option value="NZD">新西兰元</option>
			<option value="SGD">新加坡元</option>
			<option value="MOP">澳门元</option>
			<option value="CHF">瑞士法郎</option>
			<option value="SEK">瑞典克朗</option>
			<option value="DKK">丹麦克朗</option>
			<option value="NOK">挪威克朗</option>
					</select>
					</div></td>
					
  
				<tr>
					
								<td style="height: 30px;" valign="middle">BusinessType</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text id="business_type" name="business_type" value="B2C" /></td>
	<td style="height: 30px;" valign="middle">接口类型</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text id="interface_type"  name="interface_type"  value="SERVER_TO_SERVER" /></td>
   <td style="height: 30px;" valign="middle">订单过期时常</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;"  type=text name="expire_time" value="360"/></td>
							</tr>
	<tr>
	<td style="height: 30px;" valign="middle">商户编号</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text id="mer_id"  name="mer_id" value="70510000" /></td>
	<td style="height: 30px;" valign="middle">商户私有域</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;"  type=text name="mer_priv" value="跨境测试商户" id="mer_priv" /></td>
	<td style="height: 30px;" valign="middle">用户IP地址	</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="user_ip"  value="10.10.81.38" /></td>
	</tr>
	<tr>
		<td style="height: 30px;" valign="middle">商品订单号</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="mer_reference_id" value="<%=orderId %>"  /></td>
	  <td style="height: 30px;" valign="middle">商品订单日期</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;"  type=text name="mer_date" value="<%=date %>" /></td>
   <td style="height: 30px;" valign="middle">商品信息描述</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;"  type=text name="goods_inf" value="联动优势"/></td>
	 </tr>
		<tr>
					<td style="height: 30px;" valign="middle">持卡人姓名</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="payer_name" value="魏超"  /></td>
					<td style="height: 30px;" valign="middle">证件号码</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="citizen_id_number" value="150404199308070250"  /></td>
					<td style="height: 30px;" valign="middle">证件类型</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="citizen_id_type" value="IDENTITY_CARD"  /></td>
					<tr>
					<td style="height: 30px;" valign="middle">付款人电话</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="phone" value="18701588007"  /></td>
					<td style="height: 30px;" valign="middle">银行卡号</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="number" value="6217710703095380"  /></td>
					<td style="height: 30px;" valign="middle">银行编码</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="bank_code" value="BOC"  /></td>
					</tr>
					<tr>
					<td style="height: 30px;" valign="middle">银行卡有效期</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="valid_date" value="valid_date"  /></td>
					<td style="height: 30px;" valign="middle">cvv2</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="cvv2" value="cvv2"  /></td>
					<td style="height: 30px;" valign="middle">银行卡状态</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="state" value="state"  /></td>

	</tr>
	
	
	<tr>
						<td style="height: 30px;" valign="middle">订单金额</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="amount" value="0.01"  /></td>
					<td style="height: 30px;" valign="middle">订单明细</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="order_summary" value="maimaimai"  /></td>
				

	
<!-- 	<tr >
	<td >子订单号1</td>
	<td ><input type=text name="sub_order_id1" value="<%=orderId.substring(4) %>1" /></td>
	<td>子订单金额</td>
	<td><input type=text name="sub_order_amt1" value='0.02' /></td>
	<td>业务编号</td>
	<td><select name="sub_trans_code1">
			<option value="01121990" selected="selected">网络购物（报关）</option>
			<option value="01122030" >网络购物（不报关）</option>
				<option value="">null</option>
		</select></td>	
	<td>是否报关</td>
	<td><input type=text name="is_customs1" value="Y"/></td>
	</tr>
	

	<tr >
	<td>货物编号</td>
	<td><input type=text name="mer_sub_reference_id" value="<%=orderId.substring(4) %>11"/></td>
	<td>货物类型</td> 
	<td><select name="goods_type11">
			<option value="1" selected="selected">服装</option>
			<option value="2">食品</option>
			<option value="3">电子产品</option>
			<option value="4">其他</option>
				<option value="">null</option>
		</select></td>	 
	<td>货物数量</td> 
	<td><input type=text name="goods_quantity11" value="2"/></td>
	<td>货物价格</td>
	<td><input type=text name="goods_amt11" value="0.01"/></td>
	</tr>
	
	<tr >
	<td>货物编号</td>
	<td><input type=text name="goods_id12" value="<%=orderId.substring(4) %>12"/></td>
	<td>货物类型</td> 
	<td><select name="goods_type12">
			<option value="1" selected="selected">服装</option>
			<option value="2">食品</option>
			<option value="3">电子产品</option>
			<option value="4">其他</option>
				<option value="">null</option>
		</select></td>	
	<td>货物数量</td> 
	<td><input type=text name="goods_quantity12" value="3"/></td>
	<td>货物价格</td>
	<td><input type=text name="goods_amt12" value="0.01"/></td>
	</tr>
	</br>
	
	 -->
	<td style="height: 30px;" valign="middle">子订单号</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="mer_sub_reference_id" value="<%=orderId.substring(4) %>2" /></td>
	
	</tr>
	<tr>
		<td style="height: 30px;" valign="middle">子订单金额</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;"  type=text name="subamount1" value='0.01' /></td>
	
	

	<td>业务编号<label style="color: red">*</label></td>
	<td style="height: 30px;" valign="middle">
	<div class = "trans_code">
	<select    name="trans_code" id="trans_code" style="width: 45%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;">
			<option value="02000000" >留学</option>
			<option value="03222024" selected="selected">跨境机票款</option>	
			<option value="03000000">机票</option>	
			<option value="04000000">酒店</option>
			<option value="05227010">移动电讯服务</option>
			<option value="07222012">涉及我国进口的海洋货运服</option>
			<option value="07222022">涉及我国进口的空中货运服</option>
			<option value="07222032">涉及我国进口的其他运输方式货运服务</option>
			<option value="08227020">软件服务</option>
			<option value="08231030">复制或分销计算机软件许可费</option>
			<option value="09228025">展会服务</option>
				<option value="">null</option>
		</select></div></td>	
				<td style="height: 30px;" valign="middle">open_id</td><td><input style="width: 86%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;"  type=text name="open_id" value='oSJi6wDJCR39sTxb1CmfdJE6I8g4' /></td>
		
	</tr>
	<!--<tr >
	<td>子订单号3</td>
	<td><input type=text name="sub_order_id3" value="<%=orderId.substring(4) %>3" /></td>
	<td>子订单金额</td>
	<td><input type=text name="sub_order_amt3" value='0.01' /></td>
	<td>业务编号</td>
	<td><select name="sub_trans_code3">
			<option value="02000000" >留学</option>
			<option value="03222024" selected="selected">跨境机票款</option>	
			<option value="03000000">机票</option>	
			<option value="04000000">酒店</option>
			<option value="05227010">移动电讯服务</option>
			<option value="07222012">涉及我国进口的海洋货运服</option>
			<option value="07222022">涉及我国进口的空中货运服</option>
			<option value="07222032">涉及我国进口的其他运输方式货运服务</option>
			<option value="08227020">软件服务</option>
			<option value="08231030">复制或分销计算机软件许可费</option>
			<option value="09228025">展会服务</option>
				<option value="">null</option>
		</select></td>	
	</tr>
	
		<tr >
	<td >子订单号</td>
	<td ><input type=text name="sub_order_id3" value="<%=orderId.substring(4) %>3" /></td>
	<td>子订单金额</td>
	<td><input type=text name="sub_order_amt3" value='50.02' /></td>
	<td>业务编号</td>
	<td><select name="sub_trans_code3">
			<option value="01121990" selected="selected">网络购物（报关）</option>
			<option value="01122030">网络购物（不报关）</option>
				<option value="">null</option>
		</select></td>	
	<td>是否报关</td>
	<td><input type=text name="is_customs3" value="Y"/></td>
	</tr>
	

	<tr >
	<td>货物编号</td>
	<td><input type=text name="goods_id31" value="<%=orderId.substring(4) %>31"/></td>
	<td>货物类型</td> 
	<td><select name="goods_type31">
			<option value="1" selected="selected">服装</option>
			<option value="2">食品</option>
			<option value="3">电子产品</option>
			<option value="4">其他</option>
				<option value="">null</option>
		</select></td>	 
	<td>货物数量</td> 
	<td><input type=text name="goods_quantity31" value="2"/></td>
	<td>货物价格</td>
	<td><input type=text name="goods_amt31" value="30.02"/></td>
	</tr>
	
	<tr >
	<td>货物编号</td>
	<td><input type=text name="goods_id32" value="<%=orderId.substring(4) %>32"/></td>
	<td>货物类型</td> 
	<td><select name="goods_type32">
			<option value="1" selected="selected">服装</option>
			<option value="2">食品</option>
			<option value="3">电子产品</option>
			<option value="4">其他</option>
				<option value="">null</option>
			
		</select></td>	
	<td>货物数量</td> 
	<td><input type=text name="goods_quantity32" value="3"/></td>
	<td>货物价格</td>
	<td><input type=text name="goods_amt32" value="20"/></td>
	</tr>
	
	<tr >
	<td>子订单号</td>
	<td><input type=text name="sub_order_id4" value="<%=orderId.substring(4) %>4" /></td>
	<td>子订单金额</td>
	<td><input type=text name="sub_order_amt4" value='10' /></td>
	<td>业务编号</td>
	<td><select name="sub_trans_code4">
			<option value="02000000" selected="selected">留学</option>
			<option value="03222024">跨境机票款</option>	
			<option value="03000000">机票</option>	
			<option value="04000000">酒店</option>
			<option value="05227010">移动电讯服务</option>
			<option value="07222012">涉及我国进口的海洋货运服</option>
			<option value="07222022">涉及我国进口的空中货运服</option>
			<option value="07222032">涉及我国进口的其他运输方式货运服务</option>
			<option value="08227020">软件服务</option>
			<option value="08231030">复制或分销计算机软件许可费</option>
			<option value="09228025">展会服务</option>
			<option value="">null</option>
		</select></td>	
	</tr>
<tr >
	<td>子订单号</td>
	<td><input type=text name="sub_order_id5" value="<%=orderId.substring(4) %>5" /></td>
	<td>子订单金额</td>
	<td><input type=text name="sub_order_amt5" value='10' /></td>
	<td>业务编号</td>
	<td><select name="sub_trans_code5">
			<option value="02000000" selected="selected">留学</option>
			<option value="03222024">跨境机票款</option>	
			<option value="03000000">机票</option>	
			<option value="04000000">酒店</option>
			<option value="05227010">移动电讯服务</option>
			<option value="07222012">涉及我国进口的海洋货运服</option>
			<option value="07222022">涉及我国进口的空中货运服</option>
			<option value="07222032">涉及我国进口的其他运输方式货运服务</option>
			<option value="08227020">软件服务</option>
			<option value="08231030">复制或分销计算机软件许可费</option>
			<option value="09228025">展会服务</option>
			<option value="">null</option>
		</select></td>	
	</tr>
<tr >
	<td>子订单号</td>
	<td><input type=text name="sub_order_id6" value="<%=orderId.substring(4) %>6" /></td>
	<td>子订单金额</td>
	<td><input type=text name="sub_order_amt6" value='10' /></td>
	<td>业务编号</td>
	<td><select name="sub_trans_code6">
			<option value="02000000">留学</option>
			<option value="03222024">跨境机票款</option>	
			<option value="03000000">机票</option>	
			<option value="04000000">酒店</option>
			<option value="05227010">移动电讯服务</option>
			<option value="07222012">涉及我国进口的海洋货运服</option>
			<option value="07222022">涉及我国进口的空中货运服</option>
			<option value="07222032">涉及我国进口的其他运输方式货运服务</option>
			<option value="08227020">软件服务</option>
			<option value="08231030">复制或分销计算机软件许可费</option>
			<option value="09228025">展会服务</option>
                        <option value="06000000"  selected="selected">旅游</option>

			<option value="">null</option>
		</select></td>	
	</tr>
	</br>
	-->
	
	<tr>
						<td style="height: 30px;" valign="middle">通知地址</td><td><input style="width: 200%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text id="ret_url" name="ret_url"  value="http://10.10.178.36:8071/spaytest/notify0000V4.jsp" /></td>
						</tr><tr>
						<td style="height: 30px;" valign="middle">同步返回地址</td><td><input style="width: 200%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text id="notify_url" name="notify_url"  value="http://10.10.178.36:8071/spaytest/notify0000V4.jsp" /></td>
						</tr>
						<tr>
						<td style="height: 30px;" valign="middle">token认证地址</td><td><input style="width: 200%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text id="oauth_url" name="oauthUrl"  value="http://10.10.178.36:8071/spay_rest/oauth/authorize" /></td>
						</tr><tr>
						<td style="height: 30px;" valign="middle">接口访问地址</td><td><input style="width: 200%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text id="url" name="url"  value="http://10.10.178.36:8071/spay_rest/payments/payment"/></td>
					</tr>
	<tr>
		<td colspan=2 align=center><input type=submit value="提交订单" /></td>
	</tr>
</table>
</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.*" %>   
<%@ page import="java.util.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
	<style>	
		.div-left{width:400px;height:300px;border:1px solid #000;float:left} 
	.div-right{width:600px;height:300px;border:1px solid #000;float:right} 
				
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
	String orderId=date+(Math.round(Math.random()*800000)+100000)+"cb"+date+(Math.round(Math.random()*800000)+100000)+"cb";
	String mer_sub_reference_id=date+(Math.round(Math.random()*800000)+100000)+"zd"+date+(Math.round(Math.random()*800000)+100000)+"zd";
	String refundNo=date+(Math.round(Math.random()*800000)+100000)+"rf"+date+(Math.round(Math.random()*800000)+100000)+"rf";
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
	function	change(){
		document.getElementById("test").innerHtml="订单已提交，处理中";
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
<script type="text/javascript" src="${pageContext.request.contextPath }/javascript/jquery.js"></script>
<script type="text/javascript">
    $(function(){
        //按钮单击时执行
       
        $("#testAjax").click(function(){
        	 var form = $('#orderApi');
    		 //获取表单数据
    		 var data = getFormData(form);
    		 //发送AJAX请求
    		 
    		
              //Ajax调用处理
            $.ajax({
               type: "POST",
                async : true, //同步请求
               url: "/UmpayTesterProject/DebitCardServlet",
               data: data,
               success: function(data){
            	  
                        $("#myDiv").html('<h2>'+data+'</h2>');
                  }
            });
            
         });
    });
    
    function getFormData(form){
    	 var data = form.serialize();
    	 data = decodeURI(data);
    	 var arr = data.split('&');
    	 var item,key,value,newData={};
    	 for(var i=0;i<arr.length;i++){
    	 item = arr[i].split('=');
    	 key = item[0];
    	 value = item[1];
    	 if(key.indexOf('[]')!=-1){
    	  key = key.replace('[]','');
    	  if(!newData[key]){
    	  newData[key] = [];
    	  }
    	  newData[key].push(value);
    	 }else{
    	  newData[key] = value;
    	 }
    	 }
    	 return newData;
    	}
</script>

<div class="div-left"  style="height: 570px;width: 489px;  font-size:12px; background: white; color: #aaa; padding: 20px;border:2px solid  #242424">

		<form id="orderApi" method="post"  >
			<input type=hidden name="type"  id="type" value="RSA" />
			<input type="hidden" name="charset"  id="charset"  value="UTF-8" />	  
			<input type=hidden name="res_format" id="res_format"  value="HTML" />
			<input type=hidden name="version" id="version"  value="4.0" />

			<input type=hidden name="type" id="type"  value="POST" />
			<input type=hidden name="RSACharset" id="RSACharset"  value="GBK" />
	<table  style="width: 500px; height: 150px;" border="0" cellpadding="1" cellspacing="1">
				<tbody style="height: 40px;">
			<tr>
			<td  >环境选择<label style="color: red">*</label></td>
					<td style="height: 30px;">
					<select   id="env" name="env" onchange="test()" style="width: 164px; height: 30px;border:5px solid blue;padding:5px;background-color:transparent;">
                                                <option value="http://10.10.178.34:8071/" >http://10.10.178.34</option>
                                                <option value="http://10.10.178.35:8071/" >http://10.10.178.35</option>
                                                <option value="http://10.10.178.36:8071/" selected="selected" >http://10.10.178.36</option>
					                            <!--	<option value="http://10.10.178.93:8081" >http://10.10.178.93:8081</option>-->
					</select></td>
					
							<td>支付类型<label style="color: red">*</label></td>
					<td style="height: 30px;" >
					   <select  onchange="check()"  name="payment_method" id="payment_method" style="width:164px; height: 30px;border:5px solid blue;padding:5px;background-color:transparent;">
                        <option  value="CREDIT_CARD"  >信用卡</option>
						<option  value="DEBIT_CARD"    >借记卡</option>
						<option   value="WECHAT_SCAN" selected="selected" >微信主扫</option>
						<option  value="ALIPAY_SCAN" >支付宝主扫</option>
						<option  value="WECHAT_IN_APP" >微信APP支付</option>
						<option  value="WECHAT_WEB" >微信公众号支付</option>
			     <!--  	<option  value="NOT_APPLICABLE" >NOT_APPLICABLE</option>-->	
					</select>
					</td>
					</tr><tr>
					<td>币      种<label style="color: red">*</label></td>
					<td style="height: 30px;" >
					   <select    name="currency" id="currency" style="width:164px; height: 30px;border:5px solid blue;padding:5px;background-color:transparent;">
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
					</td>
					
					<td>业务编号<label style="color: red">*</label></td>
	<td style="height: 30px;">
	<select    name="trans_code" id="trans_code" style="width:164px; height:30px;border:5px solid blue;padding:5px;background-color:transparent;">
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
				<tr>
					
								<td style="height: 30px;" valign="middle">BusinessType</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text id="business_type" name="business_type" value="B2C" /></td>
	<td style="height: 30px;" valign="middle">接口类型</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text id="interface_type"  name="interface_type"  value="SERVER_TO_SERVER" /></td>
	</tr><tr>
   <td style="height: 30px;" valign="middle">订单过期时常</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;"  type=text name="expire_time" id="expire_time"  value="360"/></td>
	<td style="height: 30px;" valign="middle">商户编号</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text id="mer_id"  name="mer_id" value="70510000" /></td>
   
							</tr>
	<tr>
	<td style="height: 30px;" valign="middle">商户私有域</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;"  type=text name="mer_priv" id="mer_priv" value="跨境测试商户" id="mer_priv" /></td>
	<td style="height: 30px;" valign="middle">用户IP地址	</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="user_ip" id="user_ip"   value="10.10.81.38" /></td>
	</tr><tr>
		<td style="height: 30px;" valign="middle">商品订单号</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="mer_reference_id" id="mer_reference_id"  value="<%=orderId %>"  /></td>
	  <td style="height: 30px;" valign="middle">商品订单日期</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;"  type=text name="mer_date" id="mer_date"  value="<%=date %>" /></td>
	</tr>
	<tr>
   <td style="height: 30px;" valign="middle">商品信息描述</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;"  type=text name="goods_inf" id="goods_inf" value="联动优势"/></td>
					<td style="height: 30px;" valign="middle">持卡人姓名</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="payer_name" id="payer_name" value="魏超"  /></td>
					</tr><tr>
					<td style="height: 30px;" valign="middle">证件号码</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="citizen_id_number" id="citizen_id_number" value="150404199308070250"  /></td>
					<td style="height: 30px;" valign="middle">证件类型</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="citizen_id_type" id="citizen_id_type" value="IDENTITY_CARD"  /></td>
	 </tr>
		<tr>
					<tr>
					<td style="height: 30px;" valign="middle">付款人电话</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="phone" id="phone" value="18701588007"  /></td>
					<td style="height: 30px;" valign="middle">银行卡号</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="number"  id="number" value="6217710703095380"  /></td>
					</tr><tr>
					<td style="height: 30px;" valign="middle">银行编码</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="bank_code" id="bank_code"  value="CITIC"  /></td>
					<td style="height: 30px;" valign="middle">银行卡有效期</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="valid_date" id="valid_date" value="valid_date"  /></td>
					</tr>
					<tr>
					<td style="height: 30px;" valign="middle">cvv2</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="cvv2" id="cvv2" value="cvv2"  /></td>
					<td style="height: 30px;" valign="middle">银行卡状态</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="state" id="state" value="state"  /></td>
					</tr><tr>
						<td style="height: 30px;" valign="middle">订单金额</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="amount" id="amount" value="0.01"  /></td>
					<td style="height: 30px;" valign="middle">订单明细</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="order_summary" id="order_summary" value="maimaimai"  /></td>

	</tr>
	
	
	<tr>
				
		<td style="height: 30px;" valign="middle">子订单金额</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;"  type=text name="subamount1" id="subamount1"  value='0.01' /></td>
	<td style="height: 30px;" valign="middle">子订单号</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="mer_sub_reference_id"  id="mer_sub_reference_id"  value="<%=mer_sub_reference_id %>" /></td>
	</tr><tr>
				<td style="height: 30px;" valign="middle">open_id</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;"  type=text name="open_id" id="open_id" value='oSJi6wDJCR39sTxb1CmfdJE6I8g4' /></td>
				<td style="height: 30px;" valign="middle">退费单号</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;"  type=text name="refundNo" id="refundNo" value='<%=refundNo %>' /></td>

	
	
	</tr>
	
	<tr>
						<td  style="height: 30px;" >通知地址</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text id="ret_url" name="ret_url"  value="http://10.10.178.36:8071/spaytest/notify0000V4.jsp" /></td>
						<td   style="height: 30px;">同步返回地址</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text id="notify_url" name="notify_url"  value="http://10.10.178.36:8071/spaytest/notify0000V4.jsp" /></td>
						</tr>
						<tr>
						<td   style="height: 30px;" >token认证地址</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text id="oauth_url" name="oauthUrl"  value="http://10.10.178.36:8071/spay_rest/oauth/authorize" /></td>
						<td   style="height: 30px;">接口访问地址</td><td><input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text id="url" name="url"  value="http://10.10.178.36:8071/spay_rest/payments/payment"/></td>
	
	

		
	</tr>

	</tbody>
</table>
</form>

        <button style="height: 40px;width:150px;  background: #242424; color: #aaa;font-size:18px; padding: 10px;" id="testAjax"  type="button" >提交订单</button>
</div>
        <div class="div-right" id="myDiv" style="height: 602px;width:780px; font-size:8px;overflow-y: scroll; background: #242424; color: #aaa; padding: 5px;border:2px solid  white"></div>


</body>
</html>

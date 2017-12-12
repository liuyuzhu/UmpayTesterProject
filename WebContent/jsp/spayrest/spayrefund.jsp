<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.*" %>   
<%@ page import="java.util.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		
		<title>跨境收银台</title>
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
		var a = document.getElementById("spaytest").value;
		document.getElementById("ret_url").value = a + "/spaytest/notify0000V4.jsp";
		document.getElementById("notify_url").value = a + "/spaytest/notify0000V4.jsp";
		
	}
</script>
		<form name="realNameCertify" method="post" action="/UmpayTesterProject/SpayCashierServlet">
			<input type=hidden name="sign_type" value="RSA" readonly="readonly"/>
			<input type="hidden" name="charset" value="UTF-8" readonly="readonly"/>	  
			<input type=hidden name="res_format" value="HTML" readonly="readonly"/>
			<input type=hidden name="version" value="4.0" readonly="readonly"/>

		<!--  	<input type="hidden" name="goods_id" value="12345678" readonly="readonly"/>
			<input type="hidden" name="expand" value="2323" readonly="readonly"/> -->
				<table style="100%">
			<tr>
			<td> spy地址选择</td>
					<td><select  id="spaytest" name="url" onchange="test()">
                                                <option value="http://10.10.178.34:8081/fx_spay/pay/payservice.do?" >http://10.10.178.34:8081/fx_spay/pay/payservice.do</option>
                                                <option value="http://10.10.178.35:8081/fx_spay/pay/payservice.do?" >http://10.10.178.35:8081/fx_spay/pay/payservice.do</option>
                                                <option value="http://10.10.178.36:8081/fx_spay/pay/payservice.do?" "selected="selected" >http://10.10.178.36:8081/fx_spay/pay/payservice.do</option>
					                            <!--	<option value="http://10.10.178.93:8081" >http://10.10.178.93:8081</option>-->
					</select></td>
			</tr>
			</table>	
             <tr>
			<td> ret_url   </td>
			<td><input id="ret_url" name="ret_url" readonly="readonly"/></td></br>	 
			</tr>
			
			<tr>
			<td> notify_url</td>
			<td><input id="notify_url" name="notify_url" readonly="readonly"/></td>		 
			</tr>
			
			<table style="100%">
				<tr>
					<td> 接口名称<label style="color: red">*</label></td>
					<td><select name="service">
						<option value="cross_border_pay" selected="selected">前端支付请求(跨境)</option>
                                                <option value="cross_border_pay_new" >融合支付请求(跨境)</option>
					<!--  	<option value="">测试校验接口数据</option>-->
					</select></td>
					<td> 商户编号</td>
					<td><select name="mer_id">
                                                <option value="70510000" selected="selected" >70510000</option>
						<option value="3621" >3621</option>
						<option value="3965" >3965</option>
						<option value="6344">6344</option>
						<option value="6374" >6374</option>
						<option value="7499">7499</option>
						<option value="8023" >8023</option>
						<option value="3966" >3966</option>
						<option value="9994" >9994</option>
						<option value="9995">9995</option>
						<option value="9996">9996</option>
						<option value="70510007" >70510007</option>
						<option value="99996000" >99996000</option>
					</select></td>
				</tr>
	
	<tr>
		<td> 商品订单号</td>
		<td><input type=text name="order_id" value="<%=orderId %>" readonly="readonly"/></td>	 
		<td> 商品订单日期</td>
		<td><input type=text name="mer_date" value="<%=date %>" readonly="readonly"/></td>	 
	</tr>
	<tr>
		<td> 币种</td>
		<td><select name="currency">
			<option value="USD">美元</option>
			<option value="CNY" selected="selected">人民币</option>
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
		</select></td>	 	 
		<td> 订单金额</td>
		<td><input type=text name="amount" value="0.03"/></td>	 
	</tr>
	

	<tr>
		<td> 订单过期时常</td>
		<td><input type=text name="expire_time" value="360"/></td>	 
		<td> 接口类型<label style="color: red">*</label></td>
			<td><select name="interface_type" id="interface_type" >
			<option value="01">收银台</option>
			<option value="02">直连</option>
                        <option value="04">H5</option>

			</select>
		</td>
		<td> 接口类型<label style="color: red">*</label></td>
		<td>
			<select name="pay_type">
				<option value="WECHAT">微信支付</option>
				<option value="ALIPAY">支付宝支付</option>
			<!--  <option value="" selected="selected">测试（空）</option>-->	
			</select>
		</td>
	</tr>
	
	<tr>
		<td> 商户私有域</td>
		<td><input type=text name="mer_priv" value="跨境测试商户" id="mer_priv" /></td>	 
		<td> 用户IP地址</td>
		<td><input type=text name="user_ip"  value="10.10.81.38"/></td>	 
		<td> 商户私有域</td>
		<td><input type=text name="gate_id" value="BOC" id="gate_id" /></td>	 
	</tr>
	
	<tr>
		<td> 商品信息描述</td>
		<td><input type=text name="goods_inf" value="联动优势" /></td>	 
	</tr>
	
	
	<tr></tr>
	<tr></tr>
	<tr></tr>
	
	<tr>
		<td> 收货人姓名</td>
		<td><input type=text name="card_holder" value="罗淳雅" /></td>
		<td> 收货人证件号</td>
		<td><input type=text name="identity_code" value="431381198109106573" /></td>
		<td> 收货人证件类型</td>
		<td><input type=text name="identity_type" value="IDENTITY_CARD" /></td>
		<td> 收货人手机号</td>
		<td><input type=text name="mobile_id" value="13131313131" /></td>
	
	</tr>
	
	<tr >
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
	<td><input type=text name="goods_id11" value="<%=orderId.substring(4) %>11"/></td>
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
	
	
	<tr >
	<td>子订单号2</td>
	<td><input type=text name="sub_order_id2" value="<%=orderId.substring(4) %>2" /></td>
	<td>子订单金额</td>
	<td><input type=text name="sub_order_amt2" value='0.01' /></td>
	<td>业务编号</td>
	<td><select name="sub_trans_code2">
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
		<td colspan=2 align=center><input type=submit value="提交订单" /></td>
	</tr>
</table>
</form>
</body>
</html>

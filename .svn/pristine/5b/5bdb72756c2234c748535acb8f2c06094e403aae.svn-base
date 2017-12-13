<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.*" %>   
<%@ page import="java.util.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<script type="text/javascript">
var c=0
var t
function timedCount()
 {
 document.getElementById('testAjax').innerHTML="处理中:"+c;
 c=c+1
 t=setTimeout("timedCount()",1000)

 }
function stopCount()
 {   
     clearTimeout(t)   
     document.getElementById('testAjax').innerHTML="提交订单";

 }
function cs()
{  
     c=0  
     document.getElementById('testAjax').value= 0    
}
</script>
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
		
		
		<title>融合支付下单页面</title>
	</head>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	String date = format.format(new Date());
	String orderId=date+(Math.round(Math.random()*800000)+100000)+"";
	%>
	<body >
	
<script type="text/javascript" src="${pageContext.request.contextPath }/javascript/jquery.js"></script>
<script type="text/javascript">
    $(function(){
        //按钮单击时执行
       
        $("#testAjax").click(function(){
        	 var form = $('#fx');
    		 //获取表单数据
    		 var data = getFormData(form);
    		 //发送AJAX请求
    		 
    			timedCount();
              //Ajax调用处理
            $.ajax({
               type: "POST",
               url: "/UmpayTesterProject/FusionPayServlet",
               data: data,
               success: function(data){
            	  
                        $("#myDiv").html('<h2>'+data+'</h2>');
               		 stopCount();

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
<script type="text/javascript">
	function test(){
		var a = document.getElementById("url").value;
		document.getElementById("ret_url").value = a + "/spaytest/notify0000V4.jsp";
		document.getElementById("notify_url").value = a + "/spaytest/notify0000V4.jsp";
		
	}
</script>
<div class="div-left"  style="height: 590px;width: 550px;  font-size:10px; background: white; color: #aaa; padding: 10px;border:1px solid  #242424">

		<form  id ="fx" name="fx" method="get"  >
					<input type="hidden" id="sign_type" name="sign_type" value="RSA" />
			<input type="hidden" id="charset" name="charset" value="UTF-8" />	  
			<input type="hidden" id="res_format" name="res_format" value="HTML" />
			<input type="hidden" id="version" name="version" value="4.0" />
			<input type="hidden"  name="expire_time" value="360" />
		<input type="hidden"  name="mer_priv" value="跨境测试商户私有域" id="mer_priv" />
		<input type="hidden"  name="user_ip" id="user_ip"  value="10.10.70.123" />
			
			<!--<input type="hidden" name="goods_id" value="12345678" />-->
			<input type="hidden"  id="expand" name="expand" value="2323" />
			       <input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="hidden" id="ret_url" value="test" name="ret_url"   />
             <input style="width: 150px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="hidden" id="notify_url" value="test"  name="notify_url" />
			
			
			<table style="100%">
				
				<tr>
				<td style="height: 20px;" valign="middle">地址选择</td>
					<td><select  style="width: 180px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" id="url" name="url" onchange="test()">
                                                <option value="http://10.10.178.34:8081/fx_spay/pay/payservice.do?" >10.10.178.34</option>
                                                <option value="http://10.10.178.35:8081/fx_spay/pay/payservice.do?" >10.10.178.35</option>
                                                <option value="http://10.10.178.36:8081/fx_spay/pay/payservice.do?" selected="selected" >10.10.178.36</option>
					                            <!--	<option value="http://10.10.178.93:8081" >http://10.10.178.93:8081</option>-->
					</select></td>
				
					<td style="height: 20px;" valign="middle"> 接口名称<label style="color: red">*</label></td>
					<td><select style="width: 180px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" id="service" name="service">
						<option value="cb_active_scancode_pay" selected="selected">融合支付</option>
					</select></td>
					</tr>
					<tr>
					<td style="height: 20px;" valign="middle">商户编号<label style="color: red">*</label></td>
					<td><select style="width: 180px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" id="mer_id" name="mer_id">
						 <option value="70510000"  selected="selected">70510000</option>
						<option value="70510002">70510002</option>
					</select></td>	

					<td style="height: 20px;" valign="middle">支付类型 </td>
					<td><select  style="width: 180px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" name="pay_type" id="pay_type">
						<option value="WECHAT_OA" selected="selected">微信公众号支付</option>
						<option value="WECHAT_APP">微信app支付</option>
						<option value="WECHAT">微信支付</option>
						<option value="ALIPAY">支付宝支付</option>
						<option value="" >测试（空）</option>
					</select></td>
					</tr>
					<tr>
					<td style="height: 20px;" valign="middle">AppId</td>
					<td>
						<input  style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="text" id="app_id" name="app_id" value="" />
					</td>
					
					<td style="height: 20px;" valign="middle">openId<label style="color: red">*</label></td>
					<td>
	                                <!--					<input type="text" id="" name="open_id" value="oSJi6wD8_i8jhNoeoLRJ0QouP7cw" />-->
						<input  style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="text" id="open_id" name="open_id" value="oSJi6wD8_i8jhNoeoLRJ0QouP7cw" />
					</td>
	</tr><tr>
		<td style="height: 20px;" valign="middle"> 商品订单号</td>
		<td><input  style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="text" id="order_id" name="order_id" value="20171201521939" /></td>	 
		<td style="height: 20px;" valign="middle"> 商品订单日期</td>
		<td><input  style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="text" id="mer_date" name="mer_date" value="20171201" /></td>	 
</tr><tr>
		<td style="height: 20px;" valign="middle"> 币种</td>
		<td><select  style="width: 180px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" name="currency" id="currency">
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
		<td style="height: 20px;" valign="middle"> 订单金额</td>
		<td><input  style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="text" id="amount" name="amount" value="0.03"/></td>	 
</tr><tr>
		<td style="height: 20px;" valign="middle"> 商品信息描述</td>
		<td><input style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;"  type="text" id="goods_inf" name="goods_inf" value="test" /></td>
		<td style="height: 20px;" valign="middle"> 风控大字段</td>
		<td><input  style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="text" id="risk_expand" name="risk_expand" value="A:111#B:444" /></td>
</tr><tr>
		<td style="height: 20px;" valign="middle"> 收货人姓名</td>
		<td><input style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;"  type="text" id="c" name="card_holder" value="罗淳雅" /></td>
		<td style="height: 20px;" valign="middle"> 收货人证件号</td>
		<td><input  style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="text" id="identity_code" name="identity_code" value="431381198109106573" /></td>
</tr><tr>
		<td style="height: 20px;" valign="middle"> 收货人证件类型</td>
		<td><input style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;"  type="text" id="identity_type" name="identity_type" value="IDENTITY_CARD" /></td>
		<td style="height: 20px;" valign="middle"> 收货人手机号</td>
		<td><input style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;"  type="text" id="mobile_id" name="mobile_id" value="18701588007" /></td>
</tr><tr>
	<td style="height: 20px;" valign="middle">子订单号</td>
	<td><input  style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="text" id="sub_order_id1" name="sub_order_id1" value="12015219391" /></td>
	<td style="height: 20px;" valign="middle">子订单金额</td>
	<td><input style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;"  type="text" id="sub_order_amt1" name="sub_order_amt1" value='0.02' /></td>
</tr><tr>
	<td style="height: 20px;" valign="middle">业务编号</td>
	<td><select  style="width: 180px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" name="sub_trans_code1" id="sub_trans_code1">
			<option value="01121990" selected="selected">网络购物（报关）</option>
			<option value="01122030">网络购物（不报关）</option>
			<option value="">空</option>
		</select></td>	
	<td style="height: 20px;" valign="middle">是否报关</td>
	<td><input  style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="text" id="is_customs1" name="is_customs1" value="Y"/></td>
</tr><tr>
	<td style="height: 20px;" valign="middle">货物编号</td>
	<td><input  style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="text" id="goods_id11" name="goods_id11" value="120152193911"/></td>
	<td style="height: 20px;" valign="middle">货物类型</td> 
	<td><input style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;"  type="text" id="goods_type11" name="goods_type11" value="2"/></td>
</tr><tr>
	<td style="height: 20px;" valign="middle">货物数量</td> 
	<td><input  style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="text" id="goods_quantity11" name="goods_quantity11" value="2"/></td>
	<td style="height: 20px;" valign="middle">货物价格</td>
	<td><input  style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="text" id="goods_amt11" name="goods_amt11" value="0.01"/></td>
</tr><tr>
	<td style="height: 20px;" valign="middle">货物编号</td>
	<td><input  style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="text" id="goods_id12" name="goods_id12" value="120152193912"/></td>
	<td style="height: 20px;" valign="middle">货物类型</td> 
	<td><input  style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="text" id="goods_type12" name="goods_type12" value="3"/></td>
</tr><tr>
	<td style="height: 20px;" valign="middle">货物数量</td> 
	<td><input  style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="text" id="goods_quantity12" name="goods_quantity12" value="3"/></td>
	<td style="height: 20px;" valign="middle">货物价格</td>
	<td><input style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;"  type="text" id="goods_amt12" name="goods_amt12" value="0.01"/></td>
</tr><tr>
	<td style="height: 20px;" valign="middle">子订单号</td>
	<td><input  style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="text" id="sub_order_id2" name="sub_order_id2" value="12015219392" /></td>
	<td style="height: 20px;" valign="middle">子订单金额</td>
	<td><input  style="width: 165px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="text" id="sub_order_amt2" name="sub_order_amt2" value='0.01' /></td>
</tr><tr>
	<td style="height: 20px;" valign="middle">业务编号</td>
	<td><select  style="width: 180px; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" name="sub_trans_code2" id="sub_trans_code2">
			<option value="02223022" >留学及教育相关旅行（一年以上）学费</option>
            <option value="02223023" >留学及教育相关旅行（一年及一年以下）学费</option>
            <option value="03222024" selected="selected">跨境机票款</option>
            <option value="03223010" >公务及商务旅行机票</option>
            <option value="03223021" >就医及健康相关旅行机票</option>
            <option value="03223022" >留学及教育相关旅行（一年以上）机票</option>
            <option value="03223023" >留学及教育相关旅行（一年以下）机票</option>
            <option value="03223029" >其他私人旅行机票</option>
            <option value="04223010" >留学及教育相关旅行（一年以下）酒店</option>
            <option value="04223021" >其他私人旅行酒店</option>
            <option value="04223022" >公务及商务旅行酒店</option>
            <option value="04223023" >就医及健康相关旅行酒店</option>
            <option value="04223029" >留学及教育相关旅行（一年以上）酒店</option>
            <option value="05227010" >移动电讯服务</option>
            <option value="06223010" >公务及商务旅行</option>
            <option value="06223021" >就医及健康相关旅行</option>
            <option value="06223022" >留学及教育相关旅行（一年以上）</option>
            <option value="06223023" >留学及教育相关旅行（一年及一年以下）</option>
            <option value="06223029" >其他私人旅行</option>
            <option value="07222012" >涉及我国进口的海洋货运服务</option>
            <option value="07222022" >涉及我国进口的空中货运服务</option>
            <option value="07222032" >涉及我国进口的其他运输方式货运服务</option>
            <option value="08227020" >软件服务</option>
            <option value="08231030" >复制或分销计算机软件许可费</option>
            <option value="09228025" >展会服务</option>
            <option value="02000000" >留学（原总）</option>
            <option value="03000000" >机票（原总）</option>
            <option value="04000000" >酒店（原总）</option>
            <option value="06000000" >旅游（原总）</option>
            <option value="">空</option>
		</select></td>	
	</tr>
</table>
</form>

       <div><button style="height: 35px;width:170px;  background: #242424; color: #aaa;font-size:16px; padding: 10px;" id="testAjax" type="button" >提交订单</button></div> 

</div>
        <div class="div-right" id="myDiv" style="height: 602px;width:730px; font-size:8px;overflow-y: scroll; background: #242424; color: #aaa; padding: 5px;border:2px solid  white"></div>

</body>
</html>

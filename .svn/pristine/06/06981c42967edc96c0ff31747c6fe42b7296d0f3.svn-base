<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.*" %>   
<%@ page import="java.util.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<style>
	.div-left{width:800px;height:300px;border:1px solid #000;float:middle} 
	.div-right{width:800px;height:300px;border:1px solid #000;float:middle} 
	
	
	</style>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>TOKEN获取页面</title>
	</head>
	<body >
	<script type="text/javascript" src="${pageContext.request.contextPath }/javascript/jquery.js"></script>
<script type="text/javascript">
    $(function(){
        //按钮单击时执行
       
        $("#testAjax").click(function(){
        	 var form = $('#fm');
    		 //获取表单数据
    		 var data = getFormData(form);
    		 //发送AJAX请求
    		 
    		
              //Ajax调用处理
            $.ajax({
               type: "POST",
               url: "/UmpayTesterProject/GetTokenServlet",
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

<div class="div-left"  style="height: 300px; font-size:20px; background: white; color: #aaa; padding: 20px;border:5px">
	<!--  	<form  id="fm" name="gettoken" method="post" action="/UmpayTesterProject/GetTokenServlet">-->
		<form  id="fm" name="gettoken" method="post"  >
				<table  style="width: 600px; height: 100px;" border="0" cellpadding="0" cellspacing="0">
				<tbody style="height: 40px;">
				
			<td style="height: 40px;width: 200px;" valign="left">应用访问地址</td>
					<td><select  id="url" name="url"    >
                                                <option value="http://10.10.178.34:8071/spay_rest/oauth/authorize" >http://10.10.178.34</option>
                                                <option value="http://10.10.178.35:8071/spay_rest/oauth/authorize" >http://10.10.178.35</option>
                                                <option value="http://10.10.178.36:8071/spay_rest/oauth/authorize" "selected="selected" >http://10.10.178.36</option>
					</select></td>
					
					
					
	                  <tr style="height: 40px;"><td style="height: 40px;" valign="middle">商户号</td><td><input style="width: 100%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="mer_id"  id="mer_id" value="70510000" /></td></tr>
	                  <tr style="height: 40px;"><td style="height: 40px;" valign="middle">商户ID</td><td><input style="width: 100%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="client_id" id="client_id"  value="74a5945930aaefbfd89594f5bb89308cc52f594a" /></td></tr>
	                  <tr style="height: 40px;"><td style="height: 40px;" valign="middle">商户密码</td><td><input style="width: 100%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="client_secret"  id="client_secret" value="97a807a101ede5c14957770d0953a8017b28e815" /></td></tr>
	                  <tr style="height: 40px;"><td style="height: 40px;" valign="middle">备注</td><td><input style="width: 100%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="scope" id="scope"  value="kuajingtester" /></td></tr>
		
	</tbody>
</table>

</form>

        <button style="height: 40px;width:100px;  background: green; color: #aaa; padding: 10px;" id="testAjax" type="button">获取token</button>（单独获取token时使用）
</div>
		<!-- <td colspan=2 align=center><input testAjax() type=submit value="获取token"  /></td></tr> -->
        <div class="div-right" id="myDiv" style="height: 300px;width:830px; font-size:10px;overflow-y: scroll; background: #242424; color: #aaa; padding: 5px;">

</body>
</html>

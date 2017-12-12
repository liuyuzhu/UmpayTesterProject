<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.*" %>   
<%@ page import="java.util.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>报表上送接口BF221016</title>
<style>
			.ip{                    	
				width: 200%; 
				height: 100%;
				border:5px solid blue;
				padding:5px;
				background-color:transparent;
			
			}
</style>
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
    		 
    		//var urls = document.getElementById("url").value
    		//alert(urls);
              //Ajax调用处理
            $.ajax({
               type: "POST",
              // dataType: 'JSONP',
               url: "/UmpayTesterProject/BF221016",
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

<div class="div-left"  style="height: 190px; width:1150px;font-size:15px; background: white; color: #aaa; padding: 20px;border:2px solid  #242424">
	<!--  	<form  id="fm" name="gettoken" method="post" action="/UmpayTesterProject/GetTokenServlet">-->
		<form  id="fm" name="fm"   >
				<table  style="width: 600px; height: 100px;" border="0" cellpadding="0" cellspacing="0">
				<tbody style="height: 40px;">
				
			<td style="height: 40px;width: 200px;" valign="left" >plat2-cbe地址</td>
					<td><select  id="url" name="url"   style="width: 103%; height: 40px;border:5px solid blue;padding:5px;background-color:transparent;"   >
                                                <option value="http://www.baidu.com" ">http://10.10.178.34:19998/cbe/BF221016</option>
                                                <option value="http://10.10.178.35:19998/cbe/BF221016" selected="selected">http://10.10.178.35:19998/cbe/BF221016</option>
                                                <option value="http://10.10.178.36:19998/cbe/BF221016"  >http://10.10.178.36:19998/cbe/BF221016</option>
					</select></td>
					
					
					
	                  <tr style="height: 40px;"><td style="height: 40px;" valign="middle">请求流水rpid</td><td><input style="width: 100%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="rpid"  id="rpid" value="" /></td></tr>
	                  <tr style="height: 40px;"><td style="height: 40px;" valign="middle">处理日期handleDate</td><td><input style="width: 100%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="handleDate" id="handleDate"  value="" /></td></tr>
	                  <tr style="height: 40px;"><td style="height: 40px;" valign="middle">阈值(单位美元)threshold</td><td><input style="width: 100%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type=text name="threshold"  id="threshold" value="" /></td>
		</tr>
	</tbody>
</table>

</form>

	                  <td style="height: 40px;" valign="middle"></td><td><button style="height: 40px;width:100px;  background: #242424; color: #aaa; padding: 10px;" id="testAjax" type="button">提交请求</button></td>
</div>
		<!-- <td colspan=2 align=center><input testAjax() type=submit value="获取token"  /></td></tr> -->
        <div class="div-right" id="myDiv" style="height: 500px;width:1200px; font-size:10px;overflow-y: scroll; background: #242424; color: #aaa; padding: 5px;"></div>

</body>
</html>

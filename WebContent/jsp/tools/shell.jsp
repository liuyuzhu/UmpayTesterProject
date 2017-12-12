<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.*" %>   
<%@ page import="java.util.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>远程操作服务器</title>
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
       
        	  var v =  $("#ip1").val();
              var v1 =  $("#commonds1").val();
              //Ajax调用处理
            $.ajax({
               type: "POST",
               url: "/UmpayTesterProject/LinuxShellServlet",
               data: "ip="+v+"&commonds="+v1,
               success: function(data){
            	  
                        $("#myDiv").html('<h2>'+data+'</h2>');
                  }
            });
            
         });
    });
</script>   

		<form name="/bin/shell" method="post" action="/UmpayTesterProject/LinuxShellServlet">

					<table style="100%">	
					
					<tr>
                <td style="height: 30px;" valign="middle">操作服务器地址<label style="color: red">*</label></td><td>					
                    <input id="ip1"   style="width: 300%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="text" name="ip" list="ip">
					<datalist id="ip">
					     <option value="10.10.178.34" >10.10.178.34</option>
                         <option value="10.10.178.35" >10.10.178.35</option>
                         <option value="10.10.178.36" >10.10.178.36</option>
					</datalist>
					</input></td>
					
				
					<tr>
                <td style="height: 30px;" valign="middle">执行命令<label style="color: red">*</label></td><td>					
                    <input  id="commonds1"   style="width: 300%; height: 100%;border:5px solid blue;padding:5px;background-color:transparent;" type="text"  name="commonds" list="commonds">
					<datalist id="commonds">
					        <option value="/bin/sh   /usr/mpsp/run/11重启fx_resina1.sh"  selected="selected" >重启fx_resina1</option>
                            <option value="/bin/sh   /usr/mpsp/run/5重启resinc5.sh ">重启resinc5</option>
                            <option value="/bin/sh   /usr/mpsp/plat2-cbe/v2/app/script/reserv.sh" >重启plat2-cbe</option>
                            <option value="/bin/sh   /usr/mpsp/fx_plat2-paybusi/v2/app/script/reserv.sh ">重启fx_plat2-paybusi</option>
                            <option value="/bin/sh   /usr/mpsp/run/2重启resinc1.sh" >重启spEnterprise</option>
                            <option value="/bin/sh   /usr/mpsp/DubboServer/SpEnterpriseService/script/reserv.sh" >重启SpEnterpriseService</option>
                            <option value="/bin/sh   /usr/mpsp/apache-tomcat-6.0.41/bin/1重启.sh" >重启cbe_service</option>
                            <option value="/bin/sh   /usr/mpsp/apache-tomcat-6.0.41/bin/1重启.sh" >重启merchant_api</option>
                            <option value="/bin/sh   /usr/mpsp/run/cleanTen.sh" >清理三天前日志</option>
                            <option value="export TERM=xterm & top">top命令</option>
                            <option value="free">free命令</option>
                            <option value="ps -ef|grep java">查看进程</option>
					</datalist>
					</input></td>
					</tr>			
					
					
					
		
</table>
		



</form>
        <button style="height: 40px;  background: green; color: #aaa; padding: 10px;" id="testAjax" type="button">立即执行</button>
        
        <div id="myDiv" style="height: 450px; overflow-y: scroll; background: #333; color: #aaa; padding: 10px;">
		<div>
		</div>
	</div>
</body>
</html>

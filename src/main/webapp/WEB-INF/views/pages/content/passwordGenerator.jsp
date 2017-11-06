<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath =request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String resourcePath = basePath + "static/home/";
    String commonPath = basePath + "static/common/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>IACCN敏捷管理系统</title>
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<link rel="stylesheet" href="<%=commonPath%>bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=commonPath%>fonts/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=resourcePath%>css/index.css">
	<script src="<%=commonPath%>jquery/jQuery-2.2.0.min.js"></script>
	<script src="<%=commonPath%>charts/Chart.js"></script>
    <script src="<%=commonPath%>bootstrap/js/bootstrap.min.js"></script>
  
	<!-- Page script -->
	<script>
	<!--密码加密-->
	function encryptPwd(){
		$("#encryptPwdContentId").html("");
		$("#encryptKeyContentId").html("");
		var emp_Password=$("#emp_PasswordId").val();
		
		$.ajax({
	        url: "../password/encryptPwd.do",
	        type: 'GET',
	        data: {"emp_Password":emp_Password},
	        cache: false,
	        contentType:'text/json',
	        success: function (data) {
	        	var jsonObj = eval( '(' + data + ')' );  // eval();方法
	        	if(jsonObj.returnCode=="0001"){
	        		parent.alertDialog("温馨提示",'10','50','加密参数不能为空','');
	    	        //弹出层效果
	    	        //alert('加密参数不能为空');
	        	}else if(jsonObj.returnCode=="0002"){
	        		parent.alertDialog("温馨提示",'10','50','密码加密失败','');
	        	}else{
	        		$("#encryptPwdContentId").html(jsonObj.password);
	        		$("#encryptKeyContentId").html(jsonObj.publicKey);
	        	}
	        },
	        error: function (jqXHR, textStatus, errorThrown) {
	        	parent.alertDialog("温馨提示",'10','50','系统异常，加密失败','');
	        }
		});
	}
	
	<!--数据解密方法-->
	function decryptPwd(){
		$("#decryptPwdContentId").html("");
		var pwdMiWen=$("#pwdMiWen").val();
		var pubkeyMiWen=$("#pubkeyMiWen").val();
		$.ajax({
	        url: "../password/decryptPwd.do",
	        type: 'GET',
	        data: {"pwdMiWen":pwdMiWen,"pubkeyMiWen":pubkeyMiWen},
	        cache: false,
	        contentType:'text/json',
	        success: function (data) {
	        	var jsonObj = eval( '(' + data + ')' );  // eval();方法
	        	if(jsonObj.returnCode=="0001"){
	    	        //弹出层效果
	    	        parent.alertDialog("温馨提示",'10','50','待解密密码不能为空','');
	        	}else if(jsonObj.returnCode=="0002"){
	        		parent.alertDialog("温馨提示",'10','50','待解密公共KEY不能为空','');
	        	}else if(jsonObj.returnCode=="0003"){
	        		parent.alertDialog("温馨提示",'10','50','数据解密失败','');
	        	}else{
	        		$("#decryptPwdContentId").html(jsonObj.password);
	        	}
	        },
	        error: function (jqXHR, textStatus, errorThrown) {
	        	parent.alertDialog("温馨提示",'10','50','系统异常，解密失败','');
	        }
		});
	}

    </script>
</head>
<body>
	<div id="areascontent">
		<div class="rows" style="overflow: hidden;">
			<div style="float: left; width: 33.8%; margin-right: 0.8%;">
				<form class="bs-example bs-example-form" role="form">
					<div class="input-group">
						<span class="input-group-addon">待加密密码</span>
						<input id="emp_PasswordId" type="text" class="form-control" placeholder="请输入待加密的明文密码">
					</div>
				</form>
			</div>
			<div style="float: left; width: 60.6%; margin-right: 0.8%;">
				<!-- 提供额外的视觉效果，标识一组按钮中的原始动作 -->
				<button type="button" class="btn btn-primary" onclick="encryptPwd();">数据加密</button>
			</div>
			
		</div>
		<div id="encryptPwdId" style="width:100%;height:auto;margin-top: 15px;">
				[加密后密文]：<span id="encryptPwdContentId" style="color:#337ab7;"></span><br/>
				<br/>
				[公&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;钥]：<span id="encryptKeyContentId" style="color:#337ab7;"></span>
				<br/>
				<br/>
		</div>
		<div class="rows" style="overflow: hidden;">
			<div style="float: left; width: 33.8%; margin-right: 0.8%;">
				<form class="bs-example bs-example-form" role="form">
					<div class="input-group">
						<span class="input-group-addon">待解密密码</span>
						<input id="pwdMiWen" type="text" class="form-control" placeholder="请输入待解密的密文密码">
					</div>
					<br/>
					<div class="input-group">
						<span class="input-group-addon">待解密Key</span>
						<input id="pubkeyMiWen" type="text" class="form-control" placeholder="请输入待解密的密文密码">
					</div>
				</form>
			</div>
			<div style="float: left; width: 34.6%; margin-right: 0.8%;">
				<!-- 提供额外的视觉效果，标识一组按钮中的原始动作 -->
				<button type="button" class="btn btn-primary" onclick="decryptPwd();">数据解密</button>
			</div>
		</div>
		<div id="decryptPwdId" style="width:100%;height:auto;margin-top: 15px;">
			明文密码：<span id="decryptPwdContentId"></span>
		</div>
	</div>
</body>
</html>
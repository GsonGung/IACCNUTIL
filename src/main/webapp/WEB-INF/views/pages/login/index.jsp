<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String resourcePath = basePath + "static/login/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	//检查浏览器版本
	var Sys = {};
	var ua = navigator.userAgent.toLowerCase();
	var s;
	(s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] : (s = ua
			.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] : (s = ua
			.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] : (s = ua
			.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] : (s = ua
			.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;

	//低于IE9以下进行跳转
	if (Sys.ie < 9) {
		//window.location.href = "sorry-for-ie.htm";
	}
</script>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	response.flushBuffer();
%>
<!-- page title -->
<title>XXXXX专业服务系统</title>
<!-- styles -->
<link href="<%=resourcePath%>css/bootstrap.css" rel="stylesheet"
	type="text/css" />
<link href="<%=resourcePath%>css/bootstrap-responsive.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>static/common/fonts/css/font-awesome.css"
	rel="stylesheet" type="text/css" />
<link href="<%=resourcePath%>css/site.css" rel="stylesheet"
	type="text/css" />
<link href="<%=resourcePath%>css/index.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>static/pics/favicon.ico" rel="shortcut icon"
	type="text/css">
</head>
<body>
	<div id="loading" class="modal-backdrop">
		<div class="loading-container">
			<div class="loading-content">
				<progress> <i></i> </progress>
				<span>正在加载...</span>
			</div>
		</div>
	</div>
	<script src="<%=resourcePath%>js/login.js" type="text/javascript"></script>
	<div id="logo">
		<div class="isslogo pull-right"></div>
		<div style="width: 350px;" class="ipsalogo">
			<span>欢迎登录</span>
		</div>
	</div>
	<div id="g_loginform">
		<ol id="bgslideol">
			<li class="active" ajax-id="0"></li>
			<li class="active" ajax-id="1"></li>
			<li class="active" ajax-id="2"></li>
			<li class="active" ajax-id="3"></li>
		</ol>
		<form action="<%=basePath%>/login/loginValidate.do" method="post">
			<div id="DomainName" style="height: 70px;">
				<label>用户名:</label> <input type="text" name="emp_DomainName"
					id="emp_DomainName" tabindex="0" class="textinput"
					placeholder="账号/手机号码/邮箱" value="" /> <i class="icon-user"></i><span
					class="help-block">请输入域帐号/邮箱</span>
			</div>
			<div id="Password" class="" style="height: 70px;">
				<label>密&nbsp;&nbsp;&nbsp;&nbsp;码:</label> <input type="password"
					name="emp_Password" id="emp_Password" tabindex="0"
					placeholder="数字与字母组合的密码" class="textinput" /> <i class="icon-lock"></i>
				<span class="help-block">请输入密码</span>

			</div>
			<label class="checkbox inline password"> <input
				type="checkbox" tabindex="2" name="RemeberMe" id="RemeberMe"
				/> <label for="forgetpassword">记住用户名<em>·</em><a
					href="#" id="ForgetPassword" tabindex="4">忘记密码?</a></label>
			</label>
			<div class="clearfix"></div>

			<div id="Submit" class="DiaoCha">
				<span id="errorId" class="help-block"></span> <input type="button"
					class="btn" value="登录" id="BtnLogin" tabindex="3"
					style="margin-top: 20px;" onclick="loginValiDate();" /> <input
					type="button" class="btn" value="注册" id="BtnHIPO" tabindex="3"
					style="width: 45%; float: right; margin-top: 20px; display: none;" />
				<input type="button" class="btn" value="年度调查" id="BtnQ12"
					tabindex="4"
					style="width: 45%; float: right; margin-top: 20px; display: none;" />
				<input type="button" class="btn" value="入职报名" id="BtnQS"
					tabindex="4"
					style="width: 45%; float: right; margin-top: 20px; display: none;" />

			</div>
			<div id="newEMP">
				<a target="_blank" class="btn btn-info" href="#">新员工入职办理 </a>
			</div>
			<div style="text-align: center; margin-top: 8px;"
				id="gotomobiledownload">
				<a target="_blank" href="">iPSA手机客户端下载 </a>
			</div>
			<input id="DomainUrl" name="DomainUrl" type="hidden" value="" /> <input
				id="ReturnUrl" name="ReturnUrl" type="hidden" value="" />
		</form>
	</div>
	<div id="g_footer" class="container  fix">
		<div class="row-fluid">
			<div class="navbar">
				<ul class="nav pull-right">
					<li><a target="_blank" href="<%=basePath%>/login/toLogin2.do">管理后台</a>
					</li>
					<li><span>|</span></li>
					<li><a href="#">帮助</a></li>
					<li><span>|</span></li>
					<li><a href="" target="_blank">公司网站</a></li>
					<li><span>|</span></li>
					<li><a href="" target="_blank">公司邮箱</a></li>
					<li><span>|</span></li>
					<li><a target="_blank" href="" id="apple"></a></li>
					<li id="g_language" class="dropup"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown" title="简体中文">简体中文<b
							class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#" title="English" lang="en-US"><i
									class="icon-flags en-US"></i>English</a></li>
						</ul></li>
				</ul>
				<p class="copyright">
					<a class="brand" href="" target="_blank"></a>© 2001-2017 版权所有
					XXXX信息技术有限公司
				</p>
			</div>
		</div>
		<input id="flag" name="flag" type="hidden" value="" /> <input
			id="uname" name="uname" type="hidden" value="" /> <input id="ctip"
			name="ctip" type="hidden" value="登录" /> <input id="etip" name="etip"
			type="hidden" value="正在登录..." /> <input id="bgstr" name="bgstr"
			type="hidden"
			value="<%=resourcePath%>images/zhanlve.jpg,<%=resourcePath%>images/keyword.jpg,<%=resourcePath%>images/chixu.jpg,<%=resourcePath%>images/daoshizhi.png" />
	</div>
	<!-- javascript -->
	<script src="<%=resourcePath%>js/jquery-1.9.1.js"
		type="text/javascript"></script>
	<script src="<%=resourcePath%>js/microsoftajax.js"
		type="text/javascript"></script>
	<script src="<%=resourcePath%>js/jquery.form.min.js"
		type="text/javascript"></script>
	<script src="<%=resourcePath%>js/bootstrap-2.3.1.js"
		type="text/javascript"></script>
	<script src="<%=resourcePath%>js/snow.js" type="text/javascript"></script>
	<script src="<%=resourcePath%>js/jquery.bgswitcher.min.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(login.pageload);
		var ua = navigator.userAgent.toLowerCase();
		if ((/iphone|ipad|ipod/.test(ua)) || (/android/.test(ua)))
			$("#gotomobiledownload").show();
		else
			$("#gotomobiledownload").hide();
	</script>
	<script type="text/javascript">
		document.onkeydown = function(event) {
			var e = event || window.event
					|| arguments.callee.caller.arguments[0];
			if (e && e.keyCode == 13) { // enter 键
				//回车键提交登录
				loginValiDate();
			}
		};
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			//记住密码功能
			var str = getCookie("loginInfo");
			if($.trim(str) == ''){
				$("#RemeberMe").prop("checked", false);
				return;
			}
			str = str.substring(1, str.length - 1);
			var username = str.split(",")[0];
			var password = str.split(",")[1];
			//自动填充用户名和密码
			$("#emp_DomainName").val(username);
			$("#emp_Password").val(password);
			$("#RemeberMe").prop("checked", true);
		});

		//获取cookie
		function getCookie(cname) {
			var name = cname + "=";
			var ca = document.cookie.split(';');
			for (var i = 0; i < ca.length; i++) {
				var c = ca[i];
				while (c.charAt(0) == ' ')
					c = c.substring(1);
				if (c.indexOf(name) != -1)
					return c.substring(name.length, c.length);
			}
			return "";
		}
	</script>
</body>
</html>
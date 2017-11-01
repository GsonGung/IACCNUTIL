<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String resourcePath = basePath + "static/login2/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
    //检查浏览器版本
    var Sys = {};
    var ua = navigator.userAgent.toLowerCase();
    var s;
    (s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] :
         (s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :
        (s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :
        (s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :
         (s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;

    //低于IE9以下进行跳转
    if (Sys.ie < 9) {
        //window.location.href = "sorry-for-ie.htm";
    }
</script>
<html lang="en" class="no-js">
	<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
	<%response.setHeader("Pragma","No-cache"); 
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0); 
	response.flushBuffer();%>
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<title>login</title>
	<link rel="stylesheet" type="text/css" href="<%=resourcePath%>css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="<%=resourcePath%>css/demo.css" />
	<!--必要样式-->
	<link rel="stylesheet" type="text/css" href="<%=resourcePath%>css/component.css" />
    <link href="<%=basePath%>static/pics/favicon.ico" rel="shortcut icon" type="text/css">
</head>
<body>
	<div class="container demo-1">
	<div class="content">
		<div id="large-header" class="large-header">
			<canvas id="demo-canvas"></canvas>
			<div class="logo_box">
				<h3>欢迎你</h3>
				<form action="#" name="f" method="post">
					<div class="input_outer">
						<span class="u_user"></span>
						<input id="logname" name="logname" class="text" style="color: #FFFFFF !important;type="text" placeholder="请输入账户">
					</div>
					<div class="input_outer">
						<span class="us_uer"></span>
						<input id="logpass" name="logpass" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
					</div>
					<div class="mb2"><a class="act-but submit" href="javascript:;" style="color: #FFFFFF">登录</a></div>
				</form>
			</div>
		</div>
	</div>
	</div><!-- /container -->
	<script src="<%=resourcePath%>js/tweenlite.min.js"></script>
	<script src="<%=resourcePath%>js/easepack.min.js"></script>
	<script src="<%=resourcePath%>js/raf.js"></script>
	<script src="<%=resourcePath%>js/demo-1.js"></script>
</body>
</html>
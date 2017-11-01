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
	<title>敏捷管理系统</title>
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<link rel="stylesheet" href="<%=commonPath%>bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=commonPath%>fonts/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="<%=resourcePath%>css/index.css">
	<script src="<%=commonPath%>jquery/jQuery-2.2.0.min.js"></script>
	<script src="<%=commonPath%>charts/Chart.js"></script>
    <script src="<%=commonPath%>bootstrap/js/bootstrap.min.js"></script>
  
<!-- Page script -->
	<script>
	        //弹出层效果
	        function showDialog(){
	        	var dialogInfo = {
	        		   closable: false,
	        		   width:'800px',
		       		   title:"测试",
			       		buttons: [{
			                label: '取消',
			                action: function(dialog) {
			                	dialog.close();
			                }
			            }, {
			                label: '保存',
			                action: function(dialog) {
			                    dialog.close();
			                }
			            }],
		               message: $('<div></div>').load('<%=basePath%>/home/toContent')
		        };
	        	parent.showDialog(dialogInfo);
	        }
	        
	        function confirmDialog(){
	        	parent.confirmDialog("删除用户",'100','50','删除用户【Andy】成功');
	        }
	        
	        function sonTip(){
	        	alert("测试提示");
	        }
	        //单一的提示
	        function alertDialog(){
	        	parent.alertDialog("删除用户",'10','50','删除用户【Andy】成功','');
	        }
	    </script>
</head>
<body>
	<div id="areascontent">
		
		<div class="rows" style="margin-bottom: 0.8%;overflow: hidden;">
			<div style="float: left; width: 33.8%; margin-right: 0.8%;">
				<div
					style="height: 500px; border: 1px solid #e6e6e6; background-color: #fff;">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-send fa-lg" style="padding-right: 5px;"></i><b>准生产线</b>
						</div>
						<div class="panel-body">
							<ul>
								<li><a href="#" target="_blank">【主站服务器】</a><span class="time">106.15.49.48</span></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">BS&nbsp;&nbsp;接口：106.15.49.48:8080</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">FLX接口：106.15.49.48:8080</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库IP地址：106.15.49.48</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库端口：</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库名称：</a></li>
								<li><a href="#"	target="_blank" style="padding-left: 25px;">数据库用户名：</a></li>
								<li><a href="#"	target="_blank" style="padding-left: 25px;">数据库密码：</a></li>
								<li><a href="#"	target="_blank">【子站服务器】</a><span class="time">192.168.0.6</span></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">BS&nbsp;&nbsp;接口：192.168.0.6:8080</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">FLX接口：192.168.0.6:8080</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库IP地址：192.168.0.6</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库端口：1433</a></li>
								<li><a href="#"	target="_blank" style="padding-left: 25px;">数据库名称：FlxDB30</a></li>
								<li><a href="#"	target="_blank" style="padding-left: 25px;">数据库用户名：eos</a></li>
								<li><a href="#"	target="_blank" style="padding-left: 25px;">数据库密码：eos</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div style="float: left; width: 34.6%; margin-right: 0.8%;">
				<div
					style="height: 500px; border: 1px solid #e6e6e6; background-color: #fff;">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-rss fa-lg" style="padding-right: 5px;"></i><b>项目组内部测试线</b>
						</div>
						<div class="panel-body">
							<ul>
								<li><a href="#" target="_blank">【主站服务器】</a><span class="time">120.26.130.62</span></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">BS&nbsp;&nbsp;接口：120.26.130.62:8080</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">FLX接口：120.26.130.62:8080</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库IP地址：120.26.130.62</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库端口：1433</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库名称：FlxServerDB30</a></li>
								<li><a href="#"	target="_blank" style="padding-left: 25px;">数据库用户名：mj_flx_server_admin</a></li>
								<li><a href="#"	target="_blank" style="padding-left: 25px;">数据库密码：MjFlxServerAdminP@ssw0rd</a></li>
								<li><a href="#"	target="_blank">【子站服务器】</a><span class="time">120.26.130.90</span></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">BS&nbsp;&nbsp;接口：120.26.130.90:18080</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">FLX接口：120.26.130.90:28080</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库IP地址：120.26.130.62</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库端口：1433</a></li>
								<li><a href="#"	target="_blank" style="padding-left: 25px;">数据库名称：FlxClientDB30</a></li>
								<li><a href="#"	target="_blank" style="padding-left: 25px;">数据库用户名：mj_flx_client_admin</a></li>
								<li><a href="#"	target="_blank" style="padding-left: 25px;">数据库密码：MjFlxClientAdminP@ssw0rd</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div style="float: right; width: 30%;">
				<div
					style="height: 500px; border: 1px solid #e6e6e6; background-color: #fff;">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-thumbs-o-up fa-lg" style="padding-right: 5px;"></i><b>输出测试线</b>
						</div>
						<div class="panel-body">
							<ul>
								<li><a href="#" target="_blank">【主站服务器】</a><span class="time">192.168.1.107</span></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">BS&nbsp;&nbsp;接口：192.168.1.107:8080</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">FLX接口：192.168.0.6:8080</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库IP地址：192.168.0.6</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库端口：1433</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库名称：FlxDB30</a></li>
								<li><a href="#"	target="_blank" style="padding-left: 25px;">数据库用户名：eos</a></li>
								<li><a href="#"	target="_blank" style="padding-left: 25px;">数据库密码：eos</a></li>
								<li><a href="#"	target="_blank">【子站服务器】</a><span class="time">192.168.0.6</span></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">BS&nbsp;&nbsp;接口：192.168.0.6:8080</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">FLX接口：192.168.0.6:8080</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库IP地址：192.168.0.6</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库端口：1433</a></li>
								<li><a href="#"	target="_blank" style="padding-left: 25px;">数据库名称：FlxDB30</a></li>
								<li><a href="#"	target="_blank" style="padding-left: 25px;">数据库用户名：eos</a></li>
								<li><a href="#"	target="_blank" style="padding-left: 25px;">数据库密码：eos</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="rows" style="margin-bottom: 0.8%;overflow: hidden;">
			<div style="float: left; width: 33.8%; margin-right: 0.8%;">
				<div
					style="height: 500px; border: 1px solid #e6e6e6; background-color: #fff;">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-send fa-lg" style="padding-right: 5px;"></i><b>CA服务器</b>
						</div>
						<div class="panel-body">
							<ul>
								<li><a href="#" target="_blank">【测试服务器】</a><span class="time">120.26.130.62</span></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">CA访问地址：120.26.130.62:38080</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库地址：120.26.130.62</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库端口：1433</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库名称：FlxServerDB</a></li>
								<li><a href="#"	target="_blank" style="padding-left: 25px;">数据库用户名：mj_flx_server_admin</a></li>
								<li><a href="#"	target="_blank" style="padding-left: 25px;">数据库密码：MjFlxServerAdminP@ssw0rd</a></li>
								<li><a href="#" target="_blank">【测试服务器】</a><span class="time">192.168.1.107</span></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">CA访问地址：</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库地址：</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库端口：</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库名称：</a></li>
								<li><a href="#"	target="_blank" style="padding-left: 25px;">数据库用户名：</a></li>
								<li><a href="#"	target="_blank" style="padding-left: 25px;">数据库密码：</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div style="float: left; width: 34.6%; margin-right: 0.8%;">
				<div
					style="height: 500px; border: 1px solid #e6e6e6; background-color: #fff;">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-rss fa-lg" style="padding-right: 5px;"></i><b>信用卡还款服务器</b>
						</div>
						<div class="panel-body">
							<ul>
								<li><a href="#" target="_blank">【财务线服务器】</a><span class="time">120.26.130.90</span></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">信用卡访问：120.26.130.90:8080</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库IP地址：120.26.130.90</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库端口：3306</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">数据库名称：EOS</a></li>
								<li><a href="#"	target="_blank" style="padding-left: 25px;">数据库用户名：EOSP@ssw0rd</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<style>
	#copyrightcontent {
		height: 30px;
		line-height: 29px;
		overflow: hidden;
		position: absolute;
		top: 100%;
		margin-top: -30px;
		width: 100%;
		background-color: #fff;
		border: 1px solid #e6e6e6;
		padding-left: 10px;
		padding-right: 10px;
	}
	
	.dashboard-stats {
		float: left;
		width: 25%;
	}
	
	.dashboard-stats-item {
		position: relative;
		overflow: hidden;
		color: #fff;
		cursor: pointer;
		height: 105px;
		margin-right: 10px;
		margin-bottom: 10px;
		padding-left: 15px;
		padding-top: 20px;
	}
	
	.dashboard-stats-item .m-top-none {
		margin-top: 5px;
	}
	
	.dashboard-stats-item h2 {
		font-size: 28px;
		font-family: inherit;
		line-height: 1.1;
		font-weight: 500;
		padding-left: 70px;
	}
	
	.dashboard-stats-item h2 span {
		font-size: 12px;
		padding-left: 5px;
	}
	
	.dashboard-stats-item h5 {
		font-size: 12px;
		font-family: inherit;
		margin-top: 1px;
		line-height: 1.1;
		padding-left: 70px;
	}
	
	.dashboard-stats-item .stat-icon {
		position: absolute;
		top: 18px;
		font-size: 50px;
		opacity: .3;
	}
	
	.dashboard-stats i.fa.stats-icon {
		width: 50px;
		padding: 20px;
		font-size: 50px;
		text-align: center;
		color: #fff;
		height: 50px;
		border-radius: 10px;
	}
	
	.panel-default {
		border: none;
		border-radius: 0px;
		margin-bottom: 0px;
		box-shadow: none;
		-webkit-box-shadow: none;
	}
	
	.panel-default>.panel-heading {
		color: #777;
		background-color: #fff;
		border-color: #e6e6e6;
		padding: 10px 10px;
	}
	
	.panel-default>.panel-body {
		padding: 10px;
		padding-bottom: 0px;
	}
	
	.panel-default>.panel-body ul {
		overflow: hidden;
		padding: 0;
		margin: 0px;
		margin-top: -5px;
	}
	
	.panel-default>.panel-body ul li {
		line-height: 27px;
		list-style-type: none;
		white-space: nowrap;
		text-overflow: ellipsis;
	}
	
	.panel-default>.panel-body ul li .time {
		color: #a1a1a1;
		float: right;
		padding-right: 5px;
	}

</style>
</body>
</html>
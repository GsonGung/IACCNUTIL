<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
			String resourcePath = basePath + "static/home/";
			String commonPath = basePath + "static/common/";
%>
<!DOCTYPE html>
<html>
<head>
<title>IACCN敏捷后台</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">

<!-- 旧的开始 -->
<link rel="stylesheet" href="<%=resourcePath%>css/index.css">
<link rel="stylesheet" href="<%=resourcePath%>css/skins/_all-skins.css">
<link href="<%=basePath%>static/pics/favicon.ico" rel="shortcut icon"
	type="text/css">
<!-- 旧的结束 -->
<!-- 弹出层dialog -->
<link
	href="<%=commonPath%>bootstrap3-dialog/css/bootstrap-dialog.min.css"
	rel="stylesheet" type="text/css" />
<!-- Select2 -->
<link rel="stylesheet" href="<%=commonPath%>select2/select2.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="<%=commonPath%>dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
    folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="<%=commonPath%>dist/css/skins/_all-skins.min.css">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="<%=commonPath%>bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<%=commonPath%>bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="<%=commonPath%>bower_components/Ionicons/css/ionicons.min.css">
<script>
	//弹出层效果
	//str：弹出层类型
	//url：待加载路径  
	function showDialog(dialogInfo) {
		BootstrapDialog.show(dialogInfo);
	}
	//弹出确认信息层
	function confirmDialog(title, methods, width, height) {

		var dlgConfirm = BootstrapDialog.confirm({
			title : '图片上传',
			type : BootstrapDialog.TYPE_PRIMARY,
			message : "你确定要删除信息吗？",
			draggable : true,
			callback : function(result) {
				if (result == true) {
					//0001为Ifream name
					window.frames['0001'].sonTip();
				}
			}
		});
	}

	//单一提示层
	function alertDialog(title, width, height, tipContent, closeTime) {
		var titleDefault = "温馨提示";
		var widthDefault = "150px !important";
		var heightDefault = "150px !important";

		if (title != null && title != undefined && title != '') {
			titleDefault = title;
		}
		if (width != null && width != undefined && width != '') {
			heightDefault = width;
		}
		if (height != null && height != undefined && height != '') {
			heightDefault = height;
		}
		var dlg = BootstrapDialog.alert({
			title : titleDefault,
			width : widthDefault,
			height : heightDefault,
			message : tipContent
		});
		$("#dialogTipId").css("width", widthDefault);
		//窗体关闭时间
		if (closeTime != null && closeTime != undefined && closeTime != '') {
			setTimeout(function() {
				dlg.close();
			}, closeTime);
		}
	}
</script>
</head>
<body class="hold-transition skin-blue sidebar-mini"
	style="overflow: hidden;">
	<!--页面遮罩层-->
	<div id="ajax-loader"
		style="cursor: progress; position: fixed; top: -50%; left: -50%; width: 200%; height: 200%; background: #fff; z-index: 10000; overflow: hidden;">
		<img src="<%=resourcePath%>img/ajax-loader.gif"
			style="position: absolute; top: 0; left: 0; right: 0; bottom: 0; margin: auto;" />
	</div>
	<!--页面头部区域-->
	<div class="wrapper">
		<!--头部信息-->
		<header class="main-header">
			<a href="javascript:void(0);" target="_blank" class="logo"> <span
				class="logo-mini"><font color="red">IACNN</font></span> <span
				class="logo-lg"><font color="red">IACCN</font><strong>敏捷框架</strong></span>
			</a>
			<!--头部右侧内容区-->
			<nav class="navbar navbar-static-top">
				<!--菜单折叠切换按钮-->
				<a class="sidebar-toggle"> <span class="sr-only">Toggle
						navigation</span>
				</a>
				<!--右侧按钮区域-->
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!--邮件消息-->
						<li class="dropdown messages-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-envelope-o "></i> <span class="label label-success">4</span>
						</a></li>
						<!--通知消息-->
						<li class="dropdown notifications-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-bell-o"></i> <span class="label label-warning">10</span>
						</a></li>
						<!--任务通知-->
						<li class="dropdown tasks-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-flag-o"></i> <span class="label label-danger">9</span>
						</a></li>
						<!--个人头像-->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="<%=commonPath%>${sessionScope.imgUrl}" class="user-image"
								alt="User Image"> <span class="hidden-xs">${sessionScope.realname}</span>
						</a> <!--点击头像，显示下拉菜单-->
							<ul class="dropdown-menu pull-right">
								<li><a class="menuItem" data-id="userInfo"
									href="/SystemManage/User/Info"><i class="fa fa-user"></i>个人信息</a></li>
								<li><a href="javascript:void();"><i
										class="fa fa-trash-o"></i>清空缓存</a></li>
								<li><a href="javascript:void();"><i
										class="fa fa-paint-brush"></i>皮肤设置</a></li>
								<li class="divider"></li>
								<li><a href="../login/outToLogin"><i
										class="ace-icon fa fa-power-off"></i>安全退出</a></li>
							</ul></li>
						<li><a href="#" data-toggle="control-sidebar"><i
								class="fa fa-gears"></i></a></li>
					</ul>
				</div>
			</nav>
		</header>
		<!--左边导航-->
		<div class="main-sidebar">
			<div class="sidebar">
				<!--个人信息-->
				<div class="user-panel">
					<!--头像-->
					<div class="pull-left image">
						<img src="<%=commonPath%>${sessionScope.imgUrl}"
							class="img-circle" alt="User Image">
					</div>
					<!--个人信息和状态-->
					<div style="top: 10px;" class="pull-left info">
						<p>${sessionScope.realname}</p>
						<a><i class="fa fa-circle text-success"></i>在线</a>
					</div>
				</div>
				<!--查询条件-->
				<form action="#" method="get" class="sidebar-form">
					<div class="input-group">
						<input type="text" name="q" class="form-control"
							placeholder="Search..."> <span class="input-group-btn">
							<a class="btn btn-flat"><i class="fa fa-search"></i></a>
						</span>
					</div>
				</form>
				<!--动态菜单显示区-->
				<ul class="sidebar-menu" id="sidebar-menu">
					<!--<li class="header">导航菜单</li>-->
				</ul>
			</div>
		</div>
		<!--中间内容-->
		<div id="content-wrapper" class="content-wrapper">
			<div class="content-tabs">
				<!--往左显示按钮-->
				<button class="roll-nav roll-left tabLeft">
					<i class="fa fa-backward"></i>
				</button>
				<!--默认加载按钮-->
				<nav class="page-tabs menuTabs">
					<div class="page-tabs-content" style="margin-left: 0px;">
						<a href="javascript:;" class="menuTab active" data-id="">欢迎首页</a>
						<a href="javascript:;" class="menuTab" data-id="/Home/About"
							style="padding-right: 15px;">平台介绍 <i class="fa fa-remove"></i></a>
					</div>
				</nav>
				<!--往右加载按钮-->
				<button class="roll-nav roll-right tabRight">
					<i class="fa fa-forward" style="margin-left: 3px;"></i>
				</button>
				<!--右侧功能按钮-->
				<div class="btn-group roll-nav roll-right">
					<button class="dropdown tabClose" data-toggle="dropdown">
						页签操作<i class="fa fa-caret-down" style="padding-left: 3px;"></i>
					</button>
					<ul class="dropdown-menu dropdown-menu-right">
						<li><a class="tabReload" href="javascript:void();">刷新当前</a></li>
						<li><a class="tabCloseCurrent" href="javascript:void();">关闭当前</a></li>
						<li><a class="tabCloseAll" href="javascript:void();">全部关闭</a></li>
						<li><a class="tabCloseOther" href="javascript:void();">除此之外全部关闭</a></li>
					</ul>
				</div>
				<!--全屏，非全屏显示切换按钮-->
				<button class="roll-nav roll-right fullscreen">
					<i class="fa fa-arrows-alt"></i>
				</button>
			</div>

			<!--动态内容显示区-->
			<div class="content-iframe" style="overflow: hidden;">
				<div class="mainContent" id="content-main"
					style="margin: 10px; margin-bottom: 0px; padding: 0;">
					<iframe id="0001" name="0001" class="IACCNPRO_iframe" width="100%"
						height="100%" src="<%=basePath%>/home/toContent" frameborder="0"
						data-id=""></iframe>
				</div>
			</div>

		</div>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Create the tabs -->
			<ul class="nav nav-tabs nav-justified control-sidebar-tabs">
				<li><a href="#control-sidebar-home-tab" data-toggle="tab"><i
						class="fa fa-home"></i></a></li>
				<li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i
						class="fa fa-gears"></i></a></li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content">
				<!-- Home tab content -->
				<div class="tab-pane" id="control-sidebar-home-tab">
					<h3 class="control-sidebar-heading">Recent Activity</h3>
					<ul class="control-sidebar-menu">
						<li><a href="javascript:void(0)"> <i
								class="menu-icon fa fa-birthday-cake bg-red"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

									<p>Will be 23 on April 24th</p>
								</div>
						</a></li>
						<li><a href="javascript:void(0)"> <i
								class="menu-icon fa fa-user bg-yellow"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Frodo Updated His
										Profile</h4>

									<p>New phone +1(800)555-1234</p>
								</div>
						</a></li>
						<li><a href="javascript:void(0)"> <i
								class="menu-icon fa fa-envelope-o bg-light-blue"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Nora Joined Mailing
										List</h4>

									<p>nora@example.com</p>
								</div>
						</a></li>
						<li><a href="javascript:void(0)"> <i
								class="menu-icon fa fa-file-code-o bg-green"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Cron Job 254
										Executed</h4>

									<p>Execution time 5 seconds</p>
								</div>
						</a></li>
					</ul>
					<!-- /.control-sidebar-menu -->

					<h3 class="control-sidebar-heading">Tasks Progress</h3>
					<ul class="control-sidebar-menu">
						<li><a href="javascript:void(0)">
								<h4 class="control-sidebar-subheading">
									Custom Template Design <span
										class="label label-danger pull-right">70%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-danger"
										style="width: 70%"></div>
								</div>
						</a></li>
						<li><a href="javascript:void(0)">
								<h4 class="control-sidebar-subheading">
									Update Resume <span class="label label-success pull-right">95%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-success"
										style="width: 95%"></div>
								</div>
						</a></li>
						<li><a href="javascript:void(0)">
								<h4 class="control-sidebar-subheading">
									Laravel Integration <span
										class="label label-warning pull-right">50%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-warning"
										style="width: 50%"></div>
								</div>
						</a></li>
						<li><a href="javascript:void(0)">
								<h4 class="control-sidebar-subheading">
									Back End Framework <span class="label label-primary pull-right">68%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-primary"
										style="width: 68%"></div>
								</div>
						</a></li>
					</ul>
					<!-- /.control-sidebar-menu -->

				</div>
				<!-- /.tab-pane -->
				<!-- Stats tab content -->
				<div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab
					Content</div>
				<!-- /.tab-pane -->
				<!-- Settings tab content -->
				<div class="tab-pane" id="control-sidebar-settings-tab">
					<form method="post">
						<h3 class="control-sidebar-heading">General Settings</h3>

						<div class="form-group">
							<label class="control-sidebar-subheading"> Report panel
								usage <input type="checkbox" class="pull-right" checked>
							</label>

							<p>Some information about this general settings option</p>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Allow mail
								redirect <input type="checkbox" class="pull-right" checked>
							</label>

							<p>Other sets of options are available</p>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Expose author
								name in posts <input type="checkbox" class="pull-right" checked>
							</label>

							<p>Allow the user to show his name in blog posts</p>
						</div>
						<!-- /.form-group -->

						<h3 class="control-sidebar-heading">Chat Settings</h3>

						<div class="form-group">
							<label class="control-sidebar-subheading"> Show me as
								online <input type="checkbox" class="pull-right" checked>
							</label>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Turn off
								notifications <input type="checkbox" class="pull-right">
							</label>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Delete chat
								history <a href="javascript:void(0)" class="text-red pull-right"><i
									class="fa fa-trash-o"></i></a>
							</label>
						</div>
						<!-- /.form-group -->
					</form>
				</div>
				<!-- /.tab-pane -->
			</div>
		</aside>
		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<content tag="local_script"> <!--加载对应的JS文件--> <script
		src="<%=commonPath%>jquery/jQuery-2.2.0.min.js"></script> <script
		src="<%=commonPath%>bootstrap/js/bootstrap.min.js"></script> <script
		src="<%=commonPath%>bower_components/jquery-ui/jquery-ui.min.js"></script>
	<!-- Select2 --> <script
		src="<%=commonPath%>select2/select2.full.min.js"></script> <script
		src="<%=commonPath%>dist/js/adminlte.min.js"></script> <script
		src="<%=resourcePath%>js/index.js"></script> <script
		src="<%=resourcePath%>js/home.js"></script> <!-- 旧的结束 --> <script
		src="<%=commonPath%>bootstrap3-dialog/js/bootstrap-dialog.min.js"></script>
	<script type="text/javascript">
		$(function() {
			//Initialize Select2 Elements
			$(".select2").select2();
		});
	</script> </content>
</body>
</html>
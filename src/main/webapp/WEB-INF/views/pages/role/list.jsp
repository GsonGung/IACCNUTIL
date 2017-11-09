<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
			String commonPath = basePath + "static/common/";
			String layerPath = basePath + "static/layer/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Data Tables</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="<%=commonPath%>bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<%=commonPath%>bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="<%=commonPath%>bower_components/Ionicons/css/ionicons.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="<%=commonPath%>bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="<%=commonPath%>dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="<%=commonPath%>dist/css/skins/_all-skins.min.css">
<link rel="stylesheet" href="<%=layerPath%>css/layui.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- Left side column. contains the logo and sidebar -->
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Data Tables <small>advanced tables</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li><a href="#">Tables</a></li>
					<li class="active">Data tables</li>
				</ol>
			</section>
			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">Hover Data Table</h3>
							</div>
							<ul id="demo"></ul>
							<table class="layui-table"
								lay-data="{height:315, url:'<%=layerPath%>table.json', page:true, id:'test'}"
								lay-filter="test">
								<thead>
									<tr>
										<th lay-data="{field:'id', width:80, sort: true}">ID</th>
										<th lay-data="{field:'username', width:80}">用户名</th>
										<th lay-data="{field:'sex', width:80, sort: true}">性别</th>
										<th lay-data="{field:'city', width:80}">城市</th>
										<th lay-data="{field:'sign', width:177}">签名</th>
										<th lay-data="{field:'experience', width:80, sort: true}">积分</th>
										<th lay-data="{field:'score', width:80, sort: true}">评分</th>
										<th lay-data="{field:'classify', width:80}">职业</th>
										<th lay-data="{field:'wealth', width:135, sort: true}">财富</th>
									</tr>
								</thead>
							</table>
							<!-- /.box-header -->
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<div class="pull-right hidden-xs">
				<b>Version</b> 2.4.0
			</div>
			<strong>Copyright &copy; 2014-2016 <a
				href="https://adminlte.io">Almsaeed Studio</a>.
			</strong> All rights reserved.
		</footer>

		<!-- Control Sidebar -->
		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->

	<!-- jQuery 3 -->
	<script src="<%=commonPath%>bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script
		src="<%=commonPath%>bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- DataTables -->
	<script
		src="<%=commonPath%>bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
	<script
		src="<%=commonPath%>bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<!-- SlimScroll -->
	<script
		src="<%=commonPath%>bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script
		src="<%=commonPath%>bower_components/fastclick/lib/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="<%=commonPath%>dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="<%=commonPath%>dist/js/demo.js"></script>
	<!-- Layer Tree -->
	<script src="<%=layerPath%>layui.js" charset="utf-8"></script>
	<!-- tree script -->
	<script type="text/javascript">
		layui.use('tree', function() {
			layui.tree({
				elem : '#demo',
				nodes : [ { //节点数据
					name : '节点A',
					children : [ {
						name : '节点A1'
					} ]
				}, {
					name : '节点B',
					children : [ {
						name : '节点B1',
						alias : 'bb' //可选
						,
						id : '123' //可选
					}, {
						name : '节点B2'
					} ]
				} ],
				click : function(node) {
					console.log(node) //node即为当前点击的节点数据
				}
			});
		});
	</script>
	<!-- tree script -->
	<script type="text/javascript">
		layui.use('table', function(){
			  var table = layui.table;
			});
		
	</script>
</body>
</html>

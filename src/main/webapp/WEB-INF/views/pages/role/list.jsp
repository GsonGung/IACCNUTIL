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

							<div class="layui-btn-group">
								<button class="layui-btn" data-type="getCheckData">获取选中行数据</button>
								<button class="layui-btn" data-type="getCheckLength">获取选中数目</button>
								<button class="layui-btn" data-type="isAll">验证是否全选</button>
								<button class="layui-btn" data-type="addRole">新增</button>
								<button class="layui-btn" data-type="delRoles">删除</button>
							</div>
							<table class="layui-table"
								lay-data="{height:471, url:'<%=basePath%>role/getRoleList', page:true, id:'test', limit: 10}"
								lay-filter="test">
								<thead>
									<tr>
										<th lay-data="{checkbox:true, fixed: true}"></th>
										<th lay-data="{field:'id', width:80, sort: true}">编号</th>
										<th lay-data="{field:'role_name', width:100}">角色名称</th>
										<th lay-data="{field:'role_code', width:100}">角色代码</th>
										<th lay-data="{field:'permissions', width:100}">拥有权限</th>
										<th lay-data="{field:'create_by', width:100}">创建人员</th>
										<th lay-data="{field:'create_time', width:200, sort: true}">创建时间</th>
										<th lay-data="{field:'description', width:300}">备注</th>
										<th lay-data="{fixed: 'right', toolbar: '#barDemo', width:150}">操作</th>
									</tr>
								</thead>
							</table>
							<div class="layui-hide" id="barDemo">
								<a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a> <a
									class="layui-btn layui-btn-danger layui-btn-mini"
									lay-event="del">删除</a>
							</div>
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
		
/* 		layui.use('tree', function() {
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
		}); */
	</script>
	<!-- tree script -->
	<script type="text/javascript">
		var basePath = '<%=basePath%>';
		layui.use('table', function() {
			var table = layui.table;
			
			//监听表格复选框选择
			table.on('checkbox(test)', function(obj) {
				console.log(obj);
				return false;
			});

			//监听单元格编辑
			table.on('edit(test)', function(obj) {
				var value = obj.value //得到修改后的值
				, data = obj.data //得到所在行所有键值
				, field = obj.field; //得到字段

			});

			//监听工具条
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				if (obj.event === 'del') {
					layer.confirm('确定删除么?', function(index) {
/* 						obj.del();//删除DOM
						layer.close(index);//删除缓存 */
						url = basePath + 'role/delRole?id='+data.id;
						//调用后台
					  	$.ajax({
						    url: url,
							method : "post",
							dataType : "json",
							async : false,
							success : function(data) {
								layer.msg("删除成功！",{time:2000});
							},
							error : function() {
								layer.msg("删除失败！",{time:2000});
							}
						});
						table.reload('test', layer.options);
					});
				} else if (obj.event === 'edit') {
					layer.open({  
					    type: 2,  
					    title: ['修改角色信息', 'background-color: #00bb9d;text-align:center;'],  
					    shadeClose: true,  
					    shade: false,  
					    maxmin: true,  
					    area: ['893px', '600px'],  
					    content: basePath + 'role/detail?id=' + data.id + '&type=edit',
					    btn: [],
					    closeBtn: 1,
					    yes: function(){
					    },
					  	cancel: function(){ 
					  	    //右上角关闭回调
					  	    //return false 开启该代码可禁止点击该按钮关闭
					  	},
						end : function() {
						}
					});
				}
			});

			//监听排序
			table.on('sort(test)', function(obj) {
				console.log(this, obj.field, obj.type)

				return;
				table.reload('test', {
					initSort : obj,
					where : { //重新请求服务端
						key : obj.field //排序字段
						,
						order : obj.type
					//排序方式
					}
				//,height: 300
				});
			});

			var $ = layui.jquery, active = {
				getCheckData : function() {
					var checkStatus = table.checkStatus('test'), data = checkStatus.data;
					layer.alert(JSON.stringify(data));
				},
				getCheckLength : function() {
					var checkStatus = table.checkStatus('test'), data = checkStatus.data;
					layer.msg('选中了：' + data.length + ' 个');
				},
				isAll : function() {
					var checkStatus = table.checkStatus('test');
					layer.msg(checkStatus.isAll ? '全选' : '未全选')
				},
				addRole : function(){
					layer.open({  
					    type: 2,  
					    title: ['新增角色信息', 'background-color: #00bb9d;text-align:center;'],  
					    shadeClose: true,  
					    shade: false,  
					    maxmin: true,  
					    area: ['893px', '600px'],  
					    content: basePath + 'role/detail?type=add',
					    btn: [],
					    closeBtn: 1,
					  	cancel: function(){ 
					  	    //右上角关闭回调
					  	    //return false 开启该代码可禁止点击该按钮关闭
					  	},
						end : function() {
						}
					});
				},
				delRoles : function(){
					var checkStatus = table.checkStatus('test'), data = checkStatus.data;
					var ids = '';
					data.forEach(function(value, index){
						var id = value.id;
						if(index == 0){
							ids += id;
						}else{
							ids += ',' + id;
						}
					});
					layer.confirm('确定批量删除么?', function(index) {
						url = basePath + 'role/delRoles?ids='+ids;
						//调用后台
					  	$.ajax({
						    url: url,
							method : "post",
							dataType : "json",
							async : false,
							success : function(data) {
								layer.msg("删除成功！",{time:2000});
							},
							error : function() {
								layer.msg("删除失败！",{time:2000});
							}
						});
						table.reload('test', layer.options);
					});
				},
				parseTable : function() {
					table.init('parse-table-demo');
				}
			};

			$('.layui-btn').on('click', function() {
				var type = $(this).data('type');
				active[type] ? active[type].call(this) : '';
			});

			/* 		  var layer = layui.layer;
			 layer.msg('hello'); */
			});
	</script>
</body>
</html>

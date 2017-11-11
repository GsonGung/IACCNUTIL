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
<link rel="stylesheet" href="<%=layerPath%>css/layui.css">
<style type="text/css">
    body {
        height: 1200px;
    }

    #demo {
        margin: 30px 100px;
    }

    .descripttion {
        width: 1000px;
        margin: 50px;
    }

    body > ul {
        display: inline-block;
        width: 400px;
        margin: 20px;
    }
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<!-- 弹出层 -->
	<form class="layui-form"> 
		<div class="layui-form-item">
			<ul id="tree"></ul>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</div>
	</form>
	<script src="<%=commonPath%>bower_components/jquery/dist/jquery.min.js"></script>
	<script src="<%=layerPath%>layui.js" charset="utf-8"></script>
	<script type="text/javascript">
		var permissions = ${permissions};
		var roleId = ${roleId};
		var nodes = [];
		alert(JSON.stringify(permissions));
		
	 	layui.use('tree', function() {
				layui.tree({
					elem : '#tree',
					check: 'checkbox',
					change: function (item) { //checkbox获取选中的值
	                },
	                click: function (item) { //点击节点回调
	                },
	                checkedClick: function(item){
	                },
	                data: {//为元素添加额外数据，即在元素上添加data-xxx="yyy"，可选
	                    hasChild: true,
	                },
					nodes : [ { //节点数据
						name : '节点A',
						checked : false,
						children : [ {
							name : '节点A1',
							checked : false
						} ]
					}, {
						name : '节点B',
						children : [ {
							name : '节点B1',
							checked : true,
							alias : 'bb' //可选
							,
							id : '123' //可选
						}, {
							name : '节点B2',
							checked : false
						} ]
					} ],
				});
			}); 
	</script>
</body>
</html>
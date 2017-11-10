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
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<ul id="demo"></ul>
	<!-- 弹出层 -->
	<form id="popupForm" class="layui-form"> 
	<input type="hidden" name="id" value="${role.id}">
		<div class="layui-form-item">
			<label class="layui-form-label"><span><font
					color="red">*</font>名称</span></label>
			<div class="layui-input-block">
				<input type="text" name="roleName" value="${role.roleName}" required
					lay-verify="required" placeholder="请输入角色名称" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label"><span><font
					color="red">*</font>代码</span></label>
			<div class="layui-input-block">
				<input type="text" name="roleCode" value="${role.roleCode}" required
					lay-verify="required" placeholder="请输入角色代码" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label"><span>备注</span></label>
			<div class="layui-input-block">
				<textarea name="description" placeholder="请输入内容"
					class="layui-textarea">${role.description}</textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
	<script src="<%=commonPath%>bower_components/jquery/dist/jquery.min.js"></script>
	<script src="<%=layerPath%>layui.js" charset="utf-8"></script>
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
</body>
</html>
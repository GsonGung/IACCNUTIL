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
		var permissions = JSON.parse('${permissions}');
		var roleId = '${roleId}';
		var jsonDataTree = transData(permissions, 'module_id', 'parent_id', 'children', 'role_id', roleId, 'checked');  
		
	 	layui.use('tree', function() {
	 			var tree = layui.tree;
				layui.tree({
					elem : '#tree',
					check: 'checkbox',
	                click: function (item) { //点击节点回调
	                	
	                },
	                checkedClick: function(item){//checkbox获取选中的值
						
	                },
	                data: {//为元素添加额外数据，即在元素上添加data-xxx="yyy"，可选
	                    hasChild: true,
	                },
					nodes : jsonDataTree,
				});
			}); 
	 	
	 	/** 
	 	 * json格式转树状结构 
	 	 * @param   {json}      json数据 
	 	 * @param   {String}    id的字符串 
	 	 * @param   {String}    父id的字符串 
	 	 * @param   {String}    children的字符串 
	 	 * @return  {Array}     数组 
	 	 */  
	 	function transData(a, idStr, pidStr, chindrenStr, roleIdStr, roleId, checkedStr){  
	 	    var r = [], hash = {}, id = idStr, pid = pidStr, children = chindrenStr, i = 0, j = 0, len = a.length;  
	 	    for(; i < len; i++){
	 	    	if(roleId == a[i][roleIdStr]){
	 	    		a[i][checkedStr] = true;
	 	    	}else{
	 	    		a[i][checkedStr] = false;
	 	    	}
	 	        hash[a[i][id]] = a[i];  
	 	    }  
	 	    for(; j < len; j++){  
	 	        var aVal = a[j], hashVP = hash[aVal[pid]];  
	 	        if(hashVP){  
	 	            !hashVP[children] && (hashVP[children] = []);  
	 	            hashVP[children].push(aVal);  
	 	        }else{  
	 	            r.push(aVal);  
	 	        }  
	 	    }  
	 	    //只保留顶级节点
	 	    
	 	    return r;  
	 	}  
	</script>
	<script type="text/javascript">
	layui.use('form', function(){
		  var form = layui.form;
		  var basePath = '<%=basePath%>';
		  var url = basePath + 'role/updatePermissionTree?roleId=${roleId}&ids=';
		  //监听提交
		  form.on('submit(formDemo)', function(data){
			  var treeNode = $(document).find('.layui-tree');
			  var ids = treeNode.data('treeChecked');
			  url += ids;
			  
			  $.ajax({
				    url: url,
					method : "post",
					dataType : "json",
					async : false,
					data : data.field,
					success : function(data) {
						//假设这是iframe页
						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
						parent.layer.close(index); //再执行关闭  
						//parent.layui.table.reload('test', parent.layer.options);不用刷新table
						layer.msg("操作成功！",{time:2000});
					},
					error : function() {
						layer.msg("操作失败！",{time:2000});
					}
				});
			});
		});
	</script>
</body>
</html>
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
	<!-- DataTables表格插件 -->
	<link rel="stylesheet" type="text/css" href="<%=commonPath%>/datatables/jquery.dataTables.css">
	
	
	<link rel="stylesheet" href="<%=resourcePath%>css/index.css">
	<script src="<%=commonPath%>jquery/jQuery-2.2.0.min.js"></script>
	<script src="<%=commonPath%>charts/Chart.js"></script>
    <script src="<%=commonPath%>bootstrap/js/bootstrap.min.js"></script>
    <!-- DataTables表格插件 -->
    <script type="text/javascript" language="javascript" src="<%=commonPath%>/datatables/jquery.dataTables.js"></script>
    
    
    <style type="text/css">
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
    
        //表格插件
		var table;
		$(document).ready(function() {
		    table = $('#exampleDataTableId').DataTable( {
		        "pagingType": "simple_numbers",//设置分页控件的模式
		         searching: false,//屏蔽datatales的查询框
		         aLengthMenu:[10],//设置一页展示10条记录
		         "bLengthChange": false,//屏蔽tables的一页展示多少条记录的下拉列表
		         "oLanguage": {  //对表格国际化
		            "sLengthMenu": "每页显示 _MENU_条",  
		            "sZeroRecords": "没有找到符合条件的数据",  
		            "sInfo": "当前第 _START_ - _END_ 条　共计 _TOTAL_ 条",  
		            "sInfoEmpty": "木有记录",  
		            "sInfoFiltered": "(从 _MAX_ 条记录中过滤)",  
		            "sSearch": "搜索：",  
		            "oPaginate": {  
		            "sFirst": "首页",  
		            "sPrevious": "前一页",  
		            "sNext": "后一页",  
		            "sLast": "尾页"  
		
		            }  
		        },
		    "processing": true, //打开数据加载时的等待效果
		        "serverSide": true,//打开后台分页
		        "ajax": {
		            "url": "plugManage/loadDataTableList", 
		            "dataSrc": "list", 
		            "data": function ( d ) {
	                       var param = {};
	                       param.id = d.id;
	                       param.name = d.name;
	                       param.phone = d.phone;
	                       //var formData = $("#queryForm").serializeArray();//把form里面的数据序列化成数组
	                       //formData.forEach(function (e) {
	                       //    param[e.name] = e.value;
	                       //});
	                       alert(param);
	                        return param;//自定义需要传递的参数。
		            	//alert(d);
		                //var level1 = $('#list').val();
		                //添加额外的参数传给服务器
		                //d.extra_search = level1;
		            }
		        },
		        "columns": [
		            { "data": "name" },
		            { "data": "id" }
		        ]
		
		    } );
		} );
		
		
		function search1()
		{
		    table.ajax.reload();
		}

    </script>
</head>
<body>
	<div id="areascontent">
		
		<div class="rows" style="margin-bottom: 0.8%;overflow: hidden;">
			<div style="float: left; width: 33.8%; margin-right: 0.8%;">
				<div
					style="height: auto; border: 1px solid #e6e6e6; background-color: #fff;">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-send fa-lg" style="padding-right: 5px;"></i><b>准生产线</b>
						</div>
						<div class="panel-body">
							<ul>
								<li><a href="#" target="_blank">【案例一】</a><span class="time">106.15.49.48</span></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">BS&nbsp;&nbsp;接口：106.15.49.48:8080</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">FLX接口：120.26.130.62:8080</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div style="float: left; width: 34.6%; margin-right: 0.8%;">
				<div style="height: auto; border: 1px solid #e6e6e6; background-color: #fff;">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-rss fa-lg" style="padding-right: 5px;"></i><b>项目组内部测试线</b>
						</div>
						<div class="panel-body">
							<ul>
								<li><a href="#" target="_blank">【案例二】</a><span class="time">120.26.130.62</span></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">BS&nbsp;&nbsp;接口：120.26.130.62:8080</a></li>
								<li><a href="#" target="_blank" style="padding-left: 25px;">FLX接口：120.26.130.62:8080</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<hr style="BORDER-BOTTOM-STYLE: dotted;BORDER-LEFT-STYLE: dotted; BORDER-RIGHT-STYLE: dotted;BORDER-TOP-STYLE: dotted" color=red size=1 >
		<!-- 表单模块 -->
		<div class="rows" style="margin-bottom: 0.8%; overflow: hidden;">
			<div style="float: left; width: 69.2%;">
				<div
					style="height: 100%; border: 1px solid #e6e6e6; overflow: hidden;">
					<div class="dashboard-stats">
						<div class="dashboard-stats-item"
							style="background-color: #578ebe;">
							<div class="stat-icon">
								<i class="fa fa-clock-o"></i>
							</div>
							<h2 class="m-top-none">
								17<span>个</span>
							</h2>
							<h5><a href="#" onclick="showDialog();">待办未处理</a></h5>
						</div>
					</div>
					<div class="dashboard-stats">
						<div class="dashboard-stats-item"
							style="background-color: #e35b5a;">
							<h2 class="m-top-none">
								12<span>条</span>
							</h2>
							<h5><a href="#" onclick="confirmDialog();">预警信息未读</a></h5>
							<div class="stat-icon">
								<i class="fa fa-bell"></i>
							</div>
						</div>
					</div>
					<div class="dashboard-stats">
						<div class="dashboard-stats-item"
							style="background-color: #44b6ae;">
							<h2 class="m-top-none">
								20<span>封</span>
							</h2>
							<h5><a href="#" onclick="alertDialog();">邮件未读</a></h5>
							<div class="stat-icon">
								<i class="fa fa-envelope-o"></i>
							</div>
						</div>
					</div>
					<div class="dashboard-stats">
						<div class="dashboard-stats-item"
							style="background-color: #8775a7; margin-right: 0px;">
							<h2 class="m-top-none">6</h2>
							<h5>对公待签收任务</h5>
							<div class="stat-icon">
								<i class="fa fa-gavel"></i>
							</div>
						</div>
					</div>
					<div class="dashboard-stats">
						<div class="dashboard-stats-item"
							style="background-color: #4f5c65; margin-bottom: 0px;">
							<h2 class="m-top-none">
								324<span>件</span>
							</h2>
							<h5>今日订单数</h5>
							<div class="stat-icon">
								<i class="fa fa-shopping-cart"></i>
							</div>
						</div>
					</div>
					<div class="dashboard-stats">
						<div class="dashboard-stats-item"
							style="background-color: #14aae4; margin-bottom: 0px;">
							<h2 class="m-top-none">
								525<span>件</span>
							</h2>
							<h5>昨日订单数</h5>
							<div class="stat-icon">
								<i class="fa fa-file-text-o"></i>
							</div>
						</div>
					</div>
					<div class="dashboard-stats">
						<div class="dashboard-stats-item"
							style="background-color: #949FB1; margin-bottom: 0px;">
							<h2 class="m-top-none">
								355<span>件</span>
							</h2>
							<h5>回退订单数</h5>
							<div class="stat-icon">
								<i class="fa fa-coffee"></i>
							</div>
						</div>
					</div>
					<div class="dashboard-stats">
						<div class="dashboard-stats-item"
							style="background-color: #f29503; margin-right: 0px; margin-bottom: 0px;">
							<h2 class="m-top-none">
								3335<span>元</span>
							</h2>
							<h5>昨日成交金额</h5>
							<div class="stat-icon">
								<i class="fa fa-rmb" style="padding-left: 10px;"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	    <hr style="BORDER-BOTTOM-STYLE: dotted;BORDER-LEFT-STYLE: dotted; BORDER-RIGHT-STYLE: dotted;BORDER-TOP-STYLE: dotted" color=red size=1 >
        <!-- 表格插件信息 -->
        <table id="exampleDataTableId" class="display" cellspacing="0" width="100%">
	        <thead>
	            <tr>
	                <th>姓名</th>
	                <th>年纪</th>
	                <th>手机</th>
	                <th>邮件</th>
	                <th>地址</th>
	            </tr>
	        </thead>
	    </table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath =
        request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<body>
		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">
					操作提示
				</h3>
			</div>
			<div class="panel-body text-center">
				<i class="fa fa-exclamation-triangle fa-2x"></i>
				<span>抱歉，系统异常，请联系管理员！</span>
			</div>
		</div>
	</body>
</html>
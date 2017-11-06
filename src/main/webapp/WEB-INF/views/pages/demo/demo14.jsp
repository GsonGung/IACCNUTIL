<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String resources = basePath + "resources/";
    String plugins = resources + "plugins/";
%>
<link rel="stylesheet" href="<%=plugins%>zyFile/control/css/zyUpload.css" type="text/css">
<script type="text/javascript" src="<%=plugins%>zyFile/core/zyFile.js"></script>
<script type="text/javascript" src="<%=plugins%>zyFile/control/js/zyUpload.js"></script>
<script type="text/javascript" src="<%=plugins%>zyFile/demo.js"></script>
<div id="zyupload" class="zyupload" >
</div>
<style>
    .upload_preview {
        /*position: absolute;*/
    }
</style>






<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String resources = basePath + "resources/";
    String plugins = resources + "plugins/";
%>

<link rel="stylesheet" href="<%=plugins%>zTree/css/metroStyle/metroStyle.css" type="text/css">
<script type="text/javascript" src="<%=plugins%>zTree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="<%=plugins%>zTree/js/jquery.ztree.core.js"></script>
<SCRIPT type="text/javascript">

    var setting = {
        view: {
            dblClickExpand: false,
            showLine: true,
            selectedMulti: false
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: ""
            }
        }
    };

    var zNodes = [
        {id: 1, pId: 0, name: "node1", open: true},
        {id: 101, pId: 1, name: "1"},
        {id: 102, pId: 1, name: "2"},

        {id: 2, pId: 0, name: "node2", open: false},
        {id: 201, pId: 2, name: "1"},
        {id: 206, pId: 2, name: "2"}
    ];

    $(document).ready(function () {
        var t = $("#tree");
        t = $.fn.zTree.init(t, setting, zNodes);
        var zTree = $.fn.zTree.getZTreeObj("tree");
        zTree.selectNode(zTree.getNodeByParam("id", 101));

    });
</SCRIPT>
<ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul>


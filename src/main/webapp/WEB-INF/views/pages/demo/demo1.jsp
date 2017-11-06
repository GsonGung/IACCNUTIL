<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String resources = basePath + "resources/";
    String plugins = resources + "plugins/";
%>
<link rel="stylesheet" href="<%=plugins%>datatables/dataTables.bootstrap.css">

<div class="box">
    <div class="box-header">
        <h3 class="box-title">前台分页、查询、排序</h3>
    </div>
    <!-- /.box-header -->
    <div class="box-body">
        <table id="example1" class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Start date</th>
                <th>Salary</th>
            </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>
    <!-- /.box-body -->
</div>

<div class="box">
    <div class="box-header">
        <h3 class="box-title">后台分页</h3>
    </div>
    <!-- /.box-header -->
    <div class="box-body">
        <table id="example2" class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Start date</th>
                <th>Salary</th>
            </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>
    <!-- /.box-body -->
</div>
<script src="<%=plugins%>datatables/jquery.dataTables.min.js"></script>
<script src="<%=plugins%>datatables/dataTables.bootstrap.min.js"></script>
<script>
    $(function () {

        $.extend(true, $.fn.dataTable.defaults, {
            language: {
                sProcessing: "处理中...",
                sLengthMenu: "　显示 _MENU_ 项结果",
                sZeroRecords: " ",
                sInfo: "　显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                sInfoEmpty: "　显示第 0 至 0 项结果，共 0 项",
                sInfoFiltered: "(由 _MAX_ 项结果过滤)",
                sInfoPostFix: "",
                sSearch: "筛选:",
                sUrl: "",
                sEmptyTable: " ",
                sLoadingRecords: "载入中...",
                sInfoThousands: ",",
                oPaginate: {
                    sFirst: "首页",
                    sPrevious: "上一页",
                    sNext: "下一页",
                    sLast: "末页"
                },
                oAria: {
                    sSortAscending: ": 以升序排列此列",
                    sSortDescending: ": 以降序排列此列"
                }
            }
        });

        $('#example1').DataTable({
            "ajax": _ROOT + "demo/listAll.do",
            "columns": [
                {"data": "name"},
                {"data": "position"},
                {"data": "office"},
                {"data": "ext"},
                {"data": "date"},
                {"data": "salary"}
            ]
        });
        $('#example2').DataTable({
//            "dom": '<"top">rt<"bottom"lip><"clear">',
//            "searching": false,
            scrollY: '300px',
            processing: true,
            serverSide: true,
            ajax: {
                url: _ROOT + 'demo/list.do',
                contentType: 'application/json; charset=utf-8',
                "data": function (data) {
                    planify(data);
                }
            },
            columns: [
                {data: 'name'},
                {data: 'position'},
                {data: 'office'},
                {data: 'ext'},
                {data: 'date'},
                {data: 'salary'}
            ]
        });
    });

    $('div.dataTables_filter label input[aria-controls="example2"]').attr('placeholder', '请输入名称');

    function planify(data) {
        for (var i = 0; i < data.columns.length; i++) {
            column = data.columns[i];
            column.searchRegex = column.search.regex;
            column.searchValue = column.search.value;
            delete(column.search);
        }
    }
</script>

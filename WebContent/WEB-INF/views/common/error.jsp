<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="refresh" content="500;url=#">
    <style type="text/css">
        body {
            background-image: url(<%=basePath%>static/pics/bg.jpg);
            background-position: 40% 0px;;
            font-family: "微软雅黑";
            font: normal 100% Helvetica, Arial, sans-serif 900;
        }

        a {
            text-decoration: none;
        }

        * {
            margin: 0px;
            padding: 0px;
        }

        a:link {
            color: #fff;
            text-decoration: none;
            text-decoration: none;
        }

        a:visited {
            color: #fff;
            text-decoration: none;
        }

        a:hover {
            color: #fff;
            text-decoration: none
        }

        .container {
            margin-left: auto;
            width: 100%;
            margin-right: auto;
            text-align: center;
            margin-top: 100px;
        }

        .container_1 img {
            margin-top: 5%;
            width: 250px;
            height: 120px;
        }

        .container_2 img {
            margin-top: -2%;
        }

        .container_3 img {
            width: 25%;
            height: 7.5%;
        }

        .container_3 {
            width: 28vw;
            margin: auto
        }

        .container_3_1 {
            color: #6bbaa3;
            font-size: 2vw;
            text-align: left;
        }

        .container_3_2 {
            color: #6bbaa3;
            font-size: 1vw;
            text-align: left;
        }

        .maincolumn {
            margin-left: auto;
            width: 100%;
            margin-right: auto;
            text-align: center;
            display: block;
            margin-top: 10px;
        }

        .maincolumn .maincolumn_bg {
            width: 28%;
            height: 50px;
            line-height: 50px;
            background-color: #6bbaa3;
            margin: auto;
        }

        .maincolumn .maincolumn_bg ul {
            list-style-type: none;
        }

        .maincolumn .maincolumn_bg ul li {
            float: left;
            width: 25%;
        }

        .maincolumn .maincolumn_bg ul li a {
            font-size: 18px;
        }

        .maincolumn .maincolumn_bg ul li a:hover {
            width: 100%;
            height: 50px;
            background-color: #47997d;
            display: block;
        }

        @media only screen and (max-width: 1000px) {
            .maincolumn {
                display: none;
                width: 0px;
            }
        }
    </style>
</head>
<body>

<div class="container">
    <div class="container_1"><img src="<%=basePath%>static/pics/404.png"></div>
    <div class="container_2"><img src="<%=basePath%>static/pics/3.22.gif"></div>
    <div class="container_3">
        <div class="container_3_1"><span>SORRY你要访问的页面弄丢了</span></div>
        <div class="container_3_2"><span>你可以通过以下方式重新访问......</span></div>
    </div>
</div>
<!--导航-->
<div class="maincolumn">
    <div class="maincolumn_bg">
        <ul>
            <li><a href="index.jsp">返回首页</a></li>
        </ul>
    </div>
    <div></div>
</div>
</body>
</html>

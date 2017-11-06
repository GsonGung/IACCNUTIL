<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String resources = basePath + "resources/";
    String plugins = resources + "plugins/";
%>

<link href="<%=plugins%>jcountdown/jcountdown.css" rel="stylesheet" type="text/css">
<script src="<%=plugins%>jcountdown/jquery.jcountdown.js"></script>
<style>
    div.countdown-container{
        background-color:#000;
        text-align:center;
        padding:20px;
    }
</style>
<div class="countdown-container">
<div id="DIV_TO_PLACE_COUNTDOWN"></div>
</div>
<script>
    jQuery(document).ready(function(){
        jQuery("#DIV_TO_PLACE_COUNTDOWN").jCountdown({
            timeText:"2020/01/01 00:00:00",
            timeZone:8,
            style:"flip",
            color:"black",
            width:0,
            textGroupSpace:15,
            textSpace:0,
            reflection:true,
            reflectionOpacity:10,
            reflectionBlur:0,
            dayTextNumber:4,
            displayDay:true,
            displayHour:true,
            displayMinute:true,
            displaySecond:true,
            displayLabel:true,
            onFinish:function(){
                alert("finish");
            }
        });
    });
</script>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
    response.sendRedirect(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/login/toLogin.do");
%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
   
    
    <title>login</title>
    


  </head>

  <body>
      <form action="<%=request.getContextPath()%>/chatLogin/login" method="post">
                       用户名:<input type="text" name="username"/>
         <input type="submit" value="登录"/>
      </form>
    
  </body>
</html>

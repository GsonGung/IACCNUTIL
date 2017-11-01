<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath =request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String commonPath = basePath + "static/common/";
%>
<!DOCTYPE html>
<html>
  <head>
    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>My JSP 'index.jsp' starting page</title>
	
  </head>
  
  <body>
   <script type="text/javascript" src="<%=commonPath%>jquery/jQuery-2.2.0.min.js"></script>
   <script type="text/javascript">
      $(function(){
    	  initSocket();//初始化websocket

      });
      function initSocket() {
    		debugger;
    		var webSocket = null;
    		
    	    window.onbeforeunload = function () {
    	        //离开页面时的其他操作
    	    };

    	    if (!window.WebSocket) {
    	        console("您的浏览器不支持websocket！");
    	        return false;
    	    }

    	    var target = 'ws://' + window.location.host + "/webchat/websocket/${sessionScope.username}";  
    			  
    			if ('WebSocket' in window) {  
    				webSocket = new WebSocket(target);  
    			} else if ('MozWebSocket' in window) {  
    				webSocket = new MozWebSocket(target);  
    			} else {  
    			    alert('WebSocket is not supported by this browser.');  
    			    return;  
    			}  
    	    
    	    
    	    // 收到服务端消息
    	    webSocket.onmessage = function (event) {
				//处理消息start
				if(event!=null){
         		//将json字符串转为对象
         			eval("var msg= '"+event.data+"';"); 
				}
				var content=$('#content').text();
				
				$('#content').text(content+"\r\n"+msg);
  	            //处理消息end
    	        // 关闭连接
    	        webSocket.onclose();
    	        console.log(msg);
    	    };

    	    // 异常
    	    webSocket.onerror = function (event) {
    	        console.log(event);
    	    };

    	    // 建立连接
    	    webSocket.onopen = function (event) {
    	        console.log(event);
    	       console.log(webSocket);
    	    };

    	    // 断线
    	    webSocket.onclose = function () {
    			
    	        console.log("websocket断开连接");
    	    };
    	}
     	function sendMessage(){
         	var message=$('#sendMessageTextArea').val();
         	$.ajax({
    			type: 'post',
    			url:'<%=basePath%>/activemq/topicSender',
    			dataType:'text', 
    			data:{"message":message},
    			success:function(data){
    				if(data=="suc"){
    					$("#status").html("<font color=green>发送成功</font>");
    					setTimeout(clear,1000);
    				}else{
    					$("#status").html("<font color=red>"+data+"</font>");
    					setTimeout(clear,5000);
    				}
    			},
    			error:function(data){
    				$("#status").html("<font color=red>ERROR:"+data["status"]+","+data["statusText"]+"</font>");
    				setTimeout(clear,5000);
    			}
    			
    		});
         	$('#sendMessageTextArea').val("");
     	}
     	function clear(){
    		$("#status").html("");
    	}
   </script>
   
   <p><span>你好,${sessionScope.username}</span></p>
    <table cellpadding="0" cellspacing="0"  border="1" width="500px" height="400px">
      <tr>
        <td>
          <textarea id="content" rows="10" cols=50" style="border:1px solid red;"></textarea>
         </td>
        <td id="userList" width="150px" align="center">
            
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <textarea id="sendMessageTextArea" rows="5" cols=50"></textarea>
          <button onclick="sendMessage()">发送</button>
        </td>
        
      </tr>
    </table>
 	<span id="status"></span>
   
  </body>
</html>

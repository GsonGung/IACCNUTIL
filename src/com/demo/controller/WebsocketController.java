package com.demo.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 功能说明：websocket处理类, 使用J2EE7的标准
 * @author Administrator
 * @create 2016-8-11 下午4:08:35
 * @version 1.0
 */
@ServerEndpoint("/websocket/{myWebsocket}")
public class WebsocketController
{
	private static Log logger = LogFactory.getLog(WebsocketController.class);
    
    public static Map<String, Session> clients = new ConcurrentHashMap<String, Session>();
    
    /**
     * 打开连接时触发
     * @param myWebsocket
     * @param session
     * @throws UnsupportedEncodingException 
     */
    @OnOpen
    public void onOpen(@PathParam("myWebsocket") String myWebsocket, Session session)
    {
        logger.info("Websocket Start Connecting:" + myWebsocket);
        System.out.println("进入：" + myWebsocket);
        clients.put(myWebsocket, session);
    }
    
    /**
     * 收到客户端消息时触发
     * @param myWebsocket
     * @param message
     * @return
     */
    @OnMessage
    public String onMessage(@PathParam("myWebsocket") String myWebsocket, String message)
    {
    	logger.info("myWebsocket:" + myWebsocket);
        logger.info("received message:" + message);
        return "Got your message (" + message + ").Thanks !";
    }
    
    /**
     * 异常时触发
     * @param myWebsocket
     * @param throwable
     */
    @OnError
    public void onError(@PathParam("myWebsocket") String myWebsocket, Throwable throwable)
    {
        logger.info("Websocket Connection Exception:" + myWebsocket);
        logger.info(throwable.getMessage(), throwable);
        clients.remove(myWebsocket);
    }
    
    /**
     * 关闭连接时触发
     * @param myWebsocket
     */
    @OnClose
    public void onClose(@PathParam("myWebsocket") String myWebsocket)
    {
        logger.info("Websocket Close Connection:" + myWebsocket);
        clients.remove(myWebsocket);
    }
    
    /**
     * 将数据传回客户端(主题)
     * 异步的方式
     * @param myWebsocket
     * @param message
     */
    public static void broadcast(String message)
    {
        logger.info("sending message return to client:" + message);
        for (Session session : clients.values())
        {
            session.getAsyncRemote().sendText(message);
        }
    }
    
    /**
     * 将数据传回客户端(队列)
     * 异步的方式
     * @param myWebsocket
     * @param message
     */
    public static void broadcast(String message, String sender, String receiver)
    {
        logger.info("sending message return to client:" + message);
        for (String username : clients.keySet())
        {
            if(username.equals(sender) || username.equals(receiver)) {
                Session session = clients.get(username);
                session.getAsyncRemote().sendText(message);
            }
        }
    }
    
}

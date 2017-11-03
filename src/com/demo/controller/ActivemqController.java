package com.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.demo.producer.QueueSender;
import com.demo.producer.TopicSender;

/**
 * 
 * @author liang
 * @description controller测试
 */
@Controller
@RequestMapping("/activemq")
public class ActivemqController {
	private static Log logger = LogFactory.getLog(ActivemqController.class);

	@Resource
	TopicSender topicSender;

	@Resource
	QueueSender queueSender;

	@Autowired
	CachingConnectionFactory connectionFactory;

	/**
	 * 发送消息到队列 Queue队列：仅有一个订阅者会收到消息，消息一旦被处理就不会存在队列中
	 * 
	 * @param message
	 * @return String
	 */
	@ResponseBody
	@RequestMapping("queueSender")
	public String queueSender(@RequestParam("message") String message, HttpSession session, String sender,
			String receiver) {

		logger.info("队列消息：" + message);
		
        String opt = "";

		try {
		    Connection connection = connectionFactory.createConnection();
	        connection.start();
	        Session session0 = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
	        Destination destination = session0.createQueue("websocket.queue");
	        MessageProducer producer = session0.createProducer(destination);

	        String username = session.getAttribute("username").toString();
	        String realname = session.getAttribute("realname").toString();
	        String imgUrl = session.getAttribute("imgUrl").toString();
	        JSONObject json = new JSONObject();
	        json.put("receiver", receiver);
	        json.put("username", username);
	        json.put("realname", realname);
	        json.put("imgUrl", imgUrl);
	        json.put("message", message);
	        json.put("sendTime", getCurTime());
	        String jsonMsg = json.toJSONString();

	        TextMessage msg = session0.createTextMessage(jsonMsg);

	        producer.send(msg);

	        WebsocketController.broadcast(jsonMsg, sender, receiver);
	        opt = "suc";
		}catch(Exception e) {
		    opt = e.getCause().toString();
		}
		

		/*
		 * try { queueSender.send("websocket.queue", jsonMsg); opt = "suc"; } catch
		 * (Exception e) { opt = e.getCause().toString(); }
		 */
		return opt;
	}

	/**
	 * 发送消息到主题 Topic主题：所有订阅该主题的用户都可以收到
	 * 
	 * @param message
	 * @return String
	 */
	@ResponseBody
	@RequestMapping("topicSender")
	public String topicSender(@RequestParam("message") String message, HttpSession session) {

		logger.info("主题消息：" + message);

		String opt = "";
		String username = session.getAttribute("username").toString();
		String realname = session.getAttribute("realname").toString();
		String imgUrl = session.getAttribute("imgUrl").toString();
		JSONObject json = new JSONObject();
		json.put("username", username);
		json.put("realname", realname);
		json.put("imgUrl", imgUrl);
		json.put("message", message);
		json.put("sendTime", getCurTime());
		String jsonMsg = json.toJSONString();

		try {
			topicSender.send("websocket.topic", jsonMsg);
			opt = "suc";
		} catch (Exception e) {
			opt = e.getCause().toString();
		}
		return opt;
	}

	public static String getCurTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
}

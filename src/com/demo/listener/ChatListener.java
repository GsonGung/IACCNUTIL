package com.demo.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.demo.controller.WebsocketController;

@Component("chatListener")
public class ChatListener implements MessageListener{
    
	private static Log logger = LogFactory.getLog(ChatListener.class);
	
	public void onMessage(Message message) {
		 logger.info("[ChatListener.onMessage]:begin onMessage......");
	        TextMessage textMessage = (TextMessage) message;
	        try {
	        	 String jsonStr = textMessage.getText();
	        	 WebsocketController.broadcast(jsonStr);
			} catch (JMSException e) {
				 logger.error("[ChatListener.onMessage]:receive message occured an exception",e);
			}
		 logger.info("[ClientPushListener.onMessage]:end onMessage.");
	}

}

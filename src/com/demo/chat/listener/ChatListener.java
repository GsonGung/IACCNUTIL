package com.demo.chat.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.demo.chat.controller.WebsocketController;

@Component("chatListener")
public class ChatListener implements MessageListener{
    
	protected static final Logger logger = LoggerFactory.getLogger(ChatListener.class);
	
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

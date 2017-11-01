package com.demo.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * 
 * @author liang
 * @description   Topic生产者发送消息到Topic
 * 
 */

@Component("topicSender")
public class TopicSender
{
    protected static final Logger logger = LoggerFactory.getLogger(TopicSender.class);
    
    @Autowired
    @Qualifier("jmsTopicTemplate")
    private JmsTemplate jmsTemplate;
    
    /**
     * 发送一条消息到指定的队列（目标）
     * @param queueName 队列名称
     * @param message 消息内容
     */
    public void send(String topicName, final String message)
    {
        logger.info("热点：{},消息：{}", topicName, message);
        
        jmsTemplate.send(topicName, new MessageCreator()
        {
            @Override
            public Message createMessage(Session session)
                throws JMSException
            {
                return session.createTextMessage(message);
            }
        });
    }
    
}

/**
 * 
 */
package com.demo.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.demo.listener.QueueListener;

/**
 * @author Administrator
 *
 */
@Component("queueSender")
public class QueueSender {
	
	private static Log logger = LogFactory.getLog(QueueSender.class);
    
    @Autowired
    @Qualifier("jmsQueueTemplate")
    private JmsTemplate jmsTemplate;
    
    /**
     * 发送一条消息到指定的队列（目标）
     * @param destination 队列/主题
     * @param message 消息内容
     */
    public void send(final String destination, final String message)
    {
        logger.info("队列：" + destination + ",消息：" + message);
        
        jmsTemplate.send(destination, new MessageCreator()
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

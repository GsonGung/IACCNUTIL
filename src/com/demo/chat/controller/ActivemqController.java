package com.demo.chat.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.chat.producer.TopicSender;

/**
 * 
 * @author liang
 * @description controller测试
 */
@Controller
@RequestMapping("/activemq")
public class ActivemqController
{
    
    @Resource
    TopicSender topicSender;
    
    /**
     * 发送消息到队列
     * Queue队列：仅有一个订阅者会收到消息，消息一旦被处理就不会存在队列中
     * @param message
     * @return String
     */
    @ResponseBody
    @RequestMapping("topicSender")
    public String queueSender(@RequestParam("message") String message, HttpSession session)
    {
        String opt = "";
        String username = session.getAttribute("username").toString();
        message = username + " " + getCurTime() + ":" + message;
        try
        {
            topicSender.send("websocket.topic", message);
            opt = "suc";
        }
        catch (Exception e)
        {
            opt = e.getCause().toString();
        }
        return opt;
    }
    
    public static String getCurTime()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}

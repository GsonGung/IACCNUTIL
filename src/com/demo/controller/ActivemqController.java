package com.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.demo.producer.TopicSender;

/**
 * 
 * @author liang
 * @description controller测试
 */
@Controller
@RequestMapping("/activemq")
public class ActivemqController
{
    private static Log logger = LogFactory.getLog(ActivemqController.class);
    
    @Resource
    TopicSender topicSender;
    
    /**
     * 发送消息到队列
     * Queue队列：仅有一个订阅者会收到消息，消息一旦被处理就不会存在队列中
     * @param message
     * @return String
     */
    @ResponseBody
    @RequestMapping("queueSender")
    public String queueSender(@RequestParam("message") String message, HttpSession session)
    {
        logger.info("队列消息：" + message);
        
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
        
        try
        {
            topicSender.send("websocket.topic", jsonMsg);
            opt = "suc";
        }
        catch (Exception e)
        {
            opt = e.getCause().toString();
        }
        return opt;
    }
    
    /**
     * 发送消息到主题
     * Topic主题：所有订阅该主题的用户都可以收到
     * @param message
     * @return String
     */
    @ResponseBody
    @RequestMapping("topicSender")
    public String topicSender(@RequestParam("message") String message, HttpSession session)
    {
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
        
        try
        {
            topicSender.send("websocket.topic", jsonMsg);
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

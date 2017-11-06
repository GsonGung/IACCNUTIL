package com.demo.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chatLogin")
public class ChatLoginController
{
	private static Log logger = LogFactory.getLog(ChatLoginController.class);
    
    @RequestMapping("/register")
    public String register()
    {
        logger.info("user register page......");
        return "/pages/chat/login";
    }
    
    @RequestMapping("/login")
    public String login(String username, HttpSession session) throws UnsupportedEncodingException
    {
        logger.info(username + "come in.....");
        logger.info("sessionId:" + session.getId());
        session.setAttribute("username", username);
        return "/pages/chat/chat";
    }
}

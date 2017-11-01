package com.demo.chat.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chatLogin")
public class ChatLoginController
{
    protected static final Logger logger = LoggerFactory.getLogger(ChatLoginController.class);
    
    @RequestMapping("/login")
    public String login(String username, HttpSession session)
    {
        logger.info(username + "come in.....");
        logger.info("sessionId:" + session.getId());
        session.setAttribute("username", username);
        return "/pages/chat/chat";
    }
}

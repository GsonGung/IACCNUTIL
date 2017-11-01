package com.demo.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.servlet.support.RequestContext.WEB_APPLICATION_CONTEXT_ATTRIBUTE;

/**
 * User: XC
 * Date: 2017/2/17 10:24
 */
public class Message {
    /**
     * 错误码
     */
    private String code;

    /**
     * 成功/失败消息
     */
    private String msg;

    /**
     * 数据传输
     */
    private Object data;

    /**
     * 构造器
     */

    public Message() {
        super();
    }

    public Message(String key) {
        this.code = getCode(key);
        this.msg = getMessage(key);
    }

    public Message(String key, Object data) {
        this.code = getCode(key);
        this.msg = getMessage(key);
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return "0".equals(this.code);
    }

    public void success() {
        this.code = getCode("system.success");
        this.msg = getMessage("system.success");
    }

    public void successWithData(Object data) {
        success();
        this.data = data;
    }

    /**
     * 获取国际化信息
     *
     * @param key
     * @return
     */
    public static String getLocaleMessage(String key) {
        HttpServletRequest request = SpringUtil.getRequest();
        if (request == null) {
            return key;
        }

        WebApplicationContext wac =
                WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
        if (request.getAttribute(WEB_APPLICATION_CONTEXT_ATTRIBUTE) == null) {
            request.setAttribute(WEB_APPLICATION_CONTEXT_ATTRIBUTE, wac);
        }

        RequestContext requestContext = new RequestContext(request);

        return requestContext.getMessage(key);
    }

    /**
     * 获取错误码
     *
     * @param key
     * @return
     */
    public static String getCode(String key) {
        return getLocaleMessage(key + ".code");
    }

    /**
     * 获取错误消息
     *
     * @param key
     * @return
     */
    public static String getMessage(String key) {
        return getLocaleMessage(key + ".msg");
    }

    /**
     * 返回默认失败消息
     *
     * @return
     */
    public static Message fail() {
        return new Message("system.failed");
    }

    /**
     * 返回指定失败消息
     *
     * @param key
     * @return
     */
    public static Message fail(String key) {
        return new Message(key);
    }

    /**
     * 返回指定失败消息
     *
     * @param key
     * @return
     */
    public void failWithKey(String key) {
        this.code = getCode(key);
        this.msg = getMessage(key);
    }

    /**
     * 内部转化JSON字符串
     *
     * @return
     */
    public String toJson() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Message [code=" + code + ", data=" + data + ", msg=" + msg + "]";
    }
}

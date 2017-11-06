/*
 * 文 件 名:  NoHandlerFoundException.java
 * 版    权:  AndyGong (SHANGHAI), INC.
 * 描    述:  <404页面处理>
 * 修 改 人:  Andy/Gongzhuang
 * 修改时间:  2017年7月20日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.exception;

import org.springframework.http.HttpHeaders;

import javax.servlet.ServletException;

/**
 * 
 * <404页面>
 * <功能详细描述>
 * 
 * @author  Andy/Gongzhuang
 * @version  [IACCN V100R001C01, 2017年7月20日 下午11:48:18]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class NoHandlerFoundException extends ServletException
{
    /**
     * 类序列化
     */
    private static final long serialVersionUID = 1L;
    
    private final String httpMethod;
    
    private final String requestURL;
    
    private final HttpHeaders headers;
    
    /**
     * 
     * <默认构造函数>
     */
    public NoHandlerFoundException(String httpMethod, String requestURL, HttpHeaders headers)
    {
        super("No handler found for " + httpMethod + " " + requestURL);
        this.httpMethod = httpMethod;
        this.requestURL = requestURL;
        this.headers = headers;
    }
    
    public String getHttpMethod()
    {
        return this.httpMethod;
    }
    
    public String getRequestURL()
    {
        return this.requestURL;
    }
    
    public HttpHeaders getHeaders()
    {
        return this.headers;
    }
}

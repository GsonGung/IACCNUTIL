package com.demo.web;

import com.demo.exception.NoHandlerFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * <用户请求转发>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月10日 下午1:19:43]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class CustomDispatcherServlet extends DispatcherServlet
{
    /**
     * 类序列号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 日志对象
     */
    private final static Log logger = LogFactory.getLog(CustomDispatcherServlet.class);
    
    private boolean throwExceptionIfNoHandlerFound;
    
    /**
     * {@inheritDoc}
     */
    public void setThrowExceptionIfNoHandlerFound(boolean throwExceptionIfNoHandlerFound)
    {
        this.throwExceptionIfNoHandlerFound = throwExceptionIfNoHandlerFound;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void noHandlerFound(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        if (this.throwExceptionIfNoHandlerFound)
        {
            ServletServerHttpRequest sshr = new ServletServerHttpRequest(request);
            
            logger.error("no resource found for " + sshr.getServletRequest().getRequestURI());
            
            throw new NoHandlerFoundException(sshr.getMethod().name(), sshr.getServletRequest().getRequestURI(),
                sshr.getHeaders());
        }
        else
        {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
}

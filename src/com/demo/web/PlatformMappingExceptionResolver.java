/*
 * 文 件 名:  PlatformMappingExceptionResolver.java
 * 版    权:  AndyGong (SHANGHAI), INC.
 * 描    述:  <公共的异常处理类>
 * 修 改 人:  Andy/Gongzhuang
 * 修改时间:  2017年7月20日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.demo.utils.CustomWebUtils;
import com.demo.utils.Message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * 
 * <公共的异常处理类>
 * <功能详细描述>
 * 
 * @author  Andy/Gongzhuang
 * @version  [IACCN V100R001C01, 2017年7月20日 下午11:44:11]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class PlatformMappingExceptionResolver extends SimpleMappingExceptionResolver
{
    private Properties exceptionMsgMappings;
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
        Exception ex)
    {
        //设置返回的请求编码格式
        response.setCharacterEncoding("utf-8");
        
        String viewName = super.determineViewName(ex, request);
        // vm方式返回
        if (viewName != null)
        {
            if (!CustomWebUtils.isAjax(request))
            {
                // 非异步方式返回
                Integer statusCode = determineStatusCode(request, viewName);
                if (statusCode != null)
                {
                    super.applyStatusCodeIfPossible(request, response, statusCode);
                }
                // 跳转到提示页面
                return super.getModelAndView(viewName, ex, request);
            }
            else
            {
                // 异步方式返回
                PrintWriter writer = null;
                try
                {
                    // 自定义异常信息已处理，返回正常响应
                    response.setStatus(HttpStatus.OK.value());
                    response.setContentType("text/json; charset=utf-8");
                    writer = response.getWriter();
                    writer.write(Message.fail(determineMsg(ex)).toJson());
                    
                    //将异常栈信息记录到日志中
                    logger.error(ex);
                }
                catch (Exception e)
                {
                    logger.error(e);
                }
                finally
                {
                    writer.flush();
                }
                // 不进行页面跳转
                return null;
            }
        }
        else
        {
            return null;
        }
    }
    
    private String determineMsg(Exception ex)
    {
        String name = ex.getClass().getCanonicalName();
        return exceptionMsgMappings.get(name).toString();
    }
    
    public void setExceptionMsgMappings(Properties exceptionMsgMappings)
    {
        this.exceptionMsgMappings = exceptionMsgMappings;
    }
}

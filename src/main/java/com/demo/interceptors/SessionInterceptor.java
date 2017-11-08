/*
 * 文 件 名:  SessionInterceptor.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  龚结铎/andrew
 * 修改时间:  2017年11月3日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.demo.pojo.User;

/**
 * <Session拦截器，使Session失效时返回登录页面>
 * <功能详细描述>
 * 
 * @author  龚结铎/andrew
 * @version  [YOUFULI V300R001C01, 2017年11月3日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class SessionInterceptor extends HandlerInterceptorAdapter
{
    private static Log log = LogFactory.getLog(SessionInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o)
        throws Exception
    {
        String path = hsr.getContextPath();
        String basePath = hsr.getScheme() + "://" + hsr.getServerName() + ":" + hsr.getServerPort() + path + "/";
        User user = (User)hsr.getSession().getAttribute("user");
        if (user == null)
        {
            log.info("用户未登录或登录超时，将返回登录页面:" + basePath + "login/toLogin");
            hsr1.sendRedirect(basePath + "login/toLogin");
            return false;
        }
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, ModelAndView mav)
        throws Exception
    {
    }
    
    @Override
    public void afterCompletion(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, Exception excptn)
        throws Exception
    {
    }
}

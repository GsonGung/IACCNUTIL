/*
 * 文 件 名:  DoFilterInterceptor.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月10日 下午1:26:38
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

import com.demo.utils.BaseResponseUtil;
import com.demo.utils.JsonUtil;
import com.demo.utils.PropertiesUtil;
import com.demo.utils.BaseRequestUtil;

/**
 * 
 * <自定义请求过滤拦截器；例如非法IP访问，此时都会进行拦截；此处功能只不过是servlet拦截器的封装，效果一样>
 * <（步骤一）系统优先进行跨越处理：AccessKeyInterceptor进行跨域请求的处理；否则Ajax请求访问不到项目>
 * <（步骤二）系统此处再进行自定义请求过滤拦截处理>
 * 
 * @author  Andy/Gongzhuang
 * @version  [IACCN V100R001C01, 2017年7月20日 下午11:56:08]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class DoFilterInterceptor extends HandlerInterceptorAdapter
{
    //过滤器日志对象
    private static Log log = LogFactory.getLog(DoFilterInterceptor.class);
    
    /**
     * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，
     * SpringMVC中的Interceptor拦截器是链式的，可以同时存在多个Interceptor，
     * 然后SpringMVC会根据声明的前后顺序一个接一个的执行，
     * 而且所有的Interceptor中的preHandle方法都会在Controller方法调用之前调用。
     * SpringMVC的这种Interceptor链式结构也是可以进行中断的，
     * 这种中断方式是令preHandle的返回值为false，当preHandle的返回值为false的时候整个请求就结束了。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception
    {
        String ipAddress = BaseRequestUtil.getIpAddress(request);
        if("0:0:0:0:0:0:0:1".equals(ipAddress)){
            ipAddress="localhost";
        }
        log.info("请求访问的IP为：" + ipAddress);
        log.info("获取配置文件中的Test值为：" + PropertiesUtil.getValueByKey("testKey"));
        log.info("获取返回码配置文件中的0000值为：" + PropertiesUtil.getReturnCodeValueByKey("0000"));
        //判断请求是否合法
        String strCode = "0000";
        if ("0000".equals(strCode))
        {
            //请求合法
            return true;
        }
        else
        {
            JsonUtil.writeJson(response, BaseResponseUtil.fail(strCode, PropertiesUtil.getReturnCodeValueByKey(strCode)+",非法IP为:"+ipAddress));
            //请求不合法，系统拦截
            return false;
        }
    }
    
    /**
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。
     * postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之 后， 也就是在Controller的方法调用之后执行，
     * 然后要在Interceptor之前调用的内容都写在调用invoke之前，要在Interceptor之后调用的内容都写在调用invoke方法之后。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView)
        throws Exception
    {
    }
    
    /**
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    {
        
    }
    
}

/*
 * 文 件 名:  JsonUtil.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月10日 下午4:30:05
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.utils;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;

/**
 * <JSON工具类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月10日 下午4:30:05]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class JsonUtil
{
    //JSON工具类日志对象
    private static Log log = LogFactory.getLog(JsonUtil.class);
    
    /**
     * 
     * <自定义Json返回结果>
     * <功能详细描述>
     * @param response 返回消息体
     * @param obj 返回对象
     * @see [类、类#方法、类#成员]
     */
    public static void writeJson(HttpServletResponse response, Object obj)
    {
        try
        {
            String json = JSON.toJSONString(obj);
            response.setHeader("Content-Type", "text/html;charset=utf-8");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);
            response.getWriter().write(json);
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
        }
    }
}

/*
 * 文 件 名:  PropertiesUtil.java
 * 版    权:  AndyGong (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  Andy/Gongzhuang
 * 修改时间:  2017年7月20日 下午11:35:41
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.utils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;

/**
 * 
 * <系统工具类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月10日 下午1:13:47]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class PropertiesUtil
{
    //系统配置文件
    private static Properties systemProp = new Properties();
    
    //返回错误码配置文件
    private static Properties retrunCodeProp = new Properties();
    
    //系统配置文件Map集合
    private static HashMap<String, String> systemMap = new HashMap<String, String>();
    
    //返回错误码配置文件Map集合
    private static HashMap<String, String> returnCodeMap = new HashMap<String, String>();
    
    //配置文件日志对象
    private static Log logger = LogFactory.getLog(PropertiesUtil.class);
    
    static
    {
        //步骤一：默认加载系统配置文件一
        loadSystemProperties();
        
        //步骤二：默认加载系统配置文件二
        loadRetrunCodeProperties();
//        
//        //启动线程进行读取，测试打印
//        Thread thread = new Thread(new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                while (true)
//                {
//                    String nowTime=null;
//                    try {
//                        Thread.sleep(5000);
//                        logger.info(PropertiesUtil.getValueByKey("testKey"));
//                        logger.info(PropertiesUtil.getReturnCodeValueByKey("0000"));
//                        loadSystemProperties();
//                        loadRetrunCodeProperties();
//                        nowTime =DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
//                        logger.info(nowTime+"加载配置文件成功");
//                    } catch (InterruptedException e) {
//                        logger.error(nowTime+"重新加载配置文件失败");
//                        logger.error("异常信息为:"+e.getStackTrace());
//                    }
//                }
//            }
//        });
//        //启动线程
//        thread.start();
    }
    
    /**
     * 
     * <系统配置文件默认加载方法>
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    private static void loadSystemProperties()
    {
        try
        {
            synchronized (systemMap)
            {
                systemProp.load(PropertiesUtil.class.getResourceAsStream("/system.properties"));
                Enumeration<Object> e = systemProp.keys();
                while (e.hasMoreElements())
                {
                    String key = e.nextElement().toString();
                    systemMap.put(key, systemProp.getProperty(key));
                }
                logger.info("加载system.properties文件成功");
            }
        }
        catch (IOException e)
        {
            logger.error("加载system.properties文件失败");
        }
    }
    
    /**
     * 
     * <系统返回码配置文件默认加载方法>
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    private static void loadRetrunCodeProperties()
    {
        try
        {
            synchronized (returnCodeMap)
            {
                retrunCodeProp.load(PropertiesUtil.class.getResourceAsStream("/returnCode.properties"));
                Enumeration<Object> e = retrunCodeProp.keys();
                while (e.hasMoreElements())
                {
                    String key = e.nextElement().toString();
                    returnCodeMap.put(key, retrunCodeProp.getProperty(key));
                }
                logger.info("加载returnCode.properties文件成功");
            }
        }
        catch (IOException e)
        {
            logger.error("加载returnCode.properties文件失败");
        }
    }
    
    /**
     * 
     * <根据配置文件中KEY获取对应值>
     * <功能详细描述>
     * @param key key值
     * @return value 实际对应值
     * @see [类、类#方法、类#成员]
     */
    public static String getValueByKey(String key)
    {
        Object o = systemMap.get(key);
        if (o != null)
        {
            return o.toString();
        }
        else
        {
            return null;
        }
    }
    
    /**
     * 
     * <根据配置文件中KEY获取返回码对应值>
     * <功能详细描述>
     * @param key key值
     * @return value 实际对应值
     * @see [类、类#方法、类#成员]
     */
    public static String getReturnCodeValueByKey(String key)
    {
        Object o = returnCodeMap.get(key);
        if (o != null)
        {
            return o.toString();
        }
        else
        {
            return null;
        }
    }
}

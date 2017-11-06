/*
 * 文 件 名:  Constant.java
 * 版    权:  AndyGong (SHANGHAI), INC.
 * 描    述:  <公共常量接口类>
 * 修 改 人:  Andy/Gongzhuang
 * 修改时间:  2017年7月20日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.common;

/**
 * 
 * <公共常量接口类>
 * <功能详细描述>
 * 
 * @author  Andy/Gongzhuang
 * @version  [IACCN V100R001C01, 2017年7月20日 下午11:52:20]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface Constant
{
    /**
     * 用户对象放到Session中的键名称
     */
    String USER_CONTEXT = "USER_CONTEXT";
    
    /** 退出标识：同账号踢出 */
    String OUT_FLAG_KICK = "kick";
    
    /** 退出标识：强制退出 */
    String OUT_FLAG_FORCE = "force";
    
    /** 退出标识：会话不合法 */
    String OUT_FLAG_NOTEXIST = "notExist";
    
    /** ajax字符编码设置 */
    String AJAX_CONTEXTTYPE = "text/html;charset=utf-8";
    
    /**
     * 
     * <定义操作日志常量>
     * <1:代表成功，0:代表失败>
     * 
     * @author  Andy/Gongzhuang
     * @version  [IACCN V100R001C01, 2017年7月20日 下午11:53:26]
     * @see  [相关类/方法]
     * @since  [产品/模块版本]
     */
    interface OperLog
    {
        byte SUCCESS = 1;
        
        byte FAIL = 0;
    }
}

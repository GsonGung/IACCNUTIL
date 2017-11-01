/*
 * 文 件 名:  EncryptPropertyPlaceholderConfigurer.java
 * 版    权:  AndyGong (SHANGHAI), INC.
 * 描    述:  <解析资源文件中加密字段类>
 * 修 改 人:  Andy/Gongzhuang
 * 修改时间:  2017年7月20日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.utils;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <解析资源文件中加密字段>
 * <功能详细描述>
 * 
 * @author  Andy/Gongzhuang
 * @version  [IACCN V100R001C01, 2017年7月20日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    
    private static Map<String, Boolean> encryptNames = new HashMap<String, Boolean>();

    static {
        
        encryptNames.put("jdbc.password", true);
    }

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        
        if (encryptNames.containsKey(propertyName)) {
            // 解密
            return propertyValue;
        } else {
            return super.convertProperty(propertyName, propertyValue);
        }
    }
}

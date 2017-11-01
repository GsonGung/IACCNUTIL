package com.demo.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * <自定义请求类>
 * <功能详细描述>
 * 
 * @author  Andy/Gongzhuang
 * @version  [IACCN V100R001C01, 2017年7月23日 下午2:16:50]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class CustomWebUtils {
    /**
     * 是否为ajax请求
     *
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request) {
        return request.getHeader("accept").indexOf("application/json") > -1
                || (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With")
                .indexOf("XMLHttpRequest") > -1);
    }
}

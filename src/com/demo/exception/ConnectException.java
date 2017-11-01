package com.demo.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 
 * <服务器请求异常>
 * <功能详细描述>
 * 
 * @author  Andy/Gongzhuang
 * @version  [IACCN V100R001C01, 2017年7月23日 下午2:35:46]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ConnectException extends AuthenticationException {

    /**
     * 类序列化
     */
    private static final long serialVersionUID = 1L;

    public ConnectException() {
    }

    public ConnectException(String message) {
        super(message);
    }

    public ConnectException(Throwable cause) {
        super(cause);
    }

    public ConnectException(String message, Throwable cause) {
        super(message, cause);
    }
}

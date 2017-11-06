package com.demo.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 
 * <企业被禁用异常>
 * <功能详细描述>
 * 
 * @author  Andy/Gongzhuang
 * @version  [IACCN V100R001C01, 2017年7月23日 下午2:37:28]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class DisabledCorpException extends AuthenticationException
{
    
    /** 注释内容 */
    private static final long serialVersionUID = 1L;
    
    /**
     * Creates a new DueAccountException.
     */
    public DisabledCorpException()
    {
        super();
    }
    
    /**
     * Constructs a new DueAccountException.
     *
     * @param message the reason for the exception
     */
    public DisabledCorpException(String message)
    {
        super(message);
    }
    
    /**
     * Constructs a new DueAccountException.
     *
     * @param cause the underlying Throwable that caused this exception to be thrown.
     */
    public DisabledCorpException(Throwable cause)
    {
        super(cause);
    }
    
    /**
     * Constructs a new DueAccountException.
     *
     * @param message the reason for the exception
     * @param cause   the underlying Throwable that caused this exception to be thrown.
     */
    public DisabledCorpException(String message, Throwable cause)
    {
        super(message, cause);
    }
}


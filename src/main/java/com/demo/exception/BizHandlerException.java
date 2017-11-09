/*
 * 文 件 名:  BizHandlerException.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  龚结铎/andrew
 * 修改时间:  2017年11月9日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  龚结铎/andrew
 * @version  [YOUFULI V300R001C01, 2017年11月9日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class BizHandlerException extends RuntimeException
{

    /**
     * 注释内容
     */
    private static final long serialVersionUID = -3525233940277622501L;

    
    
    public BizHandlerException()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public BizHandlerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public BizHandlerException(String message, Throwable cause)
    {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public BizHandlerException(String message)
    {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public BizHandlerException(Throwable cause)
    {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getMessage()
    {
        // TODO Auto-generated method stub
        return super.getMessage();
    }

    @Override
    public String getLocalizedMessage()
    {
        // TODO Auto-generated method stub
        return super.getLocalizedMessage();
    }

    @Override
    public synchronized Throwable getCause()
    {
        // TODO Auto-generated method stub
        return super.getCause();
    }

    @Override
    public synchronized Throwable initCause(Throwable cause)
    {
        // TODO Auto-generated method stub
        return super.initCause(cause);
    }

    @Override
    public String toString()
    {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public void printStackTrace()
    {
        // TODO Auto-generated method stub
        super.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s)
    {
        // TODO Auto-generated method stub
        super.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintWriter s)
    {
        // TODO Auto-generated method stub
        super.printStackTrace(s);
    }

    @Override
    public synchronized Throwable fillInStackTrace()
    {
        // TODO Auto-generated method stub
        return super.fillInStackTrace();
    }

    @Override
    public StackTraceElement[] getStackTrace()
    {
        // TODO Auto-generated method stub
        return super.getStackTrace();
    }

    @Override
    public void setStackTrace(StackTraceElement[] stackTrace)
    {
        // TODO Auto-generated method stub
        super.setStackTrace(stackTrace);
    }
    
    
}

/*
 * 文 件 名:  BaseResponse.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <返回结果封装类>
 * 修 改 人:   AndyGong
 * 修改时间:  2017年6月12日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <添加注释>
 */
package com.demo.utils;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 
 * <通用接口返回结构> 
 * <包含接口统一输出参数>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月10日 下午1:13:47]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class BaseResponseUtil extends HashMap<String, Object> implements Serializable
{
    
    /**
     * 给当前类赋序列化标识编号
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 
     * <默认构造函数>
     */
    public BaseResponseUtil(String rcode, String desc)
    {
        //返回码
        this.put("rcode", rcode);
        //返回码描述
        this.put("desc", desc);
        //返回数据实体
        this.put("data", "");
    }
    
    /**
     * 
     * <默认构造函数>
     * 给当前类赋编号
     */
    public BaseResponseUtil(String rcode, String desc, Object data)
    {
        //返回码
        this.put("rcode", rcode);
        //返回码描述
        this.put("desc", desc);
        //返回数据实体
        this.put("data", data);
    }
    
    /**
     * <返回接口调用成功> 
     * <返回无data具体数据的成功信息>
     * 
     * @return BaseResponse对象，包括rcode状态码、desc描述、data对象
     * @see [newInstance()方法，setRcode()方法，setDesc()方法]
     */
    public static BaseResponseUtil success()
    {
        return newInstance().setRcode("0000").setDesc("操作成功");
    }
    
    /**
     * <返回接口调用成功> 
     * <返回含有data具体数据的成功信息>
     * @param data对象
     *            具体信息
     * @return BaseResponse对象，包括rcode状态码、desc描述、data对象
     * @see [setData()方法]
     */
    public static BaseResponseUtil success(Object data)
    {
        return success().setData(data);
    }
    
    /**
     * 
     * <返回类成功方法>
     * <功能详细描述>
     * @return 返回结果类
     * @see [类、类#方法、类#成员]
     */
    public static BaseResponseUtil newInstance()
    {
        return new BaseResponseUtil("0000", "操作成功");
    }
    
    /**
     * 
     * <返回码赋值>
     * <功能详细描述>
     * @param rcode 返回码
     * @return 返回消息体
     * @see [类、类#方法、类#成员]
     */
    public BaseResponseUtil setRcode(String rcode)
    {
        this.put("rcode", rcode);
        return this;
    }
    
    /**
     * 
     * <返回码描述赋值>
     * <功能详细描述>
     * @param desc 返回码描述
     * @return 返回消息体
     * @see [类、类#方法、类#成员]
     */
    public BaseResponseUtil setDesc(String desc)
    {
        this.put("desc", desc);
        return this;
    }
    
    /**
     * <返回接口调用失败> 
     * <封装rcode状态码,desc描述参数，返回接口调用失败>
     * 
     * @param rcode 状态码
     * @param desc 描述
     * @return BaseResponse对象，包括rcode状态码、desc描述、data对象
     * @see [newInstance()方法，setRcode(),setDesc()方法]
     */
    public static BaseResponseUtil fail(String rcode, String desc)
    {
        return newInstance().setRcode(rcode).setDesc(desc);
    }
    
    /**
     * 
     * <返回数据实体赋值>
     * <功能详细描述>
     * @param data 数据对象
     * @return 返回消息体
     * @see [类、类#方法、类#成员]
     */
    public BaseResponseUtil setData(Object data)
    {
        super.put("data", data);
        return this;
    }
    
    /**
     * 
     * <将返回数据实体，以KEY_Value方式存储>
     * <功能详细描述>
     * @param key
     * @param value
     * @return
     * @see [类、类#方法、类#成员]
     */
    public BaseResponseUtil putData(String key, Object value)
    {
        this.put(key, value);
        return this;
    }
    
    /**
     * {@inheritDoc}
     */
    public BaseResponseUtil put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }
    
    /**
     * 
     * <获取返回码>
     * <功能详细描述>
     * @return 返回码
     * @see [类、类#方法、类#成员]
     */
    public String getRcode()
    {
        return String.valueOf(this.get("rcode"));
    }
    
    /**
     * 
     * <获取返回码描述>
     * <功能详细描述>
     * @return 返回码描述
     * @see [类、类#方法、类#成员]
     */
    public String getDesc()
    {
        return String.valueOf(this.get("desc"));
    }
}

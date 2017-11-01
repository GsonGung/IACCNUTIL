package com.demo.web;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * <日期转换>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月10日 下午1:21:26]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class DateConverter implements Converter<String, Date>
{
    public Date convert(String source)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try
        {
            return dateFormat.parse(source);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}

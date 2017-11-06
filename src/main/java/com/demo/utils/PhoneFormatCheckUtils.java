/*
 * 文 件 名:  PhoneFormatCheckUtils.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月16日 下午1:01:36
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * <手机号码格式合法性检验格式>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月16日 下午1:01:36]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class PhoneFormatCheckUtils
{
    
    /**
     * 
     * <大陆号码或香港号码均可 >
     * <功能详细描述>
     * @param phoneStr 手机号码
     * @return True或false
     * @see [类、类#方法、类#成员]
     */
    public static boolean isPhoneLegal(String phoneStr)
    {
        return isChinaPhoneLegal(phoneStr) || isHKPhoneLegal(phoneStr);
    }
    
    /**
     * 
     * <大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数>
     * <此方法中前三位格式有：>
     * <13+任意数>
     * <15+除4的任意数 >
     * <18+除1和4的任意数 >
     * <17+除9的任意数 >
     * <147开头>
     * @param phoneStr 手机号码
     * @return True或false
     * @see [类、类#方法、类#成员]
     */
    public static boolean isChinaPhoneLegal(String phoneStr)
    {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(phoneStr);
        return m.matches();
    }
    
    /**
     * 
     * <香港手机号码8位数，5|6|8|9开头+7位任意数 >
     * <功能详细描述>
     * @param phoneStr 手机号码
     * @return True或false
     * @see [类、类#方法、类#成员]
     */
    public static boolean isHKPhoneLegal(String phoneStr)
    {
        String regExp = "^(5|6|8|9)\\d{7}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(phoneStr);
        return m.matches();
    }
    
    /**
     * <一句话功能简述>
     * <功能详细描述>
     * @param args
     * @see [类、类#方法、类#成员]
     */
    public static void main(String[] args)
    {
        //检验合法性
        System.out.println(isPhoneLegal("15251855442"));
        System.out.println(isPhoneLegal("18391616370"));
        System.out.println(isPhoneLegal("156987"));
    }
    
}

/*
 * 文 件 名:  PhoneRechargeController.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月12日 下午3:19:17
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.service.PhoneRechargeService;

/**
 * <手机话费充值业务处理控制类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月12日 下午3:19:17]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
@RequestMapping("/iaccnpay/phoneRecharge")
public class PhoneRechargeController extends BaseController
{
    
    /**
     * 日志封装类
     */
    public static final Log logger = LogFactory.getLog(PhoneRechargeController.class);
    
    /**
     * 手机话费充值Service接口
     */
    @Autowired
    private PhoneRechargeService phoneRechargeService;
    
    /**
     * 
     * <查询手机运营商>
     * <功能详细描述>
     * @param phoneNumber 手机号码
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryPhoneOperator")
    public Object queryPhoneOperator(String phoneNumber)
    {
        Object obj = phoneRechargeService.queryMobileOperator(phoneNumber);
        return obj;
    }
    
    /**
     * 
     * <手机号码所属运营商话费充值套餐查询接口>
     * <功能详细描述>
     * @param phoneNumber 手机号码
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryPhoneRechargePackage")
    public Object queryPhoneRechargePackage(String phoneNumber)
    {
        Object obj = phoneRechargeService.queryPhoneRechargePackage(phoneNumber);
        return obj;
    }
    /**
     * 
     * <手机号码话费充值记录查询接口>
     * <功能详细描述>
     * @param phoneNumber 手机号码
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryPhoneRechargeHistory")
    public Object queryPhoneRechargeHistory(String phoneNumber,String startTime,String endTime,String softType)
    {
        Object obj = phoneRechargeService.queryPhoneRechargeHistory(phoneNumber,startTime,endTime,softType);
        return obj;
    }
    
    /**
     * 
     * <手机话费充值>
     * <功能详细描述>
     * @param phoneNumber 手机号码
     * @param totalAmount 总金额
     * @param amount 充值金额
     * @param serviceCharge 服务费
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("payPhoneCharge")
    public Object payPhoneCharge(String phoneNumber,String totalAmount,String amount,String serviceCharge){
        Object obj = phoneRechargeService.payPhoneCharge(phoneNumber,totalAmount,amount,serviceCharge);
        return obj;
    }
    
}

/*
 * 文 件 名:  PhoneRechargeService.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月16日 下午12:54:02
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.service;

/**
 * <手机话费充值业务处理Service接口>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月16日 下午12:54:02]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface PhoneRechargeService
{

    /**
     * 
     * <查询手机运营商>
     * <功能详细描述>
     * @param phoneNumber 手机号码
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    Object queryMobileOperator(String phoneNumber);

    /**
     * 
     * <根据手机号码查询手机号码运营商和充值套餐>
     * <功能详细描述>
     * @param phoneNumber 手机号码
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    Object queryPhoneRechargePackage(String phoneNumber);

    /**
     * 
     * <根据参数查询手机充值历史记录>
     * <参数：手机号码,开始时间,结束时间,排序类型(ASC:什序/DESC:降序)>
     * @param phoneNumber 手机号码
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param softType 排序类型
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    Object queryPhoneRechargeHistory(String phoneNumber, String startTime, String endTime, String softType);

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
    Object payPhoneCharge(String phoneNumber,String totalAmount, String amount, String serviceCharge);
    
}

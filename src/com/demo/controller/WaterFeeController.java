/*
 * 文 件 名:  WaterFeeController.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月12日 下午3:33:11
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.service.WaterFeeService;

/**
 * <水费缴费业务处理控制类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月12日 下午3:33:11]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
@RequestMapping("/iaccnpay/waterFee")
public class WaterFeeController extends BaseController
{
    /**
     * 日志封装类
     */
    public static final Log logger = LogFactory.getLog(WaterFeeController.class);
    
    /**
     * 水费业务处理Service接口
     */
    @Autowired
    private WaterFeeService waterFeeService;
    
    /**
     * 
     * <水费缴费支持单位查询接口>
     * <功能详细描述>
     * @param currentCity 当前城市名称；例如：上海
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @ResponseBody
    @RequestMapping("/toSeachCompanyListByCurrentCity")
    public Object seachCompanyListByCurrentCity(String currentCity)
    {
       return waterFeeService.seachCompanyListByCurrentCity(currentCity);
    }
    
    /**
     * 
     * <水费缴费接口>
     * <功能详细描述>
     * @param customNo 当前登录用户账号
     * @param companyName 缴费单位名称
     * @param accountNumber 户号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @ResponseBody
    @RequestMapping("/toTradeWaterFee")
    public Object tradeWaterFee(String customNo, String companyName, String accountNumber)
    {
        return waterFeeService.tradeWaterFee(customNo,companyName,accountNumber);
    }
    
    /**
     * 
     * <根据当前登录用户账号/开始时间/结束时间查询历史水费缴费信息>
     * <功能详细描述>
     * @param customNo 当前登录用户账号
     * @param StartTime 开始时间
     * @param endTime 结束时间
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @ResponseBody
    @RequestMapping("/searchHistoryList")
    public Object searchHistoryList(String customNo, String StartTime, String endTime)
    {
        return waterFeeService.searchHistoryList(customNo,StartTime,endTime);
    }
    
    /**
     * 
     * <当前用户新增户号信息>
     * <功能详细描述>
     * @param customNo 当前登录用户账号
     * @param companyName 缴费单位名称
     * @param companyNo 缴费单位编码
     * @param accountNumber 户号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/addAccountInfo")
    public Object addAccountInfo(String customNo,String companyName,String companyNo,String accountNumber){
        return waterFeeService.addAccountInfo(customNo,companyName,companyNo,accountNumber);
    }
    
    /**
     * 
     * <当前用户修改户号信息>
     * <功能详细描述>
     * @param customNo 当前登录用户账号
     * @param companyName 缴费单位名称
     * @param companyNo 缴费单位编码
     * @param accountNumber 户号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/editAccountInfo")
    public Object editAccountInfo(String customNo,String companyName,String companyNo,String accountNumber){
        return waterFeeService.editAccountInfo(customNo,companyName,companyNo,accountNumber);
    }
    
    /**
     * 
     * <当前用户删除户号信息>
     * <功能详细描述>
     * @param customNo 当前登录用户账号
     * @param companyName 缴费单位名称
     * @param companyNo 缴费单位编码
     * @param accountNumber 户号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/deleteAccountInfo")
    public Object deleteAccountInfo(String customNo,String companyName,String companyNo,String accountNumber){
        return waterFeeService.deleteAccountInfo(customNo,companyName,companyNo,accountNumber);
    }
    
    /**
     * 
     * <当前用户查询绑定的户号列表信息>
     * <功能详细描述>
     * @param customNo 当前登录用户账号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/queryAccountInfoList")
    public Object queryAccountInfoList(String customNo){
        return waterFeeService.queryAccountInfoList(customNo);
    }
    
    /**
     * 
     * <当前用户查询对应户号详情信息>
     * <功能详细描述>
     * @param customNo 当前登录用户账号
     * @param companyName 缴费单位名称
     * @param companyNo 缴费单位编码
     * @param accountNumber 户号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/queryAccountInfoByAccountNumber")
    public Object queryAccountInfoByAccountNumber(String customNo,String companyName,String companyNo,String accountNumber){
        return waterFeeService.queryAccountInfoByAccountNumber(customNo,companyName,companyNo,accountNumber);
    }
    
    /**
     * 
     * <查询水费欠费账单接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @param companyName 缴费单位名称
     * @param companyNo 缴费单位编码
     * @param accountNumber 户号
     * @param startTime 时间月份
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/queryArrearsBill")
    public Object queryArrearsBill(String customNo,String companyName,String companyNo,String accountNumber,String startTime){
        return waterFeeService.queryArrearsBill(customNo,companyName,companyNo,accountNumber,startTime);
    }
}

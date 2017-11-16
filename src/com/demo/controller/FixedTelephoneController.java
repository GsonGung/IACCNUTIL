/*
 * 文 件 名:  FixedTelephoneController.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月12日 下午3:36:27
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

import com.demo.service.FixedTelephoneService;

/**
 * <固定电话缴费业务处理控制类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月12日 下午3:36:27]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
@RequestMapping("/iaccnpay/fixedTelephone")
public class FixedTelephoneController extends BaseController
{
    /**
     * 日志封装类
     */
    public static final Log logger = LogFactory.getLog(FixedTelephoneController.class);
    
    /**
     * 固定电话业务处理Service接口
     */
    @Autowired
    private FixedTelephoneService fixedTelephoneService;
    
    /**
     * 
     * <固话缴费支持套餐查询接口>
     * <功能详细描述>
     * @param currentCity 当前城市名称；例如：上海
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @ResponseBody
    @RequestMapping("/queryCityPackageList")
    public Object queryCityPackageList(String customNo)
    {
        return fixedTelephoneService.queryCityPackageList(customNo);
    }
    
    /**
     * 
     * <固话支付>
     * <功能详细描述>
     * @param customNo 当前登录用户账号
     * @param orderId 外部订单号
     * @param itemId 商品编号
     * @param amountTotal 扣款总金额
     * @param amount 充值金额
     * @param ServiceAmount 服务费金额
     * @param account 充值账号
     * @param callback 回调URL
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @ResponseBody
    @RequestMapping("/payFixedTelePhonePrice")
    public Object payFixedTelePhonePrice(String customNo,String orderId, String itemId, String amountTotal,String amount,String ServiceAmount,String account,String callback)
    {
        return fixedTelephoneService.payFixedTelePhonePrice(customNo,orderId, itemId, amount,account,callback);
    }
    
    /**
     * 
     * <根据当前登录用户账号/开始时间/结束时间查询历史固话缴费信息>
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
        return fixedTelephoneService.searchHistoryList(customNo, StartTime, endTime);
    }
}

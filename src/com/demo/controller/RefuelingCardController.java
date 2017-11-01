/*
 * 文 件 名:  RefuelingCardController.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月12日 下午3:27:44
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

import com.demo.service.RefuelingCardService;

/**
 * <加油卡业务处理控制类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月12日 下午3:27:44]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
@RequestMapping("/iaccnpay/refuelingCard")
public class RefuelingCardController extends BaseController
{
    /**
     * 日志封装类
     */
    public static final Log logger = LogFactory.getLog(RefuelingCardController.class);
    
    /**
     * 加油卡业务处理Service接口
     */
    @Autowired
    private RefuelingCardService refuelingCardService;
    
    /**
     * 
     * <查询加油卡充值的套餐>
     * <功能详细描述>
     * @param customNo 当前登录用户编号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryRefuelingCardPackage")
    public Object queryRefuelingCardPackage(String customNo){
        return refuelingCardService.queryRefuelingCardPackage(customNo);
    }
    
    /**
     * 
     * <查询加油卡历史充值记录接口>
     * <功能详细描述>
     * @param customNo 当前登录用户编号
     * @param cardType 加油卡类型（0:中石化;1:中石油）
     * @param cardNo 加油卡卡号
     * @param startTime 开始时间(例如：2017-10-10)
     * @param endTime 结束时间(例如：2017-10-15)
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryRefuelingCardHistoryOrder")
    public Object queryRefuelingCardHistoryOrder(String customNo,String cardType,String cardNo,String startTime,String endTime){
        return refuelingCardService.queryRefuelingCardHistoryOrder(customNo,cardType,cardNo,startTime,endTime);
    }
   
    /**
     * 
     * <加油卡充值支付接口>
     * <功能详细描述>
     * @param customNo 当前登录用户编号
     * @param cardType 加油卡类型（0:中石化;1:中石油）
     * @param cardNo 加油卡卡号
     * @param packageId 加油卡套餐编号
     * @param amountTotal 总金额
     * @param amount 充值金额
     * @param discount 优惠折扣率
     * @param disAmount 优惠后金额
     * @param serviceAmount 服务费
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("payRefuelingCardOrder")
    public Object payRefuelingCardOrder(String customNo,String cardType,String cardNo,String packageId,String amountTotal,String amount,String discount,String disAmount, String serviceAmount){
        return refuelingCardService.payRefuelingCardOrder(customNo,cardType,cardNo,packageId,amountTotal,amount,discount,disAmount,serviceAmount);
    }
}

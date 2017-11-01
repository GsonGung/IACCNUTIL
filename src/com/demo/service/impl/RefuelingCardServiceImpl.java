/*
 * 文 件 名:  RefuelingCardServiceImpl.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月19日 下午1:51:14
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.demo.service.RefuelingCardService;

/**
 * <加油卡业务处理Service接口实现类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月19日 下午1:51:14]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service("refuelingCardService")
public class RefuelingCardServiceImpl implements RefuelingCardService
{
    /**
     * 日志封装类
     */
    public static final Log logger = LogFactory.getLog(RefuelingCardServiceImpl.class);
    
    @Override
    public Object queryRefuelingCardPackage(String customNo)
    {
        logger.info("查询加油卡充值的套餐");
        return null;
    }

    @Override
    public Object queryRefuelingCardHistoryOrder(String customNo, String cardType, String cardNo, String startTime,
        String endTime)
    {
        logger.info("查询加油卡历史充值记录接口");
        return null;
    }

    @Override
    public Object payRefuelingCardOrder(String customNo, String cardType, String cardNo, String packageId,
        String amountTotal, String amount, String discount, String disAmount, String serviceAmount)
    {
        logger.info("加油卡充值支付接口");
        return null;
    }
    
}

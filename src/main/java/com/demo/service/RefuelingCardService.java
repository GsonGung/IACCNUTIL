/*
 * 文 件 名:  RefuelingCardService.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月19日 下午1:50:25
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.service;

/**
 * <加油卡业务处理Service接口>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月19日 下午1:50:25]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface RefuelingCardService
{

    Object queryRefuelingCardPackage(String customNo);
    
    Object queryRefuelingCardHistoryOrder(String customNo, String cardType, String cardNo, String startTime,
        String endTime);

    Object payRefuelingCardOrder(String customNo, String cardType, String cardNo, String packageId, String amountTotal,
        String amount, String discount, String disAmount, String serviceAmount);
}

/*
 * 文 件 名:  FixedTelephoneService.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月20日 下午4:03:13
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.service;

/**
 * <固定电话缴费业务处理Service接口>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月20日 下午4:03:13]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface FixedTelephoneService
{

    Object queryCityPackageList(String customNo);

    Object payFixedTelePhonePrice(String customNo, String orderId, String itemId, String amount, String account,
        String callback);

    Object searchHistoryList(String customNo, String startTime, String endTime);
    
}

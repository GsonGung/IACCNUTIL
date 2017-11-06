/*
 * 文 件 名:  GasFeeService.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月20日 下午3:26:31
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.service;

/**
 * <燃气费用业务处理Service接口>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月20日 下午3:26:31]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface GasFeeService
{

    Object seachCompanyListByCurrentCity(String currentCity);

    Object tradeGasFee(String customNo, String companyName, String accountNumber, String comtributionPeriod);

    Object searchHistoryList(String customNo, String startTime, String endTime);

    Object addAccountInfo(String customNo, String companyName, String companyNo, String accountNumber);

    Object editAccountInfo(String customNo, String companyName, String companyNo, String accountNumber);

    Object deleteAccountInfo(String customNo, String companyName, String companyNo, String accountNumber);

    Object queryAccountInfoList(String customNo);

    Object queryAccountInfoByAccountNumber(String customNo, String companyName, String companyNo, String accountNumber);

    Object queryArrearsBill(String customNo, String companyName, String companyNo, String accountNumber,
        String startTime);
    
}

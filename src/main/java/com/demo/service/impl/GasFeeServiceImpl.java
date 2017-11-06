/*
 * 文 件 名:  GasFeeServiceImpl.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月20日 下午3:27:02
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.service.impl;

import org.springframework.stereotype.Service;

import com.demo.service.GasFeeService;

/**
 * <燃气业务功能处理Service接口实现类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月20日 下午3:27:02]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service("gasFeeServiceImpl")
public class GasFeeServiceImpl implements GasFeeService
{

    @Override
    public Object seachCompanyListByCurrentCity(String currentCity)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object tradeGasFee(String customNo, String companyName, String accountNumber, String comtributionPeriod)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object searchHistoryList(String customNo, String startTime, String endTime)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object addAccountInfo(String customNo, String companyName, String companyNo, String accountNumber)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object editAccountInfo(String customNo, String companyName, String companyNo, String accountNumber)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object deleteAccountInfo(String customNo, String companyName, String companyNo, String accountNumber)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object queryAccountInfoList(String customNo)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object queryAccountInfoByAccountNumber(String customNo, String companyName, String companyNo,
        String accountNumber)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object queryArrearsBill(String customNo, String companyName, String companyNo, String accountNumber,
        String startTime)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
}

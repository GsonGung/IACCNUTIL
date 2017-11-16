/*
 * 文 件 名:  ElectricityServiceImpl.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月19日 下午1:20:28
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.demo.service.ElectricityService;

/**
 * <电费缴费业务处理Service接口实现类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月19日 下午1:20:28]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service("electricityServiceImpl")
public class ElectricityServiceImpl implements ElectricityService
{
    /**
     * 日志封装类
     */
    public static final Log logger = LogFactory.getLog(ElectricityServiceImpl.class);
    
    @Override
    public Object seachCompanyListByCurrentCity(String currentCity)
    {
        logger.info("电费缴费支持单位查询接口");
        return null;
    }
    
    @Override
    public Object tradeElectricity(String customNo, String companyName, String accountNumber)
    {
        logger.info("电费缴费接口");
        return null;
    }
    
    @Override
    public Object searchHistoryList(String customNo, String startTime, String endTime)
    {
        logger.info("根据当前登录用户账号/开始时间/结束时间查询历史电费缴费信息");
        return null;
    }
    
    @Override
    public Object addAccountInfo(String customNo, String companyName, String companyNo, String accountNumber)
    {
        logger.info("当前用户新增户号信息");
        return null;
    }
    
    @Override
    public Object editAccountInfo(String customNo, String companyName, String companyNo, String accountNumber)
    {
        logger.info("当前用户修改户号信息");
        return null;
    }
    
    @Override
    public Object deleteAccountInfo(String customNo, String companyName, String companyNo, String accountNumber)
    {
        logger.info("当前用户删除户号信息");
        return null;
    }
    
    @Override
    public Object queryAccountInfoList(String customNo)
    {
        logger.info("当前用户查询绑定的户号列表信息");
        return null;
    }
    
    @Override
    public Object queryAccountInfoByAccountNumber(String customNo, String companyName, String companyNo,
        String accountNumber)
    {
        logger.info("当前用户查询对应户号详情信息");
        return null;
    }

    @Override
    public Object queryArrearsBill(String customNo, String companyName, String companyNo, String accountNumber,
        String startTime)
    {
        logger.info("查询电费欠费账单接口");
        return null;
    }
    
}

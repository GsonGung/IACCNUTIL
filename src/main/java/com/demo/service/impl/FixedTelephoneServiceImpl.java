/*
 * 文 件 名:  FixedTelephoneServiceImpl.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月20日 下午4:03:43
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.service.impl;

import org.springframework.stereotype.Service;

import com.demo.service.FixedTelephoneService;

/**
 * <固定电话缴费业务处理Service接口实现类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月20日 下午4:03:43]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service("fixedTelephoneServiceImpl")
public class FixedTelephoneServiceImpl implements FixedTelephoneService
{

    @Override
    public Object queryCityPackageList(String customNo)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object payFixedTelePhonePrice(String customNo, String orderId, String itemId, String amount, String account,
        String callback)
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
    
}

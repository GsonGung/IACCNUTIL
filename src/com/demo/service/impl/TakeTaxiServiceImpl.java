/*
 * 文 件 名:  TakeTaxiServiceImpl.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月20日 上午10:00:29
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.service.impl;

import org.springframework.stereotype.Service;

import com.demo.service.TakeTaxiService;

/**
 * <打车业务处理Service接口实现类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月20日 上午10:00:29]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service("takeTaxiServiceImpl")
public class TakeTaxiServiceImpl implements TakeTaxiService
{

    @Override
    public Object queryCityList(String customNo)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object queryCitysPriceInfo(String customNo, String formCityName, String formCityId, String ruleType)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object queryPriceCouponInfo(String customNo, String flat, String flng, String tlat, String tlng,
        String mapType, String requireLevel, String ruleType, String cityName, String cityId, String orderType,
        String departureTime, String pricingMode)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object queryPriceCouponInfo(String customNo, String flat, String flng, String tlat, String tlng,
        String mapType, String ruleType, String cityName, String cityId, String departureTime)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object queryAddress(String customNo, String cityName, String inputName)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object queryCityIdByPoi(String customNo, String lat, String lng)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object queryMinduration(String customNo, String flat, String flng, String ruleType, String requireLevel,
        String passengerPhone)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object createCallCarRequest(String customNo, String ruleType, String orderType, String passengerPhone,
        String city, String flat, String flng, String departurePlaceName, String departurePlaceAddress, String tlat,
        String tlng, String destinationName, String destinationAddress, String currentLat, String currentLng,
        String departureTime, String requireLevel, String appTime, String mapType, String comboId, String smsPolicy,
        String extraInfo, String callbackInfo, String dynamicMD5, String pricingMode, String enableLineup,
        String enableReassign)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object queryOrderDetail(String customNo, String orderId)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object queryHistoryOrderInfoList(String customNo, String startTime, String endTime, String pageNum,
        String isAll, String phone)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object canCelOrderInfo(String customNo, String orderId, String force)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object orderStatusBackUrl(String customNo, String url)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object queryReasonList(String customNo, String orderId)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object queryReasonList(String customNo, String orderId, String reasonType, String content)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object subDriverRatingsInfo(String customNo, String orderId, String level, String comment)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
}

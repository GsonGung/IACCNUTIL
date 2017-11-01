/*
 * 文 件 名:  TakeTaxiService.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月20日 上午9:59:49
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.service;

/**
 * <打车业务处理Service接口>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月20日 上午9:59:49]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface TakeTaxiService
{

    Object queryCityList(String customNo);

    
    Object queryCitysPriceInfo(String customNo, String formCityName, String formCityId, String ruleType);


    Object queryPriceCouponInfo(String customNo, String flat, String flng, String tlat, String tlng, String mapType,
        String requireLevel, String ruleType, String cityName, String cityId, String orderType, String departureTime,
        String pricingMode);


    Object queryPriceCouponInfo(String customNo, String flat, String flng, String tlat, String tlng, String mapType,
        String ruleType, String cityName, String cityId, String departureTime);


    Object queryAddress(String customNo, String cityName, String inputName);


    Object queryCityIdByPoi(String customNo, String lat, String lng);


    Object queryMinduration(String customNo, String flat, String flng, String ruleType, String requireLevel,
        String passengerPhone);


    Object createCallCarRequest(String customNo, String ruleType, String orderType, String passengerPhone, String city,
        String flat, String flng, String departurePlaceName, String departurePlaceAddress, String tlat, String tlng,
        String destinationName, String destinationAddress, String currentLat, String currentLng, String departureTime,
        String requireLevel, String appTime, String mapType, String comboId, String smsPolicy, String extraInfo,
        String callbackInfo, String dynamicMD5, String pricingMode, String enableLineup, String enableReassign);


    Object queryOrderDetail(String customNo, String orderId);


    Object queryHistoryOrderInfoList(String customNo, String startTime, String endTime, String pageNum, String isAll,
        String phone);


    Object canCelOrderInfo(String customNo, String orderId, String force);


    Object orderStatusBackUrl(String customNo, String url);


    Object queryReasonList(String customNo, String orderId);


    Object queryReasonList(String customNo, String orderId, String reasonType, String content);


    Object subDriverRatingsInfo(String customNo, String orderId, String level, String comment);

    
}

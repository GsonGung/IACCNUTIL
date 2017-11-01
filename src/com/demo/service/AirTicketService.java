/*
 * 文 件 名:  AirTicketService.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月18日 下午2:31:19
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.service;

/**
 * <飞机票业务处理Service接口>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月18日 下午2:31:19]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface AirTicketService
{
    
    Object queryAirStationList(String customNo);
    
    Object searchAirTicketLineList(String customNo, String fromCity, String dateTime, String toCity);
    
    Object payAirTicketOrder(String customNo, String externalOrderNo, String contactName, String contactTel,
        String departureDate, String departureStation, String destnation, String flightNo, String companyCode,
        String insuranceNo, String totalAmount, String airTiketAmount, String serviceFeeAmount, String fuelChargeAmount,
        String machineAmount, String insuranceAmount, String otherChargesAmount);
    
    Object refundAirTicketOrder(String customNo, String externalOrderNo, String masterOrderNo, String subOrderNo);
    
    Object searchAirTicketOrderList(String customNo, String externalOrderNo, String masterOrderNo, String startTime,
        String endTime, String sort, String orderStatus);
    
    Object searchAirTicketOrderDetail(String customNo);
    
    Object addAirTicketUserInfo(String customNo, String passagerType, String userName, String userIdType,
        String userIdNo, String userPhone, String nationality, String userLinkAddress);
    
    Object editAirTicketUserInfo(String customNo, String userNo, String passagerType, String userName,
        String userIdType, String userIdNo, String userPhone, String nationality, String userLinkAddress);
    
    Object deleteAirTicketUserInfo(String customNo, String userNos);
    
    Object queryAirTicketUserInfoList(String customNo);
    
    Object queryAirTicketServiceFee(String customNo);
    
    Object queryAirTicketInsuranceList(String customNo);
    
}

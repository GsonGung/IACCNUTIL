/*
 * 文 件 名:  AirTicketServiceImpl.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月18日 下午6:05:10
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.service.impl;

import org.springframework.stereotype.Service;

import com.demo.service.AirTicketService;

/**
 * <飞机票业务处理Service接口实现类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月18日 下午6:05:10]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service("airTicketServiceImpl")
public class AirTicketServiceImpl implements AirTicketService
{
    
    @Override
    public Object queryAirStationList(String customNo)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Object searchAirTicketLineList(String customNo, String fromCity, String dateTime, String toCity)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Object payAirTicketOrder(String customNo, String externalOrderNo, String contactName, String contactTel,
        String departureDate, String departureStation, String destnation, String flightNo, String companyCode,
        String insuranceNo, String totalAmount, String airTiketAmount, String serviceFeeAmount, String fuelChargeAmount,
        String machineAmount, String insuranceAmount, String otherChargesAmount)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Object refundAirTicketOrder(String customNo, String externalOrderNo, String masterOrderNo, String subOrderNo)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Object searchAirTicketOrderList(String customNo, String externalOrderNo, String masterOrderNo,
        String startTime, String endTime, String sort, String orderStatus)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Object searchAirTicketOrderDetail(String customNo)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Object addAirTicketUserInfo(String customNo, String passagerType, String userName, String userIdType,
        String userIdNo, String userPhone, String nationality, String userLinkAddress)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Object editAirTicketUserInfo(String customNo, String userNo, String passagerType, String userName,
        String userIdType, String userIdNo, String userPhone, String nationality, String userLinkAddress)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Object deleteAirTicketUserInfo(String customNo, String userNos)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Object queryAirTicketUserInfoList(String customNo)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Object queryAirTicketServiceFee(String customNo)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Object queryAirTicketInsuranceList(String customNo)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
}

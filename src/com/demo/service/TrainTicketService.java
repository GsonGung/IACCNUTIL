/*
 * 文 件 名:  TrainTicketService.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月19日 上午10:19:11
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.service;

/**
 * <火车票业务处理Service接口>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月19日 上午10:19:11]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface TrainTicketService
{

    Object queryTrainStationList(String customNo);

    Object searchTrainTicketTimesList(String customNo, String fromCity, String dateTime, String toCity);

    Object reserveTrainTicket(String customNo, String externalOrderNo, String contactName, String contactTel,
        String departureDate, String departureStation, String destnation, String trainTimesNo, String startTime,
        String insuranceNo, String passengerInfo, String totalAmount, String trainTiketAmount, String serviceFeeAmount,
        String insuranceAmount, String otherChargesAmount);

    Object payTrainTicketOrder(String customNo, String externalOrderNo, String contactName, String contactTel,
        String departureDate, String departureStation, String destnation, String trainTimesNo, String startTime,
        String insuranceNo, String passengerInfo, String totalAmount, String trainTiketAmount, String serviceFeeAmount,
        String insuranceAmount, String otherChargesAmount);

    Object refundTrainTicketOrder(String customNo, String externalOrderNo, String masterOrderNo, String subOrderNo);

    Object changesTrainTicketOrder(String customNo, String changesBeforeExternalOrderNo,
        String changesBeforeMasterOrderNo, String changesBeforeSubOrderNo, String externalOrderNo, String contactName,
        String contactTel, String departureDate, String departureStation, String destnation, String trainTimesNo,
        String startTime, String insuranceNo, String passengerInfo, String totalAmount, String trainTiketAmount,
        String serviceFeeAmount, String insuranceAmount, String otherChargesAmount);

    Object searchTrainTicketOrderList(String customNo, String externalOrderNo, String masterOrderNo, String startTime,
        String endTime, String sortType, String orderStatus);

    Object searchTrainTicketOrderDetail(String customNo, String externalOrderNo, String masterOrderNo,
        String subOrderNo);

    Object addTrainTicketUserInfo(String customNo, String passagerType, String userName, String userIdType,
        String userIdNo, String userPhone, String userBirthday, String nationality, String userLinkAddress);

    Object editTrainTicketUserInfo(String customNo, String userNo, String passagerType, String userName,
        String userIdType, String userIdNo, String userPhone, String userBirthday, String nationality,
        String userLinkAddress);

    Object deleteTrainTicketUserInfo(String customNo, String userNos);

    Object queryTrainTicketUserInfoList(String customNo);

    Object querytrainTicketServiceFee(String customNo);

    Object queryTrainTicketInsuranceList(String customNo);
    
}

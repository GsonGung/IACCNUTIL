/*
 * 文 件 名:  TrainTicketServiceImpl.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月19日 上午11:28:20
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.demo.service.TrainTicketService;

/**
 * <火车票业务处理Service接口实现类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月19日 上午11:28:20]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service("trainTicketServiceImpl")
public class TrainTicketServiceImpl implements TrainTicketService
{
    /**
     * 日志封装类
     */
    public static final Log logger = LogFactory.getLog(TrainTicketServiceImpl.class);
    
    @Override
    public Object queryTrainStationList(String customNo)
    {
        logger.info("火车票航班站点查询接口");
        return null;
    }
    
    @Override
    public Object searchTrainTicketTimesList(String customNo, String fromCity, String dateTime, String toCity)
    {
        logger.info("火车票列次集合查询接口");
        return null;
    }
    
    @Override
    public Object reserveTrainTicket(String customNo, String externalOrderNo, String contactName, String contactTel,
        String departureDate, String departureStation, String destnation, String trainTimesNo, String startTime,
        String insuranceNo, String passengerInfo, String totalAmount, String trainTiketAmount, String serviceFeeAmount,
        String insuranceAmount, String otherChargesAmount)
    {
        logger.info("火车票列次预定接口");
        return null;
    }
    
    @Override
    public Object payTrainTicketOrder(String customNo, String externalOrderNo, String contactName, String contactTel,
        String departureDate, String departureStation, String destnation, String trainTimesNo, String startTime,
        String insuranceNo, String passengerInfo, String totalAmount, String trainTiketAmount, String serviceFeeAmount,
        String insuranceAmount, String otherChargesAmount)
    {
        logger.info("火车票对应列次支付接口");
        return null;
    }
    
    @Override
    public Object refundTrainTicketOrder(String customNo, String externalOrderNo, String masterOrderNo,
        String subOrderNo)
    {
        logger.info("火车票订单退订接口");
        return null;
    }
    
    @Override
    public Object changesTrainTicketOrder(String customNo, String changesBeforeExternalOrderNo,
        String changesBeforeMasterOrderNo, String changesBeforeSubOrderNo, String externalOrderNo, String contactName,
        String contactTel, String departureDate, String departureStation, String destnation, String trainTimesNo,
        String startTime, String insuranceNo, String passengerInfo, String totalAmount, String trainTiketAmount,
        String serviceFeeAmount, String insuranceAmount, String otherChargesAmount)
    {
        logger.info("火车票订单改签接口");
        return null;
    }
    
    @Override
    public Object searchTrainTicketOrderList(String customNo, String externalOrderNo, String masterOrderNo,
        String startTime, String endTime, String sortType, String orderStatus)
    {
        logger.info("查询火车票订单列表");
        return null;
    }
    
    @Override
    public Object searchTrainTicketOrderDetail(String customNo, String externalOrderNo, String masterOrderNo,
        String subOrderNo)
    {
        logger.info("查看当前用户的对应的订单详情接口");
        return null;
    }
    
    @Override
    public Object addTrainTicketUserInfo(String customNo, String passagerType, String userName, String userIdType,
        String userIdNo, String userPhone, String userBirthday, String nationality, String userLinkAddress)
    {
        logger.info("添加当前用户要绑定的火车票用户信息接口");
        return null;
    }
    
    @Override
    public Object editTrainTicketUserInfo(String customNo, String userNo, String passagerType, String userName,
        String userIdType, String userIdNo, String userPhone, String userBirthday, String nationality,
        String userLinkAddress)
    {
        logger.info("修改当前用户绑定的火车票用户信息接口");
        return null;
    }
    
    @Override
    public Object deleteTrainTicketUserInfo(String customNo, String userNos)
    {
        logger.info("批量删除当前用户绑定的火车票用户信息接口");
        return null;
    }
    
    @Override
    public Object queryTrainTicketUserInfoList(String customNo)
    {
        logger.info("查询当前用户绑定的火车票乘机人用户信息接口");
        return null;
    }
    
    @Override
    public Object querytrainTicketServiceFee(String customNo)
    {
        logger.info("查询火车票服务费信息接口");
        return null;
    }
    
    @Override
    public Object queryTrainTicketInsuranceList(String customNo)
    {
        logger.info("查询系统火车票保险信息列表接口");
        return null;
    }
    
}

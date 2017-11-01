/*
 * 文 件 名:  TrainTicketController.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月12日 下午3:15:27
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.service.TrainTicketService;


/**
 * <火车票业务处理控制类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月12日 下午3:15:27]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
@RequestMapping("/iaccnpay/trainTicket")
public class TrainTicketController extends BaseController
{
    /**
     * 日志封装类
     */
    public static final Log logger = LogFactory.getLog(TrainTicketController.class);
    
    /**
     * 火车票业务处理Service接口
     */
    @Autowired
    private TrainTicketService trainTicketService;
    
    /**
     * 
     * <火车票航班站点查询接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryTrainStationList")
    public Object queryTrainStationList(String customNo)
    {
        return trainTicketService.queryTrainStationList(customNo);
    }
    
    /**
     * 
     * <火车票列次集合查询接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @param fromCity 发车城市
     * @param DateTime 发车时间
     * @param toCity 抵达城市
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("searchTrainTicketTimesList")
    public Object searchTrainTicketTimesList(String customNo, String fromCity, String DateTime, String toCity)
    {
        return trainTicketService.searchTrainTicketTimesList(customNo, fromCity, DateTime, toCity);
    }
    
    /**
     * 
     * <火车票列次预定接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @param ExternalOrderNo 外部订单号
     * @param contactName 订票联系人姓名
     * @param contactTel 订票联系人电话
     * @param departureDate 出发日期
     * @param departureStation 出发站点
     * @param destnation 抵达站点
     * @param trainTimesNo 列车车次
     * @param startTime 发车时刻
     * @param insuranceNo 保险编号
     * @param passengerInfo 乘车人信息集合（可多个）
     * @param totalAmount 支付总金额
     * @param airTiketAmount 火车票金额
     * @param serviceFeeAmount 服务费金额
     * @param insuranceAmount 保险费用
     * @param otherChargesAmount 其他费用
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    public Object reserveTrainTicket(String customNo, String ExternalOrderNo, String contactName, String contactTel,
        String departureDate, String departureStation, String destnation, String trainTimesNo, String startTime,
        String insuranceNo, String passengerInfo,String totalAmount, String trainTiketAmount, String serviceFeeAmount,String insuranceAmount, String otherChargesAmount ){
        return trainTicketService.reserveTrainTicket(customNo, ExternalOrderNo, contactName, contactTel,
            departureDate, departureStation, destnation, trainTimesNo, startTime,
            insuranceNo, passengerInfo,totalAmount, trainTiketAmount, serviceFeeAmount, insuranceAmount, otherChargesAmount );
    }
    
    /**
     * 
     * <火车票对应列次支付接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @param ExternalOrderNo 外部订单号
     * @param contactName 订票联系人姓名
     * @param contactTel 订票联系人电话
     * @param departureDate 出发日期
     * @param departureStation 出发站点
     * @param destnation 抵达站点
     * @param trainTimesNo 列车车次
     * @param startTime 发车时刻
     * @param insuranceNo 保险编号
     * @param passengerInfo 乘车人信息集合（可多个）
     * @param totalAmount 支付总金额
     * @param airTiketAmount 飞机票金额
     * @param serviceFeeAmount 飞机票服务费金额
     * @param insuranceAmount 保险金额
     * @param otherChargesAmount 其他费用金额
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("payTrainTicketOrder")
    public Object payTrainTicketOrder(String customNo, String ExternalOrderNo, String contactName, String contactTel,
        String departureDate, String departureStation, String destnation, String trainTimesNo, String startTime,
        String insuranceNo, String passengerInfo,String totalAmount, String trainTiketAmount, String serviceFeeAmount,String insuranceAmount, String otherChargesAmount )
    {
        return trainTicketService.payTrainTicketOrder(customNo, ExternalOrderNo, contactName, contactTel,
            departureDate, departureStation, destnation, trainTimesNo, startTime,
            insuranceNo, passengerInfo,totalAmount, trainTiketAmount, serviceFeeAmount, insuranceAmount, otherChargesAmount);
    }
    
    /**
     * 
     * <火车票订单退订接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @param ExternalOrderNo 外部订单号
     * @param masterOrderNo 退票主订单号
     * @param subOrderNo 退票子订单号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("refundTrainTicketOrder")
    public Object refundTrainTicketOrder(String customNo, String ExternalOrderNo, String masterOrderNo, String subOrderNo)
    {
        return trainTicketService.refundTrainTicketOrder(customNo, ExternalOrderNo, masterOrderNo, subOrderNo);
    }
    
    /**
     * 
     * <火车票订单改签接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @param changesBeforeExternalOrderNo 外部订单号
     * @param changesBeforeMasterOrderNo 待改签主订单号
     * @param changesBeforeSubOrderNo 待改签子订单号
     * @param ExternalOrderNo 新的外部订单号
     * @param contactName 订票联系人姓名
     * @param contactTel 订票联系人电话
     * @param departureDate 出发日期
     * @param departureStation 出发站点
     * @param destnation 抵达站点
     * @param trainTimesNo 列车车次
     * @param startTime 发车时刻
     * @param insuranceNo 保险编号
     * @param passengerInfo 乘车人信息集合（可多个）
     * @param totalAmount 支付总金额
     * @param airTiketAmount 飞机票金额
     * @param serviceFeeAmount 飞机票服务费金额
     * @param insuranceAmount 保险金额
     * @param otherChargesAmount 其他费用金额
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("changesTrainTicketOrder")
    public Object changesTrainTicketOrder(String customNo, String changesBeforeExternalOrderNo, String changesBeforeMasterOrderNo, String changesBeforeSubOrderNo,String ExternalOrderNo, String contactName, String contactTel,
        String departureDate, String departureStation, String destnation, String trainTimesNo, String startTime,
        String insuranceNo, String passengerInfo,String totalAmount, String trainTiketAmount, String serviceFeeAmount,String insuranceAmount, String otherChargesAmount )
    {
        return trainTicketService.changesTrainTicketOrder(customNo, changesBeforeExternalOrderNo, changesBeforeMasterOrderNo, changesBeforeSubOrderNo,ExternalOrderNo, contactName, contactTel,
            departureDate, departureStation, destnation, trainTimesNo, startTime,
            insuranceNo, passengerInfo,totalAmount, trainTiketAmount, serviceFeeAmount,insuranceAmount, otherChargesAmount );
    }
    
    /**
     * 
     * <查询火车票订单列表>
     * <功能详细描述>
     * @param customNo 用户编号
     * @param ExternalOrderNo 外部订单号
     * @param masterOrderNo 火车票主订单号
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param sortType 排序方式，降序或什序
     * @param orderStatus 订单状态
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("searchTrainTicketOrderList")
    public Object searchTrainTicketOrderList(String customNo, String ExternalOrderNo, String masterOrderNo,
        String startTime, String endTime, String sortType, String orderStatus)
    {
        return trainTicketService.searchTrainTicketOrderList(customNo,
            ExternalOrderNo,
            masterOrderNo,
            startTime,
            endTime,
            sortType,
            orderStatus);
    }
    
    /**
     * 
     * <查看当前用户的对应的订单详情接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @param ExternalOrderNo 外部订单号
     * @param masterOrderNo 火车票主订单号
     * @param subOrderNo 火车票子订单号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("searchTrainTicketOrderDetail")
    public Object searchTrainTicketOrderDetail(String customNo,String ExternalOrderNo, String masterOrderNo,String subOrderNo )
    {
        return trainTicketService.searchTrainTicketOrderDetail(customNo,ExternalOrderNo,masterOrderNo,subOrderNo);
    }
    
    /**
     * 
     * <添加当前用户要绑定的火车票用户信息接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @param passagerType 乘车人类型（默认：成人票（满12周岁））学生票
     * @param userName 乘车人真实姓名(必须同证件名称一致)
     * @param userIdType 乘车人证件类型 （身份证;护照；港澳往返内地通行证；台湾往返内地通行证）
     * @param userIdNo 乘车人证件号码
     * @param userPhone 乘车人手机号码
     * @param userBirthday 乘车人生日 例如：yyyy-mm-dd
     * @param nationality 乘车人国籍：如中国
     * @param userLinkAddress 乘车人联系地址，便于快递
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("addTrainTicketUserInfo")
    public Object addTrainTicketUserInfo(String customNo, String passagerType, String userName, String userIdType,
        String userIdNo, String userPhone, String userBirthday, String nationality, String userLinkAddress)
    {
        return trainTicketService.addTrainTicketUserInfo(customNo,
            passagerType,
            userName,
            userIdType,
            userIdNo,
            userPhone,
            userBirthday,
            nationality,
            userLinkAddress);
    }
    
    /**
     * 
     * <修改当前用户绑定的火车票用户信息接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @param userNo 乘车人编号
     * @param passagerType 乘车人类型（默认：成人票（满12周岁））学生票
     * @param userName 乘车人真实姓名(必须同证件名称一致)
     * @param userIdType 乘车人证件类型 （身份证;护照；港澳往返内地通行证；台湾往返内地通行证）
     * @param userIdNo 乘车人证件号码
     * @param userPhone 乘车人手机号码
     * @param userBirthday 乘车人生日 例如：yyyy-mm-dd
     * @param nationality 乘车人国籍：如中国
     * @param userLinkAddress 乘车人联系地址，便于快递
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("editTrainTicketUserInfo")
    public Object editTrainTicketUserInfo(String customNo, String userNo, String passagerType, String userName,
        String userIdType, String userIdNo, String userPhone,String userBirthday, String nationality, String userLinkAddress)
    {
        return trainTicketService.editTrainTicketUserInfo(customNo,
            userNo,
            passagerType,
            userName,
            userIdType,
            userIdNo,
            userPhone,
            userBirthday,
            nationality,
            userLinkAddress);
    }
    
    /**
     * 
     * <批量删除当前用户绑定的火车票用户信息接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @param userNos 乘机人编号集合,例如：0001,0002,0003
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("deleteTrainTicketUserInfo")
    public Object deleteTrainTicketUserInfo(String customNo, String userNos)
    {
        return trainTicketService.deleteTrainTicketUserInfo(customNo, userNos);
    }
    
    /**
     * 
     * <查询当前用户绑定的火车票乘机人用户信息接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryTrainTicketUserInfoList")
    public Object queryTrainTicketUserInfoList(String customNo)
    {
        return trainTicketService.queryTrainTicketUserInfoList(customNo);
    }
    
    /**
     * 
     * <查询火车票服务费信息接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("querytrainTicketServiceFee")
    public Object querytrainTicketServiceFee(String customNo)
    {
        return trainTicketService.querytrainTicketServiceFee(customNo);
    }
    
    /**
     * 
     * <查询系统火车票保险信息列表接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryTrainTicketInsuranceList")
    public Object queryTrainTicketInsuranceList(String customNo)
    {
        return trainTicketService.queryTrainTicketInsuranceList(customNo);
    }
}

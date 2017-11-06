/*
 * 文 件 名:  AirTicketController.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月12日 下午3:13:35
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

import com.demo.service.AirTicketService;

/**
 * <飞机票业务处理控制类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月12日 下午3:13:35]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
@RequestMapping("/iaccnpay/airTicket")
public class AirTicketController extends BaseController
{
    /**
     * 日志封装类
     */
    public static final Log logger = LogFactory.getLog(AirTicketController.class);
    
    /**
     * 飞机票业务处理Service接口
     */
    @Autowired
    private AirTicketService airTicketService;
    
    /**
     * 
     * <飞机票航班站点查询接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryAirStationList")
    public Object queryAirStationList(String customNo)
    {
        return airTicketService.queryAirStationList(customNo);
    }
    
    /**
     * 
     * <飞机票航班查询接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @param fromCity 起飞城市
     * @param DateTime 起飞时间
     * @param toCity 抵达城市
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("searchAirTicketLineList")
    public Object searchAirTicketLineList(String customNo, String fromCity, String DateTime, String toCity)
    {
        return airTicketService.searchAirTicketLineList(customNo, fromCity, DateTime, toCity);
    }
    
    /**
     * 
     * <飞机票对应航班支付接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @param ExternalOrderNo 外部订单号
     * @param contactName 订票联系人姓名
     * @param contactTel 订票联系人电话
     * @param departureDate 出发日期
     * @param departureStation 出发站点
     * @param destnation 抵达站点
     * @param flightNo 航班号
     * @param companyCode 航空公司编号
     * @param insuranceNo 保险编号
     * @param totalAmount 支付总金额
     * @param airTiketAmount 飞机票金额
     * @param serviceFeeAmount 飞机票服务费金额
     * @param fuelChargeAmount 燃油费金额
     * @param machineAmount 机建费金额
     * @param insuranceAmount 保险金额
     * @param otherChargesAmount 其他费用金额
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("payAirTicketOrder")
    public Object payAirTicketOrder(String customNo, String ExternalOrderNo, String contactName, String contactTel,
        String departureDate, String departureStation, String destnation, String flightNo, String companyCode,
        String insuranceNo, String totalAmount, String airTiketAmount, String serviceFeeAmount, String fuelChargeAmount,
        String machineAmount, String insuranceAmount, String otherChargesAmount)
    {
        return airTicketService.payAirTicketOrder(customNo,
            ExternalOrderNo,
            contactName,
            contactTel,
            departureDate,
            departureStation,
            destnation,
            flightNo,
            companyCode,
            insuranceNo,
            totalAmount,
            airTiketAmount,
            serviceFeeAmount,
            fuelChargeAmount,
            machineAmount,
            insuranceAmount,
            otherChargesAmount);
    }
    
    /**
     * 
     * <退订飞机票订单接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @param ExternalOrderNo 外部订单号
     * @param masterOrderNo 退票主订单号
     * @param subOrderNo 退票子订单号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("refundAirTicketOrder")
    public Object refundAirTicketOrder(String customNo, String ExternalOrderNo, String masterOrderNo, String subOrderNo)
    {
        return airTicketService.refundAirTicketOrder(customNo, ExternalOrderNo, masterOrderNo, subOrderNo);
    }
    
    /**
     * 
     * <查询飞机票订单列表>
     * <功能详细描述>
     * @param customNo 用户编号
     * @param ExternalOrderNo 外部订单号
     * @param masterOrderNo 飞机票主订单号
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param sort 排序方式，降序或什序
     * @param orderStatus 订单状态
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("searchAirTicketOrderList")
    public Object searchAirTicketOrderList(String customNo, String ExternalOrderNo, String masterOrderNo,
        String startTime, String endTime, String sort, String orderStatus)
    {
        return airTicketService.searchAirTicketOrderList(customNo,
            ExternalOrderNo,
            masterOrderNo,
            startTime,
            endTime,
            sort,
            orderStatus);
    }
    
    /**
     * 
     * <查看当前用户的整笔订单详情接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("searchAirTicketOrderDetail")
    public Object searchAirTicketOrderDetail(String customNo)
    {
        return airTicketService.searchAirTicketOrderDetail(customNo);
    }
    
    /**
     * 
     * <添加当前用户要绑定的飞机票用户信息接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @param passagerType 乘机人类型（默认：成人票（满12周岁））
     * @param userName 乘机人姓名
     * @param userIdType 乘车人证件类型
     * @param userIdNo 乘车人证件号码
     * @param userPhone 乘车人手机号码
     * @param nationality 乘车人国籍：如中国
     * @param userLinkAddress 乘车人联系地址，便于快递
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("addAirTicketUserInfo")
    public Object addAirTicketUserInfo(String customNo, String passagerType, String userName, String userIdType,
        String userIdNo, String userPhone, String nationality, String userLinkAddress)
    {
        return airTicketService.addAirTicketUserInfo(customNo,
            passagerType,
            userName,
            userIdType,
            userIdNo,
            userPhone,
            nationality,
            userLinkAddress);
    }
    
    /**
     * 
     * <修改当前用户绑定的飞机票用户信息接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @param userNo 乘车人编号
     * @param passagerType 乘机人类型（默认：成人票（满12周岁））
     * @param userName 乘机人姓名
     * @param userIdType 乘机人证件类型
     * @param userIdNo 乘机人证件号码
     * @param userPhone 乘机人手机号码
     * @param nationality 乘机人国籍：如中国
     * @param userLinkAddress 乘机人联系地址，便于快递
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("editAirTicketUserInfo")
    public Object editAirTicketUserInfo(String customNo, String userNo, String passagerType, String userName,
        String userIdType, String userIdNo, String userPhone, String nationality, String userLinkAddress)
    {
        return airTicketService.editAirTicketUserInfo(customNo,
            userNo,
            passagerType,
            userName,
            userIdType,
            userIdNo,
            userPhone,
            nationality,
            userLinkAddress);
    }
    
    /**
     * 
     * <批量删除当前用户绑定的飞机票用户信息接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @param userNos 乘机人编号集合,例如：0001,0002,0003
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("deleteAirTicketUserInfo")
    public Object deleteAirTicketUserInfo(String customNo, String userNos)
    {
        return airTicketService.deleteAirTicketUserInfo(customNo, userNos);
    }
    
    /**
     * 
     * <查询当前用户绑定的飞机票乘机人用户信息接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryAirTicketUserInfoList")
    public Object queryAirTicketUserInfoList(String customNo)
    {
        return airTicketService.queryAirTicketUserInfoList(customNo);
    }
    
    /**
     * 
     * <查询飞机票服务费信息接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryAirTicketServiceFee")
    public Object queryAirTicketServiceFee(String customNo)
    {
        return airTicketService.queryAirTicketServiceFee(customNo);
    }
    
    /**
     * 
     * <查询系统飞机票保险信息列表接口>
     * <功能详细描述>
     * @param customNo 用户编号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryAirTicketInsuranceList")
    public Object queryAirTicketInsuranceList(String customNo)
    {
        return airTicketService.queryAirTicketInsuranceList(customNo);
    }
    
}

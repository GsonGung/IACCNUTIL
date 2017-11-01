/*
 * 文 件 名:  TakeTaxiController.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月12日 下午3:42:49
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

import com.demo.service.TakeTaxiService;

/**
 * <打车业务处理控制类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月12日 下午3:42:49]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
@RequestMapping("/iaccnpay/takeTaxi")
public class TakeTaxiController extends BaseController
{
    /**
     * 日志封装类
     */
    public static final Log logger = LogFactory.getLog(TrainTicketController.class);
    
    @Autowired
    private TakeTaxiService takeTaxiService;
    
    /**
     * 
     * <查询所支持的城市列表>
     * <功能详细描述>
     * @param customNo 当前登录用户编号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryCityList")
    public Object queryCityList(String customNo)
    {
        return takeTaxiService.queryCityList(customNo);
    }
    
    /**
     * 
     * <查询所支持的城市即将规则>
     * <功能详细描述>
     * @param customNo 当前登录用户编号
     * @param formCityName 出发城市名称
     * @param formCityId 出发城市Id
     * @param ruleType 计价模型分类(201:专车;301:快车)
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryCitysPriceInfo")
    public Object queryCitysPriceInfo(String customNo,String formCityName,String formCityId,String ruleType){
        return takeTaxiService.queryCitysPriceInfo(customNo,formCityName,formCityId,ruleType);
    }
    
    /**
     * 
     * <查询价格预估信息>
     * <功能详细描述>
     * @param customNo 当前登录用户编号
     * @param flat 出发地纬度
     * @param flng 出发地经度
     * @param tlat 目的地纬度
     * @param tlng 目的地经度
     * @param mapType 地图类型
     * @param requireLevel 车型代码(专车如：100、200等；快车如：600等)
     * @param ruleType 计价模型分类(201:专车;301:快车)
     * @param cityName 出发城市名称
     * @param cityId 出发城市ID
     * @param orderType 订单类型(0:实时单,1:预约单)
     * @param departureTime 预约单必须传(格式例如:2015-06-16 12:00:09)
     * @param pricingMode 计价模式:0:普通计价 1:一口价 默认为0
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryPriceCouponInfo")
    public Object queryPriceCouponInfo(String customNo, String flat, String flng, String tlat, String tlng,
        String mapType, String requireLevel, String ruleType, String cityName, String cityId, String orderType,
        String departureTime, String pricingMode)
    {
        return takeTaxiService.queryPriceCouponInfo(customNo,
            flat,
            flng,
            tlat,
            tlng,
            mapType,
            requireLevel,
            ruleType,
            cityName,
            cityId,
            orderType,
            departureTime,
            pricingMode);
    }
    
    /**
     * 
     * <查询预估价行程属性>
     * <功能详细描述>
     * @param customNo 当前登录用户编号
     * @param flat 出发地纬度
     * @param flng 出发地经度
     * @param tlat 目的地纬度
     * @param tlng 目的地经度
     * @param mapType 地图类型
     * @param ruleType 计价模型分类(201:专车;301:快车)
     * @param cityName 出发城市名称
     * @param cityId 出发城市ID
     * @param departureTime 出发时间(不传或者为空表示当前时间，格式例如：2015-06-16 12:00:09)
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryFeatureInfo")
    public Object queryFeatureInfo(String customNo, String flat, String flng, String tlat, String tlng, String mapType,
        String ruleType, String cityName, String cityId, String departureTime)
    {
        return takeTaxiService.queryPriceCouponInfo(customNo,
            flat,
            flng,
            tlat,
            tlng,
            mapType,
            ruleType,
            cityName,
            cityId,
            departureTime);
    }
    
    /**
     * 
     * <根据城市名称获取相关联想地址>
     * <功能详细描述>
     * @param customNo 当前登录用户编号
     * @param cityName 城市名称;例如:上海
     * @param inputName 搜索词
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryAddress")
    public Object queryAddress(String customNo, String cityName, String inputName)
    {
        return takeTaxiService.queryAddress(customNo, cityName, inputName);
    }
    
    /**
     * 
     * <坐标转城市ID>
     * <功能详细描述>
     * @param customNo 当前登录用户编号
     * @param lat 纬度
     * @param lng 经度
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryCityIdByPoi")
    public Object queryCityIdByPoi(String customNo, String lat, String lng)
    {
        return takeTaxiService.queryCityIdByPoi(customNo, lat, lng);
    }
    
    /**
     * 
     * <查询最短接驾时间预估信息>
     * <功能详细描述>
     * @param customNo 当前登录用户编号
     * @param flat 出发地纬度
     * @param flng 出发地经度
     * @param ruleType 计价模型分类(201:专车;301:快车)
     * @param requireLevel 车型代码(专车如：100、200等；快车如：600等)
     * @param passengerPhone 乘客手机号码
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryMinduration")
    public Object queryMinduration(String customNo, String flat, String flng, String ruleType, String requireLevel,
        String passengerPhone)
    {
        return takeTaxiService.queryMinduration(customNo, flat, flng, ruleType, requireLevel, passengerPhone);
    }
    
    /**
     * 
     * <发起叫车请求接口>
     * <功能详细描述>
     * @param customNo 当前登录用户编号
     * @param ruleType 计价模型分类(201:专车;301:快车)
     * @param orderType 订单类型(0:实时单,1:预约单)
     * @param passengerPhone 乘客手机号码(不填表示给自己叫车)
     * @param city 出发地城市
     * @param flat 出发地纬度
     * @param flng 出发地经度
     * @param departurePlaceName 出发地名称(最多50个字)
     * @param departurePlaceAddress 出发地详细地址(最多100个字)
     * @param tlat 目的地纬度(rule为201,301时必须)
     * @param tlng 目的地经度(rule为201,301时必须)
     * @param destinationName 目的地名称(rule为201,301时必须,最多50个字)
     * @param DestinationAddress 目的地详细地址(rule为201,301时必须,最多100个字)
     * @param currentLat 当前位置纬度
     * @param currentLng 当前位置经度
     * @param departureTime 出发时间,不传表示现在用车(例如：2015-06-16 12:00:09)
     * @param requireLevel 所需车型,车型代码(专车如：100、200等；快车如：600、900等)
     * @param appTime 客户端时间(例如:2015-06-16 12:00:09)
     * @param mapType 地图类型
     * @param comboId 套餐ID
     * @param smsPolicy 发送短信策略(0,为叫车人和乘车人都发送，1，乘车人发送叫车人不发，2乘车人不发叫车人发，3乘车人和叫车人都不发。默认-1)
     * @param extraInfo 备注
     * @param callbackInfo 透传的内容，在回调的时候会原样传递(最多100字符)
     * @param dynamicMD5 价格md5,通过 新的预估价接口获得
     * @param pricingMode 计价模式;(0:普通计价 1:一口价 默认为0)
     * @param enableLineup 是否允许排队;(0:为不允许；1,为允许。默认为0)
     * @param enableReassign 是否允许改派;(0:为不允许；1,为允许。默认为0)
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("createCallCarRequest")
    public Object createCallCarRequest(String customNo, String ruleType, String orderType, String passengerPhone,
        String city, String flat, String flng, String departurePlaceName, String departurePlaceAddress, String tlat,
        String tlng, String destinationName, String DestinationAddress, String currentLat, String currentLng,
        String departureTime, String requireLevel, String appTime, String mapType, String comboId, String smsPolicy,
        String extraInfo, String callbackInfo, String dynamicMD5, String pricingMode, String enableLineup,
        String enableReassign)
    {
        return takeTaxiService.createCallCarRequest(customNo,
            ruleType,
            orderType,
            passengerPhone,
            city,
            flat,
            flng,
            departurePlaceName,
            departurePlaceAddress,
            tlat,
            tlng,
            destinationName,
            DestinationAddress,
            currentLat,
            currentLng,
            departureTime,
            requireLevel,
            appTime,
            mapType,
            comboId,
            smsPolicy,
            extraInfo,
            callbackInfo,
            dynamicMD5,
            pricingMode,
            enableLineup,
            enableReassign);
    }
    
    /**
     * 
     * <查询打车订单详情>
     * <功能详细描述>
     * @param customNo 当前登录用户编号
     * @param orderId 订单编号
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryOrderDetail")
    public Object queryOrderDetail(String customNo, String orderId)
    {
        return takeTaxiService.queryOrderDetail(customNo, orderId);
    }
    
    /**
     * 
     * <查询历史订单集合列表>
     * <功能详细描述>
     * @param customNo 当前登录用户编号
     * @param startTime 开始时间(如:2015-05-01)
     * @param endTime 结束时间(如:2015-05-01)
     * @param pageNum 页码
     * @param isAll 是否获取全部订单(0:api订单,1:所有订单号,默认:0)
     * @param phone 乘车人手机号码,为空获取所有订单
     * @return 返回一个Object对象
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryHistoryOrderInfoList")
    public Object queryHistoryOrderInfoList(String customNo, String startTime, String endTime, String pageNum,
        String isAll, String phone)
    {
        return takeTaxiService.queryHistoryOrderInfoList(customNo, startTime, endTime, pageNum, isAll, phone);
    }
    
    /**
     * 
     * <取消订单>
     * <功能详细描述>
     * @param customNo 当前登录用户账号
     * @param orderId 订单号
     * @param force 是否强制取消(true 或 false)默认false
     * @return 返回一个Object对象 
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("canCelOrderInfo")
    public Object canCelOrderInfo(String customNo, String orderId, String force)
    {
        return takeTaxiService.canCelOrderInfo(customNo, orderId, force);
    }
    
    /**
     * 
     * <订单状态回调>
     * <功能详细描述>
     * @param customNo 当前登录用户账号
     * @param url 回调URL地址
     * @return 返回一个Object对象 
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("orderStatusBackUrl")
    public Object orderStatusBackUrl(String customNo, String url)
    {
        return takeTaxiService.orderStatusBackUrl(customNo, url);
    }
    
    /**
     * 
     * <订单支付接口>
     * <功能详细描述>
     * @param customNo 当前登录用户账号
     * @param orderId 订单编号
     * @return 返回一个Object对象 
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("payOrderInfoPrice")
    public Object payOrderInfoPrice(String customNo, String orderId)
    {
        return takeTaxiService.orderStatusBackUrl(customNo, orderId);
    }
    
    /**
     * 
     * <查询投诉选项集合>
     * <功能详细描述>
     * @param customNo 当前登录用户账号
     * @param orderId 待投诉的订单编号
     * @return 返回一个Object对象 
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("queryReasonList")
    public Object queryReasonList(String customNo, String orderId)
    {
        
        return takeTaxiService.queryReasonList(customNo, orderId);
    }
    
    /**
     * 
     * <提交投诉信息接口>
     * <功能详细描述>
     * @param customNo 当前登录的用户账号
     * @param orderId 投诉的订单号
     * @param reasonType 投诉选项编号
     * @param content 投诉选项外的其他投诉内容,不能多于40个汉字
     * @return 返回一个Object对象 
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("subComplaintInfo")
    public Object subComplaintInfo(String customNo, String orderId, String reasonType, String content)
    {
        return takeTaxiService.queryReasonList(customNo, orderId, reasonType, content);
    }
    
    /**
     * 
     * <司机评分接口>
     * <功能详细描述>
     * @param customNo 当前登录的用户账号
     * @param orderId 订单号
     * @param level 司机评分 星级(1-5)
     * @param comment 司机评价最多40个汉字
     * @return 返回一个Object对象 
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("subDriverRatingsInfo")
    public Object subDriverRatingsInfo(String customNo, String orderId, String level, String comment)
    {
        return takeTaxiService.subDriverRatingsInfo(customNo, orderId, level, comment);
    }
}

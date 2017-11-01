/*
 * 文 件 名:  PhoneRechargeServiceImpl.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月16日 下午12:55:09
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.demo.service.PhoneRechargeService;
import com.demo.utils.BaseResponseUtil;
import com.demo.utils.DateUtil;
import com.demo.utils.PhoneFormatCheckUtils;
import com.demo.utils.PropertiesUtil;

/**
 * <手机话费充值业务处理Service接口实现类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月16日 下午12:55:09]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service("phoneRechargeServiceImpl")
public class PhoneRechargeServiceImpl implements PhoneRechargeService
{
    /**
     * 运营商具体的套餐详情集合
     */
    private List<Map<String, String>> rechargePackagesMap = null;
    
    /**
     * 单个套餐Map对象
     */
    private Map<String, String> rechargePackageMap = null;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public BaseResponseUtil queryMobileOperator(String phoneNumber)
    {
        //校验手机号码是否为空
        if (StringUtils.isBlank(phoneNumber))
        {
            return BaseResponseUtil.fail("", PropertiesUtil.getReturnCodeValueByKey("参数错误,手机号码不能为空!"));
        }
        //检验参数是否合法
        boolean isPhone = PhoneFormatCheckUtils.isPhoneLegal(phoneNumber);
        if (!isPhone)
        {
            return BaseResponseUtil.fail("", PropertiesUtil.getReturnCodeValueByKey("参数错误,手机号码格式不正确!"));
        }
        //调用第三方根据手机号码查询运营商信息接口
        //判断手机号码属于哪个运营商
        //运营商名称
        String operator = null;
        //运营商编码
        String supplierCode = null;
        if (Pattern.compile("^((13[4-9])|(147)|(15[0-2,7-9])|(178)|(18[2-4,7-8]))\\d{8}$").matcher(phoneNumber).find())
        {
            operator = "中国移动";
            supplierCode = "CNYD";
        }
        else if (Pattern.compile("^((13[0-2])|(145)|(15[5-6])|(17[5-6])|(18[5-6]))\\d{8}$").matcher(phoneNumber).find())
        {
            operator = "中国联通";
            supplierCode = "CNLT";
        }
        else if (Pattern.compile("^((133)|(149)|(153)|(17[3,7])|(18[0-1,9]))\\d{8}$").matcher(phoneNumber).find())
        {
            operator = "中国电信";
            supplierCode = "CNDX";
        }
        
        //operator运营商；supplierCode运营商代码
        //输入的手机号码不正确，无法匹配中国移动，中国联通，中国电信
        if (operator == null)
        {
            return BaseResponseUtil.fail("", PropertiesUtil.getReturnCodeValueByKey("参数错误,未识别出该手机号码!"));
        }
        JSONObject json = new JSONObject();
        json.put("phone", phoneNumber);
        json.put("supplierCode", supplierCode);
        json.put("supplierName", operator);
        return BaseResponseUtil.success(json);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public BaseResponseUtil queryPhoneRechargePackage(String phoneNumber)
    {
        //校验手机号码是否为空
        if (StringUtils.isBlank(phoneNumber))
        {
            return BaseResponseUtil.fail("", PropertiesUtil.getReturnCodeValueByKey("参数错误,手机号码不能为空!"));
        }
        //检验参数是否合法
        boolean isPhone = PhoneFormatCheckUtils.isPhoneLegal(phoneNumber);
        if (!isPhone)
        {
            return BaseResponseUtil.fail("", PropertiesUtil.getReturnCodeValueByKey("参数错误,手机号码格式不正确!"));
        }
        //调用第三方根据手机号码查询运营商信息接口
        //判断手机号码属于哪个运营商
        //运营商名称
        String operator = null;
        //运营商编码
        String supplierCode = null;
        if (Pattern.compile("^((13[4-9])|(147)|(15[0-2,7-9])|(178)|(18[2-4,7-8]))\\d{8}$").matcher(phoneNumber).find())
        {
            operator = "中国移动";
            supplierCode = "CNYD";
        }
        else if (Pattern.compile("^((13[0-2])|(145)|(15[5-6])|(17[5-6])|(18[5-6]))\\d{8}$").matcher(phoneNumber).find())
        {
            operator = "中国联通";
            supplierCode = "CNLT";
        }
        else if (Pattern.compile("^((133)|(149)|(153)|(17[3,7])|(18[0-1,9]))\\d{8}$").matcher(phoneNumber).find())
        {
            operator = "中国电信";
            supplierCode = "CNDX";
        }
        
        //operator运营商；supplierCode运营商代码
        //输入的手机号码不正确，无法匹配中国移动，中国联通，中国电信
        if (operator == null)
        {
            return BaseResponseUtil.fail("", PropertiesUtil.getReturnCodeValueByKey("参数错误,未识别出该手机号码!"));
        }
        else
        {
            //根据运营商查询运营商的具体有哪些充值套餐
            rechargePackagesMap = new ArrayList<>();
            List<String> list = new ArrayList<>();
            if (CollectionUtils.isEmpty(list))
            {
                //未查到对应套餐信息
                return BaseResponseUtil.fail("", PropertiesUtil.getReturnCodeValueByKey("对不起,当前暂无对应的套餐信息!"));
            }
            else
            {
                //开始遍历套餐集合，进行数组方式存放
                for (int i = 0; i < list.size(); i++)
                {
                    rechargePackageMap = new HashMap<String, String>();
                    //rechargePackageMap.put("id", list.get(i).getId()) 
                    
                    //将单个对象存放在集合中
                    rechargePackagesMap.add(rechargePackageMap);
                }
            }
        }
        JSONObject json = new JSONObject();
        json.put("phone", phoneNumber);
        json.put("supplierCode", supplierCode);
        json.put("supplierName", operator);
        //充值套餐详情
        json.put("rechargeDetails", rechargePackagesMap);
        return BaseResponseUtil.success(json);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public BaseResponseUtil queryPhoneRechargeHistory(String phoneNumber, String startTime, String endTime,
        String softType)
    {
        // 检验参数是否合法
        if (StringUtils.isBlank(phoneNumber))
        {
            return BaseResponseUtil.fail("", PropertiesUtil.getReturnCodeValueByKey("参数错误,手机号码不能为空!"));
        }
        else
        {
            //检验参数是否合法
            boolean isPhone = PhoneFormatCheckUtils.isPhoneLegal(phoneNumber);
            if (!isPhone)
            {
                return BaseResponseUtil.fail("", PropertiesUtil.getReturnCodeValueByKey("参数错误,手机号码格式不正确!"));
            }
        }
        //开始时间不为空的情况
        if (StringUtils.isNotBlank(startTime))
        {
            //校验日期格式：2017-12-01
            try
            {
                DateUtil.parseDate(startTime);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
                return BaseResponseUtil.fail("", PropertiesUtil.getReturnCodeValueByKey("参数错误,开始时间格式不正确!"));
            }
        }
        //结束时间不为空的情况
        if (StringUtils.isNotBlank(endTime))
        {
            try
            {
                //校验日期格式：2017-12-01
                DateUtil.parseDate(endTime);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
                return BaseResponseUtil.fail("", PropertiesUtil.getReturnCodeValueByKey("参数错误,结束时间格式不正确!"));
            }
        }
        
        //开始时间和结束时间都不为空的情况
        if (StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime))
        {
            int result = Integer.valueOf(DateUtil.getSubTwoTimeYY(endTime, startTime));
            if (result < 0)
            {
                return BaseResponseUtil.fail("", PropertiesUtil.getReturnCodeValueByKey("参数错误,结束时间不能小于开始时间!"));
            }
        }
        //排序类型
        if (StringUtils.isBlank(softType))
        {
            return BaseResponseUtil.fail("", PropertiesUtil.getReturnCodeValueByKey("参数错误,开始时间不能为空!"));
        }
        else
        {
            if (!"ASC".equals(softType) && !"DESC".equals(softType))
            {
                return BaseResponseUtil.fail("", PropertiesUtil.getReturnCodeValueByKey("参数错误,参数只支持(ASC和DESC)!"));
            }
        }
        
        //查询交易记录
        List<String> historyList = new ArrayList<>();
        JSONObject json = new JSONObject();
        //充值套餐详情
        json.put("historyList", historyList);
        return BaseResponseUtil.success(json);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object payPhoneCharge(String phoneNumber,String totalAmount, String amount, String serviceCharge)
    {
        // 检验参数是否合法
        if (StringUtils.isBlank(phoneNumber))
        {
            return BaseResponseUtil.fail("", PropertiesUtil.getReturnCodeValueByKey("参数错误,手机号码不能为空!"));
        }
        else
        {
            //检验参数是否合法
            boolean isPhone = PhoneFormatCheckUtils.isPhoneLegal(phoneNumber);
            if (!isPhone)
            {
                return BaseResponseUtil.fail("", PropertiesUtil.getReturnCodeValueByKey("参数错误,手机号码格式不正确!"));
            }
        }
        
        // 检验总金额参数是否合法
        if (StringUtils.isBlank(totalAmount))
        {
            return BaseResponseUtil.fail("", PropertiesUtil.getReturnCodeValueByKey("参数错误,手机充值总金额不能为空!"));
        }
        else
        {
            //检验金额参数是否合法；大于等于0

        }
        // 检验参数是否合法
        if (StringUtils.isBlank(amount))
        {
            return BaseResponseUtil.fail("", PropertiesUtil.getReturnCodeValueByKey("参数错误,手机充值金额不能为空!"));
        }
        else
        {
            //检验金额参数是否合法；大于等于0

        }
        //检验服务费是否为空
        if(StringUtils.isBlank(serviceCharge)){
            
            return BaseResponseUtil.fail("", PropertiesUtil.getReturnCodeValueByKey("参数错误,手机充值手续费金额不能为空!"));
        }
        else
        {
            //检验金额参数是否合法；大于等于0

        }
        
        //判断用户积分是否足够
        
        //扣用户积分操作
        
        //根据系统通道配置，进行第三方充值
        JSONObject json = new JSONObject();
        //充值套餐详情：充值详情:包括用户，手机号，订单号，等信息返回
        String details ="";
        json.put("phoneRechargeDetail", details);
        return BaseResponseUtil.success(json);
    }
}

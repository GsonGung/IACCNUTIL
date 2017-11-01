/*
 * 文 件 名:  PlugManagerController.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月24日 下午5:49:54
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.demo.pojo.DataTables;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月24日 下午5:49:54]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */

@Controller
@RequestMapping("loadDataTableList")
public class PlugManagerController extends BaseController
{
    public static final Log logger = LogFactory.getLog(ApiController.class);
    
    /**
     * 获取用户信息
     *
     * @return
     * @throws IOException 
     */
    @ResponseBody
    @RequestMapping("loadDataTableList")
    public void loadDataTableList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        List<DataTables> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            DataTables dataTa= new DataTables();
            dataTa.setId(i);
            dataTa.setName("张三"+i);
            dataTa.setPhone("1525185544"+i);
            dataTa.setAddress("南京"+i+"号");
            dataTa.setEmail("30947057"+i+".com");
        }
        Map < String , Object > jsonMap = new HashMap< String , Object>();  
        jsonMap.put("list", list);
        String str = JSONObject.toJSONString(jsonMap,SerializerFeature.WriteMapNullValue);  
        System.out.println(str);  
        response.getWriter().print(str);
    }
}

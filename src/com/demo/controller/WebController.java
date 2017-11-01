/*
 * 文 件 名:  WebController.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月10日 下午1:39:05
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.controller;

/**
 * <网站调用接口处理类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月10日 下午1:39:05]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class WebController extends BaseController
{
    
    /** 
     * <默认构造函数>
     */
    public WebController()
    {
        // TODO Auto-generated constructor stub
    }
    
    public static void main(String[] args)
    {
        String softType="ASC";
        if(!"ASC".equals(softType) && !"DESC".equals(softType)){
            System.out.println("0");
        }else{
            System.out.println("1");
        }
    }
    
}

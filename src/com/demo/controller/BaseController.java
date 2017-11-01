/*
 * 文 件 名:  BaseController.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月10日 下午1:26:38
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.controller;

import com.demo.common.Constant;
import com.demo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * <公共的BASE控制类>
 * <功能详细描述>
 * 
 * @author  Andy/Gongzhuang
 * @version  [IACCN V100R001C01, 2017年7月20日 下午11:59:37]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
@RequestMapping("/base")
public class BaseController
{
    public User user = null;
    
    /**
     * 
     * <获取登录用户>
     * <功能详细描述>
     * @param session
     * @return
     * @see [类、类#方法、类#成员]
     */
    public User getLoginUser(HttpSession session)
    {
        return (User)session.getAttribute(Constant.USER_CONTEXT);
    }
    
    /**
     * 
     * <初始化Session>
     * <调用此方法，会获取session中的用户信息>
     * @param session
     * @see [类、类#方法、类#成员]
     */
    @ModelAttribute
    public void initAttribute(HttpSession session)
    {
        user = getLoginUser(session);
    }
    
}

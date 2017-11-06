package com.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.service.IApiService;
import com.demo.utils.Message;

/**
 * 
 * <API接口管理类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月10日 下午1:37:01]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
@RequestMapping("/api")
public class ApiController extends BaseController {
    public static final Log logger = LogFactory.getLog(ApiController.class);

    @Autowired
    private IApiService apiService;

    /**
     * 获取用户信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("user")
    public Object getUser() {
    	
        Message res = Message.fail();
        try {
        	if (user != null) {
                res.successWithData(user);
            } else {
                res.failWithKey("system.unloginerror");
            }
		} catch (Exception e) {
			
			res.failWithKey("system.paramerror");
		}
        return res;
    }
    
    /**
     * 采用@ResponseBody，返回的事JSON格式
     * 采用@RequestMapping,此处里面的值为项目路径后面的变量：例如：http://localhost:8080/mjbs/api/userDemo
     * @return
     */
    @ResponseBody
    @RequestMapping("userDemo")
    public Object getUserDemo() {
        Message res = Message.fail();
        try {
        	if (user != null) {
                res.successWithData(user);
            } else {
                res.failWithKey("system.unloginerror");
            }
		} catch (Exception e) {
			
			res.failWithKey("system.paramerror");
		}
        return res;
    }
    
    
    /**
     * 直接跳转页面，带参数的采用SpringMVCAndView方式
     * 跳转到WebContent下WEB-INF/views/common下test页面；此test是JSP的名字
     * 可以将test放入view中，前端可以取出test进行解析
     * @return
     */
    @RequestMapping("list")
    public ModelAndView getList() {
    	ModelAndView view = new ModelAndView();
    	view.setViewName("/common/test");
    	view.addObject("test", new Object());
    	return view;
    }
    /**
     * 直接跳转页面，无需带参数的
     * 跳转到WebContent下WEB-INF/views/common下404页面；此404是JSP的名字
     * @return
     */
    @RequestMapping("demo1")
    public String demo() {
    	return "/common/404";
    }
    
    /**
     * 直接跳转页面，需要带参数
     * 跳转到WebContent下WEB-INF/views/common下demo2页面；此demo2是JSP的名字;此处未加该页面
     * @param req
     * @return
     */
    @RequestMapping("demo2")
    public String demo(HttpServletRequest req) {
    	req.setAttribute("tt", new Object());
    	return "/common/demo2";
    }
    
    
    /**
     * 直接跳转页面，无需带参数的
     * 跳转到WebContent下WEB-INF/views/common下404页面；此404是JSP的名字
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "/pages/login/index";
    }
}

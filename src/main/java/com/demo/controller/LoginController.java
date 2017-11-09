package com.demo.controller;

import java.util.List;
import java.util.stream.Stream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.common.Constant;
import com.demo.exception.BizHandlerException;
import com.demo.exception.CaptchaException;
import com.demo.exception.ConnectException;
import com.demo.exception.DisabledCorpException;
import com.demo.pojo.User;
import com.demo.service.LoginService;

/**
 * 
 * <登录管理类>
 * <功能详细描述>
 * 
 * @author  Andy/Gongzhuang
 * @version  [IACCN V100R001C01, 2017年7月23日 上午10:15:31]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController
{
    /**
     * 日志封装类
     */
    public static final Log logger = LogFactory.getLog(LoginController.class);
    
    @Autowired
    private LoginService loginService;
    
    /**
     * 
     * <访问项目自动跳转到登录页面>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toLogin")
    public String toLogin()
    {
        return "/pages/login/index";
    }
    
    /**
     * 
     * <访问项目自动跳转到登录页面>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toLogin2")
    public String toLogin2()
    {
        return "/pages/login/index2";
    }
    
    /**
     * 
     * <退出登录>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("outToLogin")
    public String outToLogin(HttpSession session)
    {
        session.getAttribute("user");
        return "/pages/login/index";
    }
    
    /**
     * 
     * <用户登录系统>
     * <功能详细描述>
     * @param request
     * @param response
     * @return
     * @see [类、类#方法、类#成员]
     */
    @ResponseBody
    @RequestMapping(value = "/loginValidate")
    public String loginValidate(HttpServletRequest request, HttpServletResponse response, HttpSession session)
    {
        String resultJson = "";
        String emp_DomainName = request.getParameter("emp_DomainName");
        String emp_Password = request.getParameter("emp_Password");
        //记住用户名、密码功能(注意：cookie存放密码会存在安全隐患)
        String remFlag = request.getParameter("remFlag");
        logger.info(emp_DomainName + "=" + emp_Password + "=" + remFlag);
        
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(emp_DomainName, emp_Password);
        
        try
        {
            //登录验证
            subject.login(token);
            //查询数据库验证
            User user = loginService.queryUserByAccount(emp_DomainName, emp_Password);
            
            if(user == null) {
                throw new BizHandlerException("用户账户不存在");
            }
            
            //用户账号添加到Session
            session.setAttribute("user", user);
            
            List<User> userList = loginService.queryExcludeUserList(emp_DomainName);
            session.setAttribute("userList", userList);
            logger.info("userList:" + userList);
            logger.info("用户<" + user.getRealname() + ">登录系统了......");

            if ("true".equals(remFlag))
            {
                String loginInfo = emp_DomainName + "#" + emp_Password;
                Cookie userCookie = new Cookie("loginInfo", loginInfo);
                userCookie.setMaxAge(30 * 24 * 60 * 60); //存活期为一个月 30*24*60*60
                userCookie.setPath("/");
                response.addCookie(userCookie);
            }else {
                //未选中就清除对应cookie
                Cookie[] cookies = request.getCookies();
                Stream<Cookie> stream = Stream.of(cookies);
                stream.forEach(c -> {
                    if("loginInfo".equals(c.getName())) {
                        c.setMaxAge(0);
                    }
                });
            }
            
            resultJson ="0000";
        }
        catch (UnknownAccountException uae)
        {
            logger.error("对用户[" + emp_DomainName + "]进行登录验证..验证未通过,未知账户");
            uae.printStackTrace();
        }
        catch (IncorrectCredentialsException ice)
        {
            logger.error("对用户[" + emp_DomainName + "]进行登录验证..验证未通过,错误的凭证");
            ice.printStackTrace();
        }
        catch (LockedAccountException lae)
        {
            logger.error("对用户[" + emp_DomainName + "]进行登录验证..验证未通过,账户已锁定");
            lae.printStackTrace();
        }
        catch (ExcessiveAttemptsException eae)
        {
            logger.error("对用户[" + emp_DomainName + "]进行登录验证..验证未通过,错误次数过多");
            eae.printStackTrace();
        }
        catch (AuthenticationException ae)
        {
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
            logger.error("对用户[" + emp_DomainName + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
        }
        catch (Exception e)
        {
            resultJson = "0003";
            logger.error("login error", e);
            e.printStackTrace();
        }
        
        //验证是否登录成功  
        if(subject.isAuthenticated()){  
            System.out.println("用户[" + emp_DomainName + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");  
        }else{  
            token.clear();  
        }  
        
        return resultJson;
        // return "redirect:../home/toHome.do";
    }
    
    /**
     * 获取退出消息
     *
     * @param flag
     * @return
     */
    public static String getFailMsg(String flag)
    {
        String failMsg = null;
        
        if (Constant.OUT_FLAG_KICK.equals(flag))
        {
            // 跳转到登录，并弹出提示，该账号已超出最大登录人数限制，你已被踢出
            failMsg = "user.kickout";
        }
        else if (Constant.OUT_FLAG_FORCE.equals(flag))
        {
            // 跳转到登录页，提示被强制退出
            failMsg = "user.forceLogout";
        }
        else if (Constant.OUT_FLAG_NOTEXIST.equals(flag))
        {
            // 用户不存在、会话不合法
            failMsg = "user.notexist";
        }
        return failMsg;
    }
    
    /**
     * 获取失败详情并记录日志
     *
     * @param failure 异常名称
     * @return 详情
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    public static String getFailureDetail(String failure)
        throws Exception
    {
        //定义系统异常
        String exception = "system.systemerror";
        // 判断失败详情
        if (IncorrectCredentialsException.class.getName().equals(failure))
        {
            logger.error("account or password error");
            //账号或密码不正确
            exception = "user.namepwderror";
        }
        else if (UnknownAccountException.class.getName().equals(failure))
        {
            logger.error("unknown account error");
            //账号不存在
            exception = "user.notexist";
        }
        else if (ExcessiveAttemptsException.class.getName().equals(failure))
        {
            logger.error("user locked");
            
            //尝试多次，账号锁定
            exception = "user.attemplocked";
            // 登录锁定，只使用缓存处理，不更改数据库状态
        }
        else if (DisabledCorpException.class.getName().equals(failure))
        {
            logger.error("corp already locked");
            
            // 该企业已被锁定
            exception = "corp.locked";
        }
        else if (LockedAccountException.class.getName().equals(failure))
        {
            logger.error("user already locked");
            
            // 账户已被锁定
            exception = "user.locked";
        }
        else if (CaptchaException.class.getName().equals(failure))
        {
            logger.error("login captcha error");
            
            // 验证码错误
            exception = "system.captcha.error";
        }
        else if (ConnectException.class.getName().equals(failure))
        {
            logger.error("login sever connect error");
            
            // 服务器请求异常
            exception = "server.connect";
        }
        else if (Exception.class.getName().equals(failure))
        {
            logger.error("security login failed");
            
            //系统未知错误
            exception = "system.systemerror";
        }
        return exception;
    }
    
    //    @Autowired
    //    private IApiService apiService;
    
    //    /**
    //     * 获取用户信息
    //     *
    //     * @return
    //     */
    //    @ResponseBody
    //    @RequestMapping("user")
    //    public Object getUser() {
    //    	
    //        Message res = Message.fail();
    //        try {
    //        	if (user != null) {
    //                res.successWithData(user);
    //            } else {
    //                res.failWithKey("system.unloginerror");
    //            }
    //		} catch (Exception e) {
    //			
    //			res.failWithKey("system.paramerror");
    //		}
    //        return res;
    //    }
    //    
    //    /**
    //     * 采用@ResponseBody，返回的事JSON格式
    //     * 采用@RequestMapping,此处里面的值为项目路径后面的变量：例如：http://localhost:8080/mjbs/api/userDemo
    //     * @return
    //     */
    //    @ResponseBody
    //    @RequestMapping("userDemo")
    //    public Object getUserDemo() {
    //        Message res = Message.fail();
    //        try {
    //        	if (user != null) {
    //                res.successWithData(user);
    //            } else {
    //                res.failWithKey("system.unloginerror");
    //            }
    //		} catch (Exception e) {
    //			
    //			res.failWithKey("system.paramerror");
    //		}
    //        return res;
    //    }
    //    
    //    
    //    /**
    //     * 直接跳转页面，带参数的采用SpringMVCAndView方式
    //     * 跳转到WebContent下WEB-INF/views/common下test页面；此test是JSP的名字
    //     * 可以将test放入view中，前端可以取出test进行解析
    //     * @return
    //     */
    //    @RequestMapping("list")
    //    public ModelAndView getList() {
    //    	ModelAndView view = new ModelAndView();
    //    	view.setViewName("/common/test");
    //    	view.addObject("test", new Object());
    //    	return view;
    //    }
    //    /**
    //     * 直接跳转页面，无需带参数的
    //     * 跳转到WebContent下WEB-INF/views/common下404页面；此404是JSP的名字
    //     * @return
    //     */
    //    @RequestMapping("demo1")
    //    public String demo() {
    //    	return "/common/404";
    //    }
    //    
    //    /**
    //     * 直接跳转页面，需要带参数
    //     * 跳转到WebContent下WEB-INF/views/common下demo2页面；此demo2是JSP的名字;此处未加该页面
    //     * @param req
    //     * @return
    //     */
    //    @RequestMapping("demo2")
    //    public String demo(HttpServletRequest req) {
    //    	req.setAttribute("tt", new Object());
    //    	return "/common/demo2";
    //    }
    //    
    //    
    //    /**
    //     * 直接跳转页面，无需带参数的
    //     * 跳转到WebContent下WEB-INF/views/common下404页面；此404是JSP的名字
    //     * @return
    //     */
    //    @RequestMapping("toLogin")
    //    public String toLogin() {
    //        return "/pages/login/index";
    //    }
}

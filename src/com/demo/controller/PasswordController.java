/*
 * 文 件 名:  HomeController.java
 * 版    权:  AndyGong (SHANGHAI), INC.
 * 描    述:  <系统主页面>
 * 修 改 人:  Andy/Gongzhuang
 * 修改时间:  2017年7月23日 下午5:07:59
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.filter.config.ConfigTools;
import com.demo.utils.JsonUtil;

/**
 * 
 * <接口数据库连接密码加解密类>
 * <功能详细描述>
 * 
 * @author  Andy/Gongzhuang
 * @version  [IACCN V100R001C01, 2017年7月23日 上午10:15:31]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
@RequestMapping("/password")
public class PasswordController extends BaseController
{
    /**
     * 日志封装类
     */
    public static final Log logger = LogFactory.getLog(PasswordController.class);
    
    /**
     * 
     * <加密方法>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @ResponseBody
    @RequestMapping("/encryptPwd")
    public void toEncryptPwd(HttpServletRequest request, HttpServletResponse response)
    {
        String returnCode = "0000";
        String resultJson = "";
        //加密后的密文
        String password = "";
        String publicKey = "";
        String privateKey = "";
        String emp_Password = request.getParameter("emp_Password");
        if ("".equals(emp_Password) || null == emp_Password)
        {
            returnCode = "0001";
        }
        else
        {
            String[] keyPair;
            try
            {
                keyPair = ConfigTools.genKeyPair(512);
                //私钥
                privateKey = keyPair[0];
                //公钥
                publicKey = keyPair[1];
                //加密后的密码
                password = ConfigTools.encrypt(privateKey, emp_Password);
                returnCode = "0000";
            }
            catch (Exception e)
            {
                e.printStackTrace();
                returnCode = "0002";
            }
            
        }
        resultJson =
            "{'returnCode':'" + returnCode + "','password':'" + password + "','publicKey':'" + publicKey + "'}";
        JsonUtil.writeJson(response,resultJson);
    }
    
    /**
     * 
     * <数据解密方法>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @ResponseBody
    @RequestMapping("/decryptPwd")
    public void toDecryptPwd(HttpServletRequest request, HttpServletResponse response)
    {
        String returnCode = "0000";
        String resultJson = "";
        //加密后的密文
        String password = "";
        String pwdMiWen = request.getParameter("pwdMiWen");
        String pubkeyMiWen = request.getParameter("pubkeyMiWen");
        System.out.println(pwdMiWen);
        System.out.println(pubkeyMiWen);
        if ("".equals(pwdMiWen) || null == pwdMiWen)
        {
            returnCode = "0001";
        }
        else if ("".equals(pubkeyMiWen) || null == pubkeyMiWen)
        {
            returnCode = "0002";
        }
        else
        {
            try
            {
                //加密后的密码
                password = ConfigTools.decrypt(pubkeyMiWen, pwdMiWen);
                returnCode = "0000";
            }
            catch (Exception e)
            {
                e.printStackTrace();
                returnCode = "0003";
            }
            
        }
        System.out.println("解密后的密码为："+password);
        resultJson = "{'returnCode':'" + returnCode + "','password':'" + password + "'}";
        JsonUtil.writeJson(response,resultJson);
    }
    
}

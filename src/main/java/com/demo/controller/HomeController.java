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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.demo.pojo.Menu;
import com.demo.pojo.User;
import com.demo.service.IHomeService;

/**
 * 
 * <系统主页管理类>
 * <功能详细描述>
 * 
 * @author  Andy/Gongzhuang
 * @version  [IACCN V100R001C01, 2017年7月23日 上午10:15:31]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController
{
    /**
     * 日志封装类
     */
    public static final Log logger = LogFactory.getLog(HomeController.class);
    
    @Autowired
    private IHomeService iHomeService;
    
    /**
     * 
     * <访问项目主页面>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toHome")
    public String toLogin()
    {
        return "/pages/home/index";
    }
    /**
     * 
     * <访问项目自动跳转到登录页面>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toDemo11")
    public String toDemo11()
    {
        return "/pages/content/demo";
    }
    /**
     * 
     * <访问项目主页面内容区>
     * <功能详细描述>
     * @return 路径
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toContent")
    public String toContent()
    {
        return "/pages/content/index";
    }
    
    @RequestMapping("toPassword")
    public String toPasswordGenerator()
    {
        return "/pages/content/passwordGenerator";
    } 
    /**
     * 
     * <访问项目自动跳转到登录页面>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toDBInfoManage")
    public String toDBInfoManage()
    {
        return "/pages/content/dbInfoManage";
    }
    
    /**
     * 
     * <加载菜单列表>
     * <功能详细描述>
     * @return
     * @throws UnsupportedEncodingException 
     * @see [类、类#方法、类#成员]
     */
    
    @ResponseBody
    @RequestMapping("/toLoadMenuList")
    public void toLoadMenuList(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException
    {
        
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        List<Menu> list = new ArrayList<>();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        list = iHomeService.toLoadMenuList(user.getUsername());
        Map < String , Object > jsonMap = new HashMap< String , Object>();  
        jsonMap.put("list", list);
        String str = JSONObject.toJSONString(jsonMap,SerializerFeature.WriteMapNullValue);  
        System.out.println(str);  
        response.getWriter().print(str);
    }
    
    /**
     * 
     * <访问项目自动跳转到插件页面>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toPlugManage")
    public String toPlugManage()
    {
        return "/pages/content/plugManage";
    }
    
    /**
     * 
     * <访问个人工作台V1>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toDashboardV1")
    public String toDashboardV1()
    {
        return "/pages/dashboard/index";
    }
    
    /**
     * 
     * <访问个人工作台V2>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toDashboardV2")
    public String toDashboardV2()
    {
        return "/pages/dashboard/index2";
    }
    
    /**
     * 
     * <toTopNavigation>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toTopNavigation")
    public String toTopNavigation()
    {
        return "/pages/layout/top-nav";
    }
    
    /**
     * 
     * <toBoxed>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toBoxed")
    public String toBoxed()
    {
        return "/pages/layout/boxed";
    }
    
    /**
     * 
     * <toFixed>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toFixed")
    public String toFixed()
    {
        return "/pages/layout/fixed";
    }
    
    /**
     * 
     * <toCollapsedSidebar>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toCollapsedSidebar")
    public String toCollapsedSidebar()
    {
        return "/pages/layout/collapsed-sidebar";
    }
    
    /**
     * 
     * <toWidgets>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toWidgets")
    public String toWidgets()
    {
        return "/pages/widgets/widgets";
    }
    
    /**
     * 
     * <toChartJS>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toChartJS")
    public String toChartJS()
    {
        return "/pages/charts/chartjs";
    }
    
    /**
     * 
     * <toMorris>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toMorris")
    public String toMorris()
    {
        return "/pages/charts/morris";
    }
    
    /**
     * 
     * <toFlot>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toFlot")
    public String toFlot()
    {
        return "/pages/charts/flot";
    }
    
    /**
     * 
     * <toInlineCharts>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toInlineCharts")
    public String toInlineCharts()
    {
        return "/pages/charts/inline";
    }
    
    /**
     * 
     * <toGeneral>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toGeneral")
    public String toGeneral()
    {
        return "/pages/UI/general";
    }
    
    /**
     * 
     * <toIcons>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toIcons")
    public String toIcons()
    {
        return "/pages/UI/icons";
    }
    
    /**
     * 
     * <toButtons>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toButtons")
    public String toButtons()
    {
        return "/pages/UI/buttons";
    }
    
    /**
     * 
     * <toSliders>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toSliders")
    public String toSliders()
    {
        return "/pages/UI/sliders";
    }
    
    /**
     * 
     * <toTimeline>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toTimeline")
    public String toTimeline()
    {
        return "/pages/UI/timeline";
    }
    
    /**
     * 
     * <toModals>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toModals")
    public String toModals()
    {
        return "/pages/UI/modals";
    }
    
    /**
     * 
     * <toGeneralElements>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toGeneralElements")
    public String toGeneralElements()
    {
        return "/pages/forms/general";
    }
    
    /**
     * 
     * <toAdvancedElements>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toAdvancedElements")
    public String toAdvancedElements()
    {
        return "/pages/forms/advanced";
    }
    
    /**
     * 
     * <toEditors>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toEditors")
    public String toEditors()
    {
        return "/pages/forms/editors";
    }
    
    /**
     * 
     * <toSimpleTables>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toSimpleTables")
    public String toSimpleTables()
    {
        return "/pages/tables/simple";
    }
    
    /**
     * 
     * <toSimpleTables>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toDataTables")
    public String toDataTables()
    {
        return "/pages/tables/data";
    }
    
    /**
     * 
     * <toCalendar>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toCalendar")
    public String toCalendar()
    {
        return "/pages/calendar/calendar";
    }
    
    /**
     * 
     * <toInbox>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toInbox")
    public String toInbox()
    {
        return "/pages/mailbox/mailbox";
    }
    
    /**
     * 
     * <toCompose>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toCompose")
    public String toCompose()
    {
        return "/pages/mailbox/compose";
    }
    
    /**
     * 
     * <toRead>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toRead")
    public String toRead()
    {
        return "/pages/mailbox/read-mail";
    }
    
    /**
     * 
     * <toInvoice>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toInvoice")
    public String toInvoice()
    {
        return "/pages/examples/invoice";
    }
    
    /**
     * 
     * <toProfile>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toProfile")
    public String toProfile()
    {
        return "/pages/examples/profile";
    }
    
    /**
     * 
     * <toLogin>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toLogin")
    public String toExampleLogin()
    {
        return "/pages/examples/login";
    }
    
    /**
     * 
     * <toRegister>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toRegister")
    public String toRegister()
    {
        return "/pages/examples/register";
    }
    
    /**
     * 
     * <toLockscreen>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toLockscreen")
    public String toLockscreen()
    {
        return "/pages/examples/lockscreen";
    }
    
    /**
     * 
     * <to404Error>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("to404Error")
    public String to404Error()
    {
        return "/pages/examples/404";
    }
    
    /**
     * 
     * <to500Error>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("to500Error")
    public String to500Error()
    {
        return "/pages/examples/500";
    }
    
    /**
     * 
     * <toBlankPage>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toBlankPage")
    public String toBlankPage()
    {
        return "/pages/examples/blank";
    }
    
    /**
     * 
     * <toPacePage>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toPacePage")
    public String toPacePage()
    {
        return "/pages/examples/pace";
    }
    
    /**
     * 
     * <toDocumentation>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
/*    @RequestMapping("toDocumentation")
    public String toDocumentation()
    {
        return "/pages/examples/pace";
    }*/
    
    /**
     * 
     * <toRoleManager>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("toRoleManager")
    public String toRoleManager()
    {
        return "/pages/role/list";
    }
    
}

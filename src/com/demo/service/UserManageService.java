/*
 * 文 件 名:  UserManageService.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年10月20日 下午4:27:12
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.service;

/**
 * <平台用户管理Service接口>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月20日 下午4:27:12]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface UserManageService
{

    Object queryUserInfo(String customNo, String userType);
    
}

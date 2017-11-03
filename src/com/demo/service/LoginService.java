/*
 * 文 件 名:  LoginService.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  龚结铎/andrew
 * 修改时间:  2017年11月2日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.service;

import java.util.List;

import com.demo.pojo.User;

/**
 * <登录服务类>
 * <功能详细描述>
 * 
 * @author  龚结铎/andrew
 * @version  [YOUFULI V300R001C01, 2017年11月2日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface LoginService
{
    /**
     * 
     * <根据账号密码查询用户信息>
     * <功能详细描述>
     * @param username
     * @return
     * @see [类、类#方法、类#成员]
     */
    User queryUserByAccount(String username, String password);
    
    /**
     * 
     * <查询用户列表>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    List<User> queryUserList();

    /**
     * 
     * <查询除当前之外的其他用户列表>
     * <功能详细描述>
     * @param username
     * @return
     * @see [类、类#方法、类#成员]
     */
    List<User> queryExcludeUserList(String username);
}

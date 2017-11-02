/*
 * 文 件 名:  LoginServiceImpl.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  龚结铎/andrew
 * 修改时间:  2017年11月2日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserDao;
import com.demo.pojo.User;
import com.demo.service.LoginService;

/**
 * <登录服务实现类>
 * <功能详细描述>
 * 
 * @author  龚结铎/andrew
 * @version  [YOUFULI V300R001C01, 2017年11月2日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService
{
    @Autowired
    private UserDao userDao;
    
    @Override
    public User queryUserByAccount(String username, String password)
    {
        return userDao.selectByAccount(username, password);
    }

    @Override
    public List<User> queryUserList()
    {
        return userDao.findUsers();
    }

}

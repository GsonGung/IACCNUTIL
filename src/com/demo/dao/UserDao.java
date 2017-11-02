/*
 * 文 件 名:  UserDao.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  龚结铎/andrew
 * 修改时间:  2017年11月2日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.pojo.User;

/**
 * <用户表Dao接口>
 * <功能详细描述>
 * 
 * @author  龚结铎/andrew
 * @version  [YOUFULI V300R001C01, 2017年11月2日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface UserDao
{
    User selectByAccount(@Param("username") String username, @Param("password") String password);

    List<User> findUsers();
}

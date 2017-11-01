/*
 * 文 件 名:  HomeDao.java
 * 版    权:  YOU-FULI (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  AndyGong
 * 修改时间:  2017年8月27日 下午2:08:23
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.dao;

import java.util.List;

import com.demo.pojo.Menu;

/**
 * <主页Dao接口>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年8月27日 下午2:08:23]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface HomeDao
{

    List<Menu> toLoadMenuList();
    
}

package com.demo.service;

import java.util.List;

import com.demo.pojo.Menu;

/**
 * Created by XiangCheng
 * Date: 2017/6/14
 */
public interface IHomeService {

    List<Menu> toLoadMenuList(String username);

}

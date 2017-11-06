package com.demo.service.impl;

import com.demo.dao.HomeDao;
import com.demo.pojo.Menu;
import com.demo.service.IHomeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by XiangCheng
 * Date: 2017/6/14
 */
@Service("homeService")
public class HomeService implements IHomeService {

    @Autowired
    private HomeDao homeDao;
    
    @Override
    public List<Menu> toLoadMenuList()
    {
        // TODO Auto-generated method stub
        return homeDao.toLoadMenuList();
    }

}

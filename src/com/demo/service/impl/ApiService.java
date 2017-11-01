package com.demo.service.impl;

import com.demo.dao.CorpDao;
import com.demo.service.IApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by XiangCheng
 * Date: 2017/6/15
 */
@Service("apiService")
public class ApiService implements IApiService {

    @Autowired
    private CorpDao corpDao;
}

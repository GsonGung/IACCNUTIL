package com.demo.service.impl;

import com.demo.dao.CorpDao;
import com.demo.service.ICorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by XiangCheng
 * Date: 2017/6/19
 */
@Service("corpService")
public class CorpService implements ICorpService {
    @Autowired
    private CorpDao corpDao;

    public void saveCorps() throws IOException {
    }
}

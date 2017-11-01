package com.demo.service.impl;

import com.demo.common.Constant;
import com.demo.dao.OperLogDao;
import com.demo.pojo.OperLog;
import com.demo.service.IOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by XiangCheng
 * Date: 2017/6/14
 */
@Service("operLogService")
public class OperLogService implements IOperLogService {

    @Autowired
    private OperLogDao operLogDao;

    @Override
    public void add(OperLog log) {
        operLogDao.insert(log);
    }

    @Override
    public void success(int type, String content, String remark) {
        OperLog log = new OperLog(Constant.OperLog.SUCCESS, (byte) type, content, remark);
        operLogDao.insert(log);
    }

    @Override
    public void fail(int type, String content, String remark) {
        OperLog log = new OperLog(Constant.OperLog.FAIL, (byte) type, content, remark);
        operLogDao.insert(log);
    }
}

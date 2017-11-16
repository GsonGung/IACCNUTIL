package com.demo.dao;

import com.demo.pojo.OperLog;

public interface OperLogDao {
    int deleteByPrimaryKey(Integer id);

    int insert(OperLog record);

    OperLog selectByPrimaryKey(Integer id);
}